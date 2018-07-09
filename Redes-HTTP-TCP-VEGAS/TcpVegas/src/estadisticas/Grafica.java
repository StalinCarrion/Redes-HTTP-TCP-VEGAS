/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadisticas;

import logica.ServerTCP;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author kfsarangos_96
 */
public class Grafica {
    XYSeries cwd;
    XYSeries beta;
    XYSeries alpha;
    XYSeries gamma;
    XYSeries windows;
    

    public Grafica() {
        cwd = new XYSeries("cwd");
        beta = new XYSeries("Beta");
        alpha = new XYSeries("Alpha");
        gamma = new XYSeries("Gamma");
        windows = new XYSeries("Windows");
    }

    public void plotTcp(int iter, int cwd1, int ssh1, int pipelimit1, int gamma1, int windows1) 
    {
        cwd.add(iter, cwd1);
        beta.add(iter, ssh1);
        alpha.add(iter, pipelimit1);
        gamma.add(iter, gamma1);
        windows.add(iter, windows1);
    }

    public void plotGraph() 
    {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(cwd);
        dataset.addSeries(beta);
        dataset.addSeries(alpha);
        dataset.addSeries(gamma);
        dataset.addSeries(windows);
        
       
        JFreeChart chart = ChartFactory.createXYLineChart("TCP/VEGAS "+ServerTCP.nombre, // Title
                "TIMER", // x-axis Label
                "WINDOWS SIZE", // y-axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot Orientation
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
        );
            
        ChartFrame frame = new ChartFrame("Lineas de tiempo", chart);
        frame.pack();
        frame.setVisible(true);
     }  
}
