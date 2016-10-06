package test1.performancePlot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * A sample application showing how to create a pie chart.
 */
public class PerformancePlot 
{

    private static CategoryDataset createDataset() throws FileNotFoundException, IOException 
    {
        DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        
        BufferedReader br1,br2,br3,br4,br5;
        String str;
        String[][] str1;
        br1=new BufferedReader(new FileReader(new File("C:/Users/phantom/Desktop/project/calculations/performance values/performance values.txt")));
        br2=new BufferedReader(new FileReader(new File("C:/Users/phantom/Desktop/project/calculations/performance values/performance values1.txt")));
        br3=new BufferedReader(new FileReader(new File("C:/Users/phantom/Desktop/project/calculations/performance values/performance values2.txt")));
        br4=new BufferedReader(new FileReader(new File("C:/Users/phantom/Desktop/project/calculations/performance values/performance values3.txt")));
        br5=new BufferedReader(new FileReader(new File("C:/Users/phantom/Desktop/project/calculations/performance values/performance values4.txt")));

        str1=new String[5][4];
        while((str=br3.readLine())!=null)
        {
            str1[0]=str.split(",");
        }
    
    while((str=br4.readLine())!=null)
        {
            str1[1]=str.split(",");
        }
        
        while((str=br2.readLine())!=null)
        {
            str1[3]=str.split(",");
        }
        
        while((str=br1.readLine())!=null)
        {
            str1[2]=str.split(",");
        }
        
        while((str=br5.readLine())!=null)
        {
            str1[4]=str.split(",");
        }
    
     objDataset.setValue(Float.parseFloat(str1[0][0]), "Precision", "TF-MutualInformation");
     objDataset.setValue(Float.parseFloat(str1[0][1]), "Recall", "TF-MutualInformation");
     objDataset.setValue(Float.parseFloat(str1[0][2]), "F1-Score", "TF-MutualInformation");
     objDataset.setValue(Float.parseFloat(str1[0][3]), "Accuracy", "TF-MutualInformation");
     
     objDataset.setValue(Float.parseFloat(str1[1][0]), "Precision", "TF-OddsRatio");
     objDataset.setValue(Float.parseFloat(str1[1][1]), "Recall", "TF-OddsRatio");
     objDataset.setValue(Float.parseFloat(str1[1][2]), "F1-Score", "TF-OddsRatio");
     objDataset.setValue(Float.parseFloat(str1[1][3]), "Accuracy", "TF-OddsRatio");
     
     objDataset.setValue(Float.parseFloat(str1[2][0]), "Precision", "NTF-MutualInformation");
     objDataset.setValue(Float.parseFloat(str1[2][1]), "Recall", "NTF-MutualInformation");
     objDataset.setValue(Float.parseFloat(str1[2][2]), "F1-Score", "NTF-MutualInformation");
     objDataset.setValue(Float.parseFloat(str1[2][3]), "Accuracy", "NTF-MutualInformation");
     
     objDataset.setValue(Float.parseFloat(str1[3][0]), "Precision", "NTF-OddsRatio");
     objDataset.setValue(Float.parseFloat(str1[3][1]), "Recall", "NTF-OddsRatio");
     objDataset.setValue(Float.parseFloat(str1[3][2]), "F1-Score", "NTF-OddsRatio");
     objDataset.setValue(Float.parseFloat(str1[3][3]), "Accuracy", "NTF-OddsRatio");
     
     objDataset.setValue(Float.parseFloat(str1[4][0]), "Precision", "Normal TF-IDF");
     objDataset.setValue(Float.parseFloat(str1[4][1]), "Recall", "Normal TF-IDF");
     objDataset.setValue(Float.parseFloat(str1[4][2]), "F1-Score", "Normal TF-IDF");
     objDataset.setValue(Float.parseFloat(str1[4][3]), "Accuracy", "Normal TF-IDF");
        
     br1.close();
     br2.close();
     br3.close();
     br4.close();
     br5.close();
     
        return objDataset;
    }

    private static JFreeChart createChart() throws IOException {
        
        CategoryDataset chartData = createDataset();

        //Create the chart
        JFreeChart objChart = ChartFactory.createBarChart(
                "Performance analysis chart", //Chart title
                "Variants", //Domain axis label
                "Value", //Range axis label
                chartData, //Chart Data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend?
                true, // include tooltips?
                false // include URLs?
                );

        return objChart;
    }
    
    public static void performancePlot() throws IOException
    {
        //Get the chart created
        JFreeChart objChart = createChart();

        // create and display a frame...
        ChartFrame frame = new ChartFrame("Demo", objChart);
        frame.pack();
        frame.setVisible(true);
    }

     public static void main(String[] args) throws IOException
     {
        performancePlot();
     }
}