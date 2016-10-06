package test1;

import java.io.BufferedReader;
import java.io.*;
import java.util.Scanner;

public class NormalizedTF
{
    static int maxValue;
    
    public static void normalizedTF() throws FileNotFoundException, IOException
    {
        BufferedReader br;
        BufferedWriter bw;
        String[] fileList;
        String[][] token;
        String s;
        File folder = new File("C:/Users/phantom/Desktop/project/unique stopwords removed dataset1/");
        File[] listOfFiles = folder.listFiles();
        fileList=new String[listOfFiles.length];
 for (int k = 0; k < listOfFiles.length; k++) 
 {
  if (listOfFiles[k].isFile()) 
  {
   fileList[k]=(String)listOfFiles[k].getName().trim();
   //System.out.println("File " + listOfFiles[k]);
  } 
   }
        
        for(int k=0;k<fileList.length;k++)
        {
            int i=0;
            maxValue=0;
            br=new BufferedReader(new FileReader(new File("C:/Users/phantom/Desktop/project/unique stopwords removed dataset1/" + fileList[k])));
            bw=new BufferedWriter(new FileWriter("C:/Users/phantom/Desktop/project/calculations/Normalized TF1/" + fileList[k]));
            String content = new Scanner(new File("C:/Users/phantom/Desktop/project/unique stopwords removed dataset1/" + fileList[k])).useDelimiter("\\Z").next();
            token=new String[content.length()][2];
            while((s=br.readLine())!=null)
            {
                token[i]=s.split(",");
                i++;
            }
            for(int m=0;m<i;m++)
            {
                if(Integer.parseInt(token[m][1])>maxValue)
                {
                    maxValue=Integer.parseInt(token[m][1]);
                }
            }
            System.out.println(fileList[k] + ":" + maxValue);
       for(int j=0;j<i;j++)
         {
            float a=(float)(0.5 + ((0.5*Integer.parseInt(token[j][1]))/maxValue));
            //System.out.println(token[j][0]+ ":"+token[j][1] + ":" + a + "////normalizedTF" + k);
            bw.write(token[j][0].trim());
            bw.write(",");
            //bw.write(token[j][1].trim());
            //bw.write(",");
            bw.write(a + "");
            bw.newLine();
         }
         bw.close();
        }
        
    }
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
         normalizedTF();
    }
}