package test1.Extra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class bowWordsCount
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        String str,s[][];
        int i=0,total=0;
        BufferedReader br=new BufferedReader(new FileReader(new File("C:/Users/phantom/Desktop/project/bucket of words/bucketOfWords.txt")));
        String content = new Scanner(new File("C:/Users/phantom/Desktop/project/bucket of words/bucketOfWords.txt")).useDelimiter("\\Z").next();
        s=new String[content.length()][2];
        while((str=br.readLine())!=null)
        {
           s[i]=str.split(",");
           i++;
        }
        for(int j=0;j<content.length();j++)
           {
               if(s[j][1]!=null)
               {
               if(Integer.parseInt(s[j][1])>=2000)
               {
                   System.out.println(s[j][0] + ":" + s[j][1]);
            //int temp=Integer.parseInt(s[j][1].trim());
            //total+=temp;
               }
               }
           }
        //System.out.println(total);
        br.close();
    }
        
}