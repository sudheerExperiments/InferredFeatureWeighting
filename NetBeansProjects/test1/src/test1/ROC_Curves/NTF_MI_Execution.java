package test1.ROC_Curves;
 
import java.io.File;
import java.io.IOException;

public class NTF_MI_Execution 
{
    public static void ntf_mi_Execution() throws IOException
    {        
       String executable = "C:/Users/phantom/Documents/NetBeansProjects/test1/src/test1/ROC_Curves/ROC_NTF_MutualInformation.bat";
       File workingDirectory = new File("C:/Users/phantom/Documents/NetBeansProjects/test1/src/test1/ROC_Curves");
       ProcessBuilder pb = new ProcessBuilder("cmd", "/c","start" ,executable, "dummy");
       pb.directory(workingDirectory);
       pb.start(); 
    }
     public static void main(String args[]) throws IOException
     {
         ntf_mi_Execution();
     }
     
}