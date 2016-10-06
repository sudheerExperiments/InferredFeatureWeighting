package test1.SVMCalculation;
 
import java.io.File;
import java.io.IOException;

public class NormalTF_IDFExecution 
{
    public static void normalTF_IDFExecution() throws IOException
    {        
       String executable = "C:/Users/phantom/Documents/NetBeansProjects/test1/src/test1/SVMCalculation/Normal_TF_IDF/LibSVMsharp.Examples.Classification/bin/Debug/LibSVMsharp.Examples.Classification.exe";
       File workingDirectory = new File("C:/Users/phantom/Documents/NetBeansProjects/test1/src/test1/SVMCalculation/Normal_TF_IDF/LibSVMsharp.Examples.Classification/bin/Debug");
       ProcessBuilder pb = new ProcessBuilder("cmd", "/c","start" ,executable, "dummy");
       pb.directory(workingDirectory);
       pb.start(); 
    }
     public static void main(String args[]) throws IOException
     {
         normalTF_IDFExecution();
     }
     
}