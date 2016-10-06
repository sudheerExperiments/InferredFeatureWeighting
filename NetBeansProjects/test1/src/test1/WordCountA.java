package test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WordCountA
{
public static BufferedWriter bw;

public static void wordCount1() throws IOException
{
    String[] fileList;
    BufferedReader br1;
    File f,f1;
    String s1,s2;
    int i=0,b=42678,count;
    String[][] arr1,arr3;
    String[][] arr2;
    
    bw=new BufferedWriter(new FileWriter(new File("C:/Users/phantom/Desktop/project/bucket of words count in all files1/all files bow countA.txt")));
    File folder = new File("C:/Users/phantom/Desktop/project/unique stopwords removed dataset1");
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
    
    String content = new Scanner(new File("C:/Users/phantom/Desktop/project/bucket of words/bucketOfWords.txt")).useDelimiter("\\Z").next();
    f1=new File("C:/Users/phantom/Desktop/project/bucket of words/bucketOfWords.txt");
    br1=new BufferedReader(new FileReader(f1));    //Bucket of words
    arr3=new String[content.length()][2];
    arr1=new String[970][2];

    while((s1=br1.readLine())!=null)
    {
        arr3[i]=s1.split(",");
        i++;
        
    }
    br1.close();
    
    for(int a=0;a<arr1.length;a++)
    {
        arr1[a]=arr3[b];
        b++;
    }

   for (int k = 0; k < arr1.length; k++)    //bucket of words
    {
        count=0;
    
        for(int m=0;m<fileList.length;m++)
        {
            String content1 = new Scanner(new File("C:/Users/phantom/Desktop/project/unique stopwords removed dataset1/" + fileList[m])).useDelimiter("\\Z").next();
            arr2=new String[content1.length()][2];
            f=new File("C:/Users/phantom/Desktop/project/unique stopwords removed dataset1/" + fileList[m]);
            //System.out.println(fileList[m]);
            BufferedReader br2=new BufferedReader(new FileReader(f));     //Stop words removed files
            int temp=0;
            while((s2=br2.readLine())!=null)
            {
                arr2[temp]=s2.split(",");
                //System.out.println(arr2[temp][0]);
                temp++;
            }

            for (int l = 0; l < temp; l++)    //stop words removed files
            {
                if(arr2[l][0].equals(arr1[k][0]))
                {
                    count++;
                    //System.out.println("bucket of word count:" + arr1[k]);
                    //System.out.println("count:" + count);
                
                }
            
            }
            br2.close();
    
        }
    if(arr1[k][0]!=null)
    {
        bw.write((arr1[k][0] + "," + count).trim());
        bw.newLine();
    }
    }
    bw.close();
     
}
public static void main(String[] args) throws FileNotFoundException, IOException
    {
        wordCount1();
    }
}

