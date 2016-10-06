/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.io.*;
import java.util.*;
import java.io.IOException;
 
public class test1 
{
   public static void test1()
    {
        PrintWriter pw;
        String[] fileList;
        String[] token;
        
        //Selects list of files in a folder
        File folder = new File("C:/Users/phantom/Desktop/project/input dataset/pos/");
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
        
        //Reads content from each file and converts in to tokens
        try 
        {
            for(int k=0;k<fileList.length;k++)
                {
                    String content = new Scanner(new File("C:/Users/phantom/Desktop/project/input dataset/pos/" + fileList[k])).useDelimiter("\\Z").next();
                    StringTokenizer st = new StringTokenizer(content, " \t\n\r\f,.:;?![]<>()-/\"");                    
                    pw=new PrintWriter("C:/Users/phantom/Desktop/project/splitted dataset1/" + fileList[k]);

                    token=new String[content.length()];
                    for(int i=0;i<st.countTokens();i++)
                        {
                            while(st.hasMoreTokens())
                                {
                                    token[i]=(String)st.nextToken();
                                    i++;
                                }
                        }
        
        //Writes content into a new file
        for(int j=0;j<content.length();j++)
         {
            if(token[j]!=null)
            {
                //System.out.println(token[j]);
                pw.println(token[j].trim());
            }
         }
        if(pw!=null)
            pw.close();
                }       
}
catch(IOException ioe)
{
    ioe.printStackTrace();
}
catch(Exception e)
{}
    }
public static void main(String[] args) throws IOException
{
  test1();
}
}

