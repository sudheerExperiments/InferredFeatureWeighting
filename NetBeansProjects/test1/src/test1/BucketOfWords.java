package test1;

import java.util.*;
import java.io.*;

public class BucketOfWords 
{
    private String[] spliter;
    private int[] count;
  
 public void countWord(String Text) 
 {
    String temp1 = Text.replaceAll("[\\n]", " ");
    String temp = temp1.replaceAll(",", " ");
    spliter = temp.replaceAll("[.?!:;/_]", "").split(" ");
    count = new int[spliter.length];
    for (int i = 0; i < spliter.length; i++)
    {
        temp = spliter[i];
        for (int k = 0; k < spliter.length; k++) 
        {
            if (temp.equalsIgnoreCase(spliter[k])) 
            {
                count[k]++;
            }
        }
    }

   printResult();
 }

  private void printResult() 
  {
   try
      {
        BufferedWriter bw=new BufferedWriter(new FileWriter(new File("C:/Users/phantom/Desktop/project/bucket of words/bucketOfWords.txt")));
        HashMap map = new HashMap();
        int counter = 0;
        for (int i = 0; i < spliter.length; i++) 
        {
            map.put(spliter[i].toLowerCase(), count[i]);
        }
        Iterator it = map.keySet().iterator();
        System.out.println("Words             Count");
        //bw.write("Words             Count");
        //bw.newLine();
        System.out.println("#######################");
        //bw.write("#######################");
        //bw.newLine();
        while (it.hasNext()) 
        {
            counter++;
            String temp = (String) it.next();
            System.out.println(temp);
            bw.write(temp);
            bw.write(",");
            //bw.newLine();

            /*   // prints the spaces
            for (int i = 0; i < (20 - temp.length()); i++) {
                 System.out.print(" ");
                 bw.write(" ");
            }
            */

    // print the value -total count
    Object ob=map.get(temp.toString());
    System.out.println(map.get(temp.toString()));
    bw.write(ob.toString());
    bw.newLine();
      
  
  }
   bw.close();
      }
  catch(Exception e)
          { }
   }
  
  public static void bucketOfWords()
  {
      String pattern ="";
      String str = null;
      try 
      {
        FileInputStream filestream = new FileInputStream("C:/Users/phantom/Desktop/project/merged dataset/mergefile.txt");
        DataInputStream datastream = new DataInputStream(filestream);
        BufferedReader Br = new BufferedReader(new InputStreamReader(datastream));
        while ((str = Br.readLine()) != null) 
        {
            pattern = pattern.concat(str);
            pattern = pattern.concat(" ");
        }
        datastream.close();
        } 
       catch (Exception e)
       {
            System.out.println(e.getMessage());
       }
        BucketOfWords bof = new BucketOfWords();
        bof.countWord(pattern);
  }
  
   
public static void main(String[] arg) 
  {
      bucketOfWords();

  }
}
