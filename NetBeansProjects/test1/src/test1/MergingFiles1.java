package test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class MergingFiles1
{
    public static void mergingFiles1() throws FileNotFoundException
    {
        String[] fileList;
        String s;
        String[][] aLine;
        File folder = new File("C:/Users/phantom/Desktop/project/unique stopwords removed dataset2");
        File[] listOfFiles = folder.listFiles();
        fileList=new String[listOfFiles.length];
        for (int k = 0; k < listOfFiles.length; k++) 
        {
            if (listOfFiles[k].isFile()) 
            {
                fileList[k]=(String)listOfFiles[k].getName();
                System.out.println("File " + listOfFiles[k].getName());
            } 
        }   
        for(int k=0;k<fileList.length;k++)
        {
            File f1 = new File("C:/Users/phantom/Desktop/project/unique stopwords removed dataset2/" + fileList[k]);
            String content = new Scanner(new File("C:/Users/phantom/Desktop/project/unique stopwords removed dataset2/" + fileList[k])).useDelimiter("\\Z").next();
            File f2 = new File("C:/Users/phantom/Desktop/project/merged dataset/mergefile.txt");

            BufferedWriter out = null;
        try 
        {
            out = new BufferedWriter(new FileWriter(f2, true));
        } 
        catch (IOException e1) 
        {
            e1.printStackTrace();
        }
        System.out.println("merging: " + f1.getName());
        FileInputStream fis;
        try 
        {
            aLine=new String[content.length()][2];
            int a=0;
            fis = new FileInputStream(f1);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            while((s = in.readLine())!= null) 
            {
                aLine[a] = s.split(","); 
                out.write((aLine[a][0]).trim());
                a++;
                out.newLine();
                //System.out.println(aLine);
            }
        in.close();
        }
 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        try 
        {
            out.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(MergingFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        }

    }
public static void main(String[] args) throws FileNotFoundException 
{
    mergingFiles1();
}
}

 
