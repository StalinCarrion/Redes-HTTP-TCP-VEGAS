/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Pages.Pages;
import gui.ServerForm;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author kfsarangos_96
 */
public class ServerTCP {

    //variables socket
    ServerSocket serverSocket;
    public static String nombre;
    //Vegas
    Vegas myAlgorithmVegas = new Vegas();
    String cmdLine = "\n>> ";

    public void startServer(int PUERTO) {
        try {
            serverSocket = new ServerSocket(PUERTO);

            while (true) {
                // Aceptando la conexión del cliente
                Socket clientSocket = serverSocket.accept();

                ServerForm.logTXA.append("NUEVO CLIENTE CONECTADO");
                ServerForm.logTXA.append(cmdLine + "Resiviendo solicitud");
                buffer(clientSocket);

            }
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "El host no existe o no está activo.");
            System.out.println("El host no existe o no está activo." + e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de entrada/salida.");
            System.out.println("Error de entrada/salida." + e.getMessage());
        }
    }

    public void stopServidor(BufferedReader in, BufferedWriter out, Socket clientSocket) throws IOException {
        out.close();
        in.close();
        clientSocket.close();
    }

    void buffer(Socket clientSocket) throws IOException {
        // Declaramos las lecturas del buffer de entrada y salida del socket
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        // Leemos el request para enviarle posteriormente
        String peticion = in.readLine();
        System.out.println("->Req: " + peticion);
        int posToCut = peticion.length() - 9;
        if (peticion.length() > 15) {
            peticion = peticion.substring(0, posToCut);
           
        }

        ServerForm.logTXA.append(cmdLine + peticion);

        responderPeticion(in, out, peticion, clientSocket);
    }
  
    

    void responderPeticion(BufferedReader in, BufferedWriter out, String req, Socket clientSocket) throws IOException {
        String forma;
        int tam = 0;
        
        switch(req){
            case("GET /get-bg"):
                //Abrimos las imágen y leemos los bytes para mandarle la información al socket
                File file = new File("img/bg.png");
                FileInputStream fis = new FileInputStream(file);
                byte[] data = new byte[(int) file.length()];
                fis.read(data);
                fis.close();
                forma = "image/png";
                
                //construimos http
                tam = getImg(data, clientSocket, forma);
                this.nombre= "Imagen";
                this.myAlgorithmVegas.ImplementVegas(tam);
                
                break;
                
            case("GET /favicon.ico"):
                File file2 = new File("img/favicon.ico");
                FileInputStream fis2 = new FileInputStream(file2);
                byte[] data2 = new byte[(int) file2.length()];
                fis2.read(data2);
                fis2.close();
                forma = "image/x-icon";

                //construimos http
                tam = getImg(data2, clientSocket, forma);
                this.nombre= "Icono";
                this.myAlgorithmVegas.ImplementVegas(tam);
                
                break;
                
            //Enviamos las cabeceras de la paǵina + contenido
            case("GET / HTTP/1.1"):
                this.nombre = "Home";
                sendPage(Pages.getHomePage(), out);
                
                break;
                
            case("GET /overview"):
                this.nombre = "Overview";
                sendPage(Pages.getOverviewPage(), out);
                
                break;
                
            case("GET /team"):
                this.nombre = "Team";
                sendPage(Pages.getTeamPage(), out);
                
                break;
                
            case("GET /saludo"):
                tam = saludo(out);
                this.nombre = "Saludo";
                this.myAlgorithmVegas.ImplementVegas(tam);
                break;
                
        }

        stopServidor(in, out, clientSocket);
    }
    
    public void sendPage(String [] page , BufferedWriter out)throws IOException{
        String data;
        int acumulador=0;
        for (int i = 0; i < page.length; i++) {
            data = page[i];
            out.write(data);
            acumulador+=data.length();
            
        }
        System.out.println("acumulador "+acumulador);
        this.myAlgorithmVegas.ImplementVegas(acumulador);//Acumuluador para obtener el tamaño de la pagina recivida para la grafica
    }

    int getImg(byte[] data, Socket clientSocket, String forma) throws IOException {
        int taa = 0;
        String temp;
        // Cabeceras con la info de la imágen            
        DataOutputStream binaryOut = new DataOutputStream(clientSocket.getOutputStream());
        temp = "HTTP/1.0 200 OK\r\n";
        binaryOut.writeBytes(temp);
        //log("\n" + temp);
        temp = "Content-Type: " + forma + "\r\n";
        binaryOut.writeBytes(temp);
        //log(temp);
        temp = "Content-Length: " + data.length;
        binaryOut.writeBytes(temp);
        //log(temp);
        temp = "\r\n\r\n";
        binaryOut.writeBytes(temp);
        //log(temp);
        binaryOut.write(data);
        //log("load img\n");

        taa = binaryOut.size();
        binaryOut.close();
        return taa;
    }

    

    int saludo(BufferedWriter out) throws IOException {
        String temp;
        temp = "Hello Wold";
        out.write(temp);
        return temp.length();
    }

}
