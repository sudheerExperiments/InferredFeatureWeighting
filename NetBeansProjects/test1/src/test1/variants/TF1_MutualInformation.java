package test1.variants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TF1_MutualInformation
{
    public static void tf1_MutualInformation() throws FileNotFoundException, IOException
    {
        BufferedReader br,br1;
        BufferedWriter bw;
        String[] fileList;
        String[][] token;
        String arr1[][];
        String s1,s2;
        int i=0,l=0;
File folder = new File("C:/Users/phantom/Desktop/project/unique stopwords removed dataset2");
File[] listOfFiles = folder.listFiles();
fileList=new String[listOfFiles.length];
for (int k = 0; k < listOfFiles.length; k++) 
 {
  if (listOfFiles[k].isFile()) 
  {
   fileList[k]=(String)listOfFiles[k].getName();
   //System.out.println("File " + listOfFiles[k].getName());
  } 
   }
br=new BufferedReader(new FileReader(new File("C:/Users/phantom/Desktop/project/calculations/Mutual Information.txt")));
String content = new Scanner(new File("C:/Users/phantom/Desktop/project/calculations/Mutual Information.txt")).useDelimiter("\\Z").next();
token=new String[content.length()][2];
while((s1=br.readLine())!=null)
{
    token[i]=s1.split(",");
    //System.out.println(token[i][0] + "," + token[i][1]);
    i++;
}

for(int j=0;j<fileList.length;j++)
{
    l=0;
    br1=new BufferedReader(new FileReader(new File("C:/Users/phantom/Desktop/project/unique stopwords removed dataset2/" + fileList[j])));
    String content1 = new Scanner(new File("C:/Users/phantom/Desktop/project/unique stopwords removed dataset2/" + fileList[j])).useDelimiter("\\Z").next();
    arr1=new String[content1.length()][2];
    while((s2=br1.readLine())!=null)
    {
        arr1[l]=s2.split(",");
        l++;
    }
       bw=new BufferedWriter(new FileWriter(new File("C:/Users/phantom/Desktop/project/calculations/variants/TF2_MutualInformation/" + fileList[j])));
   for(int m=0;m<l;m++)
    {
      
     for(int n=0;n<i;n++)
        {
            //System.out.println(token[m][0] + "::::" + arr1[n][0]);
        if(token[n][0].equals(arr1[m][0]))
                {
                   float logTF=(float)(1+Math.log10(Float.parseFloat(arr1[m][1])));
                   float temp=logTF*Float.parseFloat(token[n][1]);
                   System.out.println(temp);
                   if(Float.isNaN(temp) || Float.isInfinite(temp))
                   {
                    temp=0.0f;
                   }
                   bw.write(arr1[m][0]);
                   bw.write(",");
                   bw.write(temp + "");
                   bw.newLine();
                }
    }
    
       }
    bw.close();
}
    }
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        tf1_MutualInformation();
    } 
}


