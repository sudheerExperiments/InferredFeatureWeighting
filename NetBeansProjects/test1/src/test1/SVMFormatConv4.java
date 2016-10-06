package test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SVMFormatConv4
{
    public static void svmFormatConv4() throws FileNotFoundException, IOException
    {
        String[] fileList,fileList1;
        BufferedReader br,br1;
        BufferedWriter bw;
        String[][] arr1,arr2;
        String s,s2;
        String[] bowNum;
        File f;
        int i,l;
File folder = new File("C:/Users/phantom/Desktop/project/input dataset/pos/");
File folder1 = new File("C:/Users/phantom/Desktop/project/input dataset/neg/");

File[] listOfFiles = folder.listFiles();
File[] listOfFiles1 = folder1.listFiles();
fileList=new String[listOfFiles.length];
fileList1=new String[listOfFiles1.length];
for (int k = 0; k < listOfFiles.length; k++) 
 {
  if (listOfFiles[k].isFile()) 
  {
   fileList[k]=(String)listOfFiles[k].getName();
   //System.out.println("File " + listOfFiles[k].getName());
  } 
   }
for (int k = 0; k < listOfFiles1.length; k++) 
 {
  if (listOfFiles1[k].isFile()) 
  {
   fileList1[k]=(String)listOfFiles1[k].getName();
   //System.out.println("File " + listOfFiles[k].getName());
  } 
   }

String content = new Scanner(new File("C:/Users/phantom/Desktop/project/bucket of words/bucketOfWords.txt")).useDelimiter("\\Z").next();
br=new BufferedReader(new FileReader(new File("C:/Users/phantom/Desktop/project/bucket of words/bucketOfWords.txt")));

arr1=new String[content.length()][2];
bowNum=new String[content.length()];

i=0;
while((s=br.readLine())!=null)
{
    arr1[i]=s.split(",");
    bowNum[i]=i+"";            //word in document in TF1_OddsRatio(SVM file) is +1 of word in bucket of words
    i++;
}

for(int j=0;j<fileList.length;j++)
{
    Map<Integer, String> unsortMap = new HashMap<Integer, String>();
    l=0;
    br1=new BufferedReader(new FileReader(new File("C:/Users/phantom/Desktop/project/calculations/variants/Normal1 TF_IDF/" + fileList[j])));
    String content1 = new Scanner(new File("C:/Users/phantom/Desktop/project/calculations/variants/Normal1 TF_IDF/" + fileList[j])).useDelimiter("\\Z").next();
    arr2=new String[content1.length()][2];
    while((s2=br1.readLine())!=null)
    {
        arr2[l]=s2.split(",");
        l++;
    }
    f=new File("C:/Users/phantom/Desktop/project/calculations/variants/Normal TF_IDF.txt");
    bw=new BufferedWriter(new FileWriter(f,true));
    bw.write("+1");
   for(int m=0;m<l;m++)
    {
     for(int n=0;n<i;n++)
        {
            //System.out.println(token[m][0] + "::::" + arr1[n][0]);
            
        if(arr1[n][0].equals(arr2[m][0]))
                { 
                   unsortMap.put(Integer.parseInt(bowNum[n]), arr2[m][1]);
                }
    }
        }
   Map<Integer, String> treeMap = new TreeMap<Integer, String>(
			new Comparator<Integer>() {
 
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
 
		});
		treeMap.putAll(unsortMap);
   for (Map.Entry<Integer, String> entry : treeMap.entrySet()) 
   {
       bw.write(" ");
       bw.write(entry.getKey().toString());
       bw.write(":");
       bw.write(entry.getValue());
   }
   bw.newLine();
   bw.close();
}

for(int j=0;j<fileList1.length;j++)
{
    Map<Integer, String> unsortMap = new HashMap<Integer, String>();
    l=0;
    br1=new BufferedReader(new FileReader(new File("C:/Users/phantom/Desktop/project/calculations/variants/Normal2 TF_IDF/" + fileList1[j])));
    String content1 = new Scanner(new File("C:/Users/phantom/Desktop/project/calculations/variants/Normal2 TF_IDF/" + fileList1[j])).useDelimiter("\\Z").next();
    arr2=new String[content1.length()][2];
    while((s2=br1.readLine())!=null)
    {
        arr2[l]=s2.split(",");
        l++;
    }
    f=new File("C:/Users/phantom/Desktop/project/calculations/variants/Normal TF_IDF.txt");
    bw=new BufferedWriter(new FileWriter(f,true));
    bw.write("-1");
   for(int m=0;m<l;m++)
    {
     for(int n=0;n<i;n++)
        {
            //System.out.println(token[m][0] + "::::" + arr1[n][0]);
            
        if(arr1[n][0].equals(arr2[m][0]))
                { 
                   unsortMap.put(Integer.parseInt(bowNum[n]), arr2[m][1]);
                }
    }
        }
   Map<Integer, String> treeMap = new TreeMap<Integer, String>(
			new Comparator<Integer>() {
 
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
 
		});
		treeMap.putAll(unsortMap);
   for (Map.Entry<Integer, String> entry : treeMap.entrySet()) 
   {
       bw.write(" ");
       bw.write(entry.getKey().toString());
       bw.write(":");
       bw.write(entry.getValue());
   }
   bw.newLine();
   bw.close();
}
    }
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        svmFormatConv4();
    }
 }