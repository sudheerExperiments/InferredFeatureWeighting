package test1;

import java.io.*;
import java.util.*;

public class StopWordsRemoval1
{
    public static void stopWordsRemoval1()
    {
        String fileWords,stopWords;
        String fileList[];
        String[] temp;
        String[] temp1;
        BufferedWriter bw;
        File folder = new File("C:/Users/phantom/Desktop/project/splitted dataset2");
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
        try
        {
            for(int k=0;k<fileList.length;k++)
            {
                fileWords = new Scanner(new File("C:/Users/phantom/Desktop/project/splitted dataset2/" + fileList[k])).useDelimiter("\\Z").next();
                //System.out.println(fileWords);
                temp=new String[fileWords.length()];
                temp=fileWords.split("\\n");
                stopWords = new Scanner(new File("C:/Users/phantom/Desktop/project/stop words/stopwords english.txt")).useDelimiter("\\Z").next();
                //System.out.println(stopWords);
                temp1=new String[stopWords.length()];
                temp1=stopWords.split("\\n");                 
                for(int i=0;i<temp.length;i++)
                {
                    for(String j:temp1)
                    {
                        if(temp[i].equals(j))
                        {
                            temp[i]="abc";
                            continue;
                        }
              
                    }
                }                
    bw=new BufferedWriter(new FileWriter("C:/Users/phantom/Desktop/project/stopwords removed dataset2/" + fileList[k]));
    for (String temp2 : temp) 
    {
        if(temp2!="abc")
        {
            temp2=temp2.trim();
            bw.write(temp2);
            bw.newLine();
            //System.out.println(temp2);
        }
    }                 
    bw.close();       
          }
    }
 catch(Exception e)
    {}
     
    }
    
public static void main(String[] args)
{
    stopWordsRemoval1();
}

}

