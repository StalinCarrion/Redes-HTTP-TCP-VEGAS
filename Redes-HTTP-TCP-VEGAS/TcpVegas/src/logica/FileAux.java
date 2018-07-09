/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import estadisticas.Grafica;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author kfsarangos_96
 */
public class FileAux {
    Grafica tcpPlot;
    
    
   
    
    public void  guarda_grafica(int iter, int cwd,int beta,int alpha, int gamma,int windows_size)
    {
        try
        {
            FileWriter fw = new FileWriter("grafica.txt", true);
         
            PrintWriter pw = new PrintWriter(fw);

            pw.write(iter + "," + cwd+ "," + beta
                    + "," + alpha + "," + gamma +"," + windows_size + "\r\n");

            fw.close();
            pw.close();
            
        } catch (Exception e) {
        }
    }
    
    public boolean lecturagrafica() throws FileNotFoundException, IOException 
    {
        tcpPlot = new Grafica();
        tcpPlot.plotGraph();
        
        BufferedReader b;
        FileReader f;
        
        String cadena;
        boolean bandera = false;
        
        f = new FileReader("grafica.txt");
        b = new BufferedReader(f);
        
        while((cadena = b.readLine())!=null)
        {

            String datos[] = cadena.split(",");
            int iter =Integer.parseInt(datos[0]);
            int cwd =Integer.parseInt(datos[1]);
            int be =Integer.parseInt(datos[2]);
            int a =Integer.parseInt(datos[3]);
            int g =Integer.parseInt(datos[4]);
            int w =Integer.parseInt(datos[5]);
            
            tcpPlot.plotTcp(iter, cwd, be, a, g, w);
   
        }
        b.close();
        f.close();
        return bandera;
    }
    
    public void Eliminar ()
    {
        try {
            String pArchivo = "grafica.txt";
            File fichero = new File(pArchivo);
            if (!fichero.delete()) {
                throw new Exception("El fichero " + pArchivo
                        + " no puede ser borrado!");
            }
        } catch (Exception e) {} 
    }
}
