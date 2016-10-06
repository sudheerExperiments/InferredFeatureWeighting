package test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OddsRatio
{
    
    public static void oddsRatio() throws FileNotFoundException, IOException
    {
        BufferedReader br,br1;
        int i=0,j=0;
        int N1=0,N2=0,Nk=0;
        String s1,s2;
        String[][] arr1;
        String[][] arr2;
        BufferedWriter bw;

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

bw=new BufferedWriter(new FileWriter(new File("C:/Users/phantom/Desktop/project/Calculations/Odds Ratio.txt")));

for(int k=0;k<content.length();k++)
{
    float orP=0,orN=0;
    float or1,or2;
    if(arr1[k][0]!=null && arr2[k][0]!=null)
    {
       
        float a=Float.parseFloat(arr1[k][1]);
        float b=Float.parseFloat(arr2[k][1]);
        float m=N1+N2;
        Nk=N1;
        or1=(a*(m-Nk-b))/((Nk-a)*b);
        Nk=N2;
        or2=(b*(m-Nk-a))/((Nk-b)*a);
        orP=(float)Math.log10(or1);
        orN=(float)Math.log10(or2);
        
   System.out.println(arr1[k][0] + "," + or1 + "," + or2 + "," + orP + "," + orN + "====>" + Math.max(orP,orN));
    bw.write(arr1[k][0].trim());
    bw.write(",");
    //bw.write(orP+"");
    //bw.write(",");
    //bw.write(orN+"");
    //bw.write(",");
    bw.write(Math.max(orP,orN) + "");
    bw.newLine();
   }
   }
bw.close();
    }
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        oddsRatio();
    }
}
