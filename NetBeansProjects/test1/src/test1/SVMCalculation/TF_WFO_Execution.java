package test1.SVMCalculation;
 
import java.io.File;
import java.io.IOException;

public class TF_WFO_Execution 
{
    public static void tf_WFO_Execution() throws IOException
    {        
       String executable = "C:/Users/phantom/Documents/NetBeansProjects/test1/src/test1/SVMCalculation/TF_WFO/LibSVMsharp.Examples.Classification/bin/Debug/LibSVMsharp.Examples.Classification.exe";
       File workingDirectory = new File("C:/Users/phantom/Documents/NetBeansProjects/test1/src/test1/SVMCalculation/TF_WFO/LibSVMsharp.Examples.Classification/bin/Debug");
       ProcessBuilder pb = new ProcessBuilder("cmd", "/c","start" ,executable, "dummy");
       pb.directory(workingDirectory);
       pb.start(); 
    }
     public static void main(String args[]) throws IOException
     {
         tf_WFO_Execution();
     }
     
}