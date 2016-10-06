package test1.SVMCalculation;
 
import java.io.File;
import java.io.IOException;

public class NTF_OR_Execution 
{
    public static void ntf_or_Execution() throws IOException
    {        
       String executable = "C:/Users/phantom/Documents/NetBeansProjects/test1/src/test1/SVMCalculation/NTF_OddsRatio/LibSVMsharp.Examples.Classification/bin/Debug/LibSVMsharp.Examples.Classification.exe";
       File workingDirectory = new File("C:/Users/phantom/Documents/NetBeansProjects/test1/src/test1/SVMCalculation/NTF_OddsRatio/LibSVMsharp.Examples.Classification/bin/Debug");
       ProcessBuilder pb = new ProcessBuilder("cmd", "/c","start" ,executable, "dummy");
       pb.directory(workingDirectory);
       pb.start(); 
    }
     public static void main(String args[]) throws IOException
     {
         ntf_or_Execution();
     }
     
}