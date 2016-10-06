package test1.ROC_Curves;
 
import java.io.File;
import java.io.IOException;

public class TF_WFO_Execution 
{
    public static void tf_WFO_Execution() throws IOException
    {        
       String executable = "C:/Users/phantom/Documents/NetBeansProjects/test1/src/test1/ROC_Curves/ROC_TF_WFO.bat";
       File workingDirectory = new File("C:/Users/phantom/Documents/NetBeansProjects/test1/src/test1/ROC_Curves");
       ProcessBuilder pb = new ProcessBuilder("cmd", "/c","start" ,executable, "dummy");
       pb.directory(workingDirectory);
       pb.start(); 
    }
     public static void main(String args[]) throws IOException
     {
        tf_WFO_Execution();
     }
     
}