package test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WeightedFrequencyAndOdds
{
    
    public static void weightedFrequencyAndOdds() throws FileNotFoundException, IOException
    {
        BufferedReader br,br1;
        int i=0,j=0;
        int N1=0,N2=0,Nk=0;
        String s1,s2;
        String[][] arr1;
        String[][] arr2;
        BufferedWriter bw;

Scanner sc=new Scanner(System.in);
System.out.println("Enter Lamda value:");
double L=sc.nextDouble();
        
N1=new File("C:/Users/phantom/Desktop/project/input dataset/pos").listFiles().length;
N2=new File("C:/Users/phantom/Desktop/project/input dataset/neg").listFiles().length;

File folder = new File("C:/Users/phantom/Desktop/project/bucket of words count in all files1/all files bow count.txt");
File folder1 = new File("C:/Users/phantom/Desktop/project/bucket of words count in all files2/all files bow count.txt");
String content = new Scanner(folder).useDelimiter("\\Z").next();
String content1 = new Scanner(folder1).useDelimiter("\\Z").next();
arr1=new String[content.length()][2];
arr2=new String[content1.length()][2];

br=new BufferedReader(new FileReader(folder));

while((s1=br.readLine())!=null)
{
    arr1[i]=s1.split(",");
    i++;
}

br1=new BufferedReader(new FileReader(folder1));

while((s2=br1.readLine())!=null)
{
    arr2[j]=s2.split(",");
    j++;    
}

bw=new BufferedWriter(new FileWriter(new File("C:/Users/phantom/Desktop/project/Calculations/Weighted Frequency And Odds.txt")));

for(int k=0;k<content.length();k++)
{
    float wfo1,wfo2;
    if(arr1[k][0]!=null && arr2[k][0]!=null)
    {
       
        double a=Float.parseFloat(arr1[k][1]);
        double b=Float.parseFloat(arr2[k][1]);
        double m=N1+N2;
        
        Nk=N1;
        double temp=(a*(m-Nk));
        double temp1=b*Nk;
        double temp2=Math.pow(temp/temp1,1-L);
        double temp3=Math.log10(temp2);
        double temp4=a/Nk;
        double temp5=Math.pow(temp4, L);
        wfo1=(float)(temp5 * temp3);
        
        Nk=N2;
        double tem=(b*(m-Nk));
        double tem1=a*Nk;
        double tem2=Math.pow(tem/tem1,1-L);
        double tem3=Math.log10(tem2);
        double tem4=b/Nk;
        double tem5=Math.pow(tem4, L);
        wfo2=(float)(tem5 * tem3);
        
   System.out.println(arr1[k][0] + "," + wfo1 + "," + wfo2 + "," + "====>" + Math.max(wfo1,wfo2));
    bw.write(arr1[k][0].trim());
    bw.write(",");
    //bw.write(orP+"");
    //bw.write(",");
    //bw.write(orN+"");
    //bw.write(",");
    bw.write(Math.max(wfo1,wfo2) + "");
    bw.newLine();
   }
   }
bw.close();
    }
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        weightedFrequencyAndOdds();
    }
}
