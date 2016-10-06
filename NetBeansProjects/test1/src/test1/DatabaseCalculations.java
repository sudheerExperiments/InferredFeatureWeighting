package test1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseCalculations
{
    static Connection con;
    static PreparedStatement ps;
    ResultSet rs;
    static BufferedReader br;
    static String[][] arr;
    static String s;
    public DatabaseCalculations() throws Exception
    {
        
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Datastore","root","");
    }
    public static void truncate() throws SQLException
    {
        ps=con.prepareStatement("truncate table Table1");
        ps.executeUpdate();
        
    }
    public static void insertBOWwords() throws SQLException, FileNotFoundException, IOException
    {
        int k=0;
        String s1;
        String content = new Scanner(new File("C:/Users/phantom/Desktop/project/bucket of words/bucketOfWords.txt")).useDelimiter("\\Z").next();
        //System.out.println(content);
        arr=new String[content.length()][2];
        br=new BufferedReader(new FileReader(new File("C:/Users/phantom/Desktop/project/bucket of words/bucketOfWords.txt")));
        while((s=br.readLine())!=null)
        {
            //s1=s.replace("'", "\'");
            //System.out.println(s1);
            arr[k]=s.split(",");
            k++;
        }
        for(int i=0;i<k;i++)
        {
            s1=arr[i][0].replace("'","\\'");
            ps=con.prepareStatement("insert into Table1(BucketOfWords,bowDbWordsCount) values(" + "'" + s1 + "'" + "," + Integer.parseInt(arr[i][1]) + ")" );
            ps.executeUpdate();
        }
        
        con.close();
    }
  public static void main(String args[]) throws Exception
  {
      DatabaseCalculations j=new DatabaseCalculations();
      j.truncate();
      j.insertBOWwords();
  }
} 
  