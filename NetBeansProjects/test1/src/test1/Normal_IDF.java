package test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Normal_IDF
{
    public static void normal_IDF() throws FileNotFoundException, IOException
    {
        BufferedReader br;
        BufferedWriter bw;
        String[][] arr;    
        String str;
        String[] fileList,fileList1;
        float[] arr1;
        int i=0,N=0;
 
        File folder = new File("C:/Users/phantom/Desktop/project/input dataset/pos/");
        File folder1 = new File("C:/Users/phantom/Desktop/project/input dataset/neg/");
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
        File[] listOfFiles1 = folder1.listFiles();
        fileList1=new String[listOfFiles.length];
        for (int k = 0; k < listOfFiles1.length; k++) 
        {
            if (listOfFiles1[k].isFile()) 
            {
                fileList1[k]=(String)listOfFiles1[k].getName();
                //System.out.println("File " + listOfFiles[k].getName());
            } 
        }
        
        N=fileList.length+fileList1.length;
        //System.out.println(N);
        
        br=new BufferedReader(new FileReader(new File("C:/Users/phantom/Desktop/project/bucket of words/bucketOfWords.txt")));
        String content = new Scanner(new File("C:/Users/phantom/Desktop/project/bucket of words/bucketOfWords.txt")).useDelimiter("\\Z").next();
        arr=new String[content.length()][2];
        while((str=br.readLine())!=null)
        {
            arr[i]=str.split(",");
            i++;
            
        }
        bw=new BufferedWriter(new FileWriter(new File("C:/Users/phantom/Desktop/project/calculations/Normal IDF.txt")));
        
        arr1=new float[arr.length];
        for(int j=0;j<i;j++)
        {
            double temp=Integer.parseInt(arr[j][1]);
            double temp1=N/temp;
            arr1[j]=(float)Math.log10(temp1);
        }
        
        for(int j=0;j<i;j++)
        {
            bw.write(arr[j][0]);
            bw.write(",");
            bw.write(arr1[j] + "");
            bw.newLine();
        }
        
        bw.close();
    }
    
    public static void main(String[] args) throws IOException
    {
        normal_IDF();
    }
}