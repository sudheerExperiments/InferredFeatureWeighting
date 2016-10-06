package test1;
import java.io.*;
import java.util.*;
import java.io.IOException;
 
public class UniqueStopWordsRemoval1
{
    private static String[] spliter;
    private static int[] count;
    
public static void uniqueStopWordsRemoval1()
{
    BufferedWriter bw;
    String[] fileList;
           
    File folder = new File("C:/Users/phantom/Desktop/project/stopwords removed dataset2/");
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
   try 
   {
    for(int k=0;k<fileList.length;k++)
    {
        String content = new Scanner(new File("C:/Users/phantom/Desktop/project/stopwords removed dataset2/" + fileList[k])).useDelimiter("\\Z").next();
        bw=new BufferedWriter((new FileWriter(new File("C:/Users/phantom/Desktop/project/unique stopwords removed dataset2/" + fileList[k]))));
        String temp1 = content.replaceAll("[\\n]", " ");
        String temp = temp1.replaceAll(",", " ");
        spliter = temp.replaceAll("[.?!:;/_]", "").split(" ");
        count = new int[spliter.length];
        for (int i = 0; i < spliter.length; i++)
        {
            temp = spliter[i];
            for (int j = 0; j < spliter.length; j++) 
            {
                 if (temp.equalsIgnoreCase(spliter[j])) 
                 {
                    count[j]++;
                 }
            }
        }
        
        ArrayList<String> words=new ArrayList<String>();
 
        for(int i=0;i<spliter.length;i++)
        {
            words.add(spliter[i].trim() + "," + count[i]);
        }
        
        Set<String> words1=new HashSet<String>();
        
        for(int i=0;i<words.size();i++)
        {
           words1.add(words.get(i));
        }
        for(String s:words1)
        { 
            bw.write(s);
            bw.newLine();
        }
    bw.close();
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
    uniqueStopWordsRemoval1();
}

}

