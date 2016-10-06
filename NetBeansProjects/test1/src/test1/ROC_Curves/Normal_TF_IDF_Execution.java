package test1.ROC_Curves;
 
import java.io.File;
import java.io.IOException;

public class Normal_TF_IDF_Execution 
{
    public static void normal_TF_IDF_Execution() throws IOException
    {        
       String executable = "C:/Users/phantom/Documents/NetBeansProjects/test1/src/test1/ROC_Curves/ROC_Normal_TF_IDF.bat";
       File workingDirectory = new File("C:/Users/phantom/Documents/NetBeansProjects/test1/src/test1/ROC_Curves");
       ProcessBuilder pb = new ProcessBuilder("cmd", "/c","start" ,executable, "dummy");
       pb.directory(workingDirectory);
       pb.start(); 
    }
     public static void main(String args[]) throws IOException
     {
         normal_TF_IDF_Execution();
     }
     
}