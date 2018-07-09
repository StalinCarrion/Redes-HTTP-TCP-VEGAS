/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import estadisticas.Grafica;
import gui.ServerForm;

/**
 *
 * @author kfsarangos_96
 */
public class Vegas {
    int cwd = 30; //Valor de congestion
    int beta; //Umbral superior para la ventana
    int alpha; //Umbral inferior para la ventana
    int gamma = 10; //Valor inferior
    
    int umbralUp = 0;
    int umbralDown = 0;
    int umbralCenter = 0;
    
    public int windows_size = 5; //Tamaño de la ventana
    
    public int posicion_actual = 0; //Valor inicial actual de la ventana
    public int posicion_final = 0; //Valor Final actual de la ventana
    
    public static String proyecto = "HTTP variante TCP / VEGAS pks";
    public static String cmdLine = "\n>> ";
    
    Grafica tcpPlot;
    
    
    public void ImplementVegas(int tam)
    {
        tcpPlot = new Grafica();
        tcpPlot.plotGraph();
        ServerForm.logTXA.append("\nEStado de Ventana");
        try 
        {
            int lim_inicio = 12; //Limite >= 13
            int lim_fin = 18; //Limite 7 <=7
            int temp_1;
            int temp_2;
            int iter = 0;            
            
            boolean ban = true;

            posicion_final = posicion_actual + windows_size;
            int cont = posicion_final;

            do
            {
                temp_1 = 0;
                temp_2 = 0;
                 
                while((temp_1 == temp_2) || (temp_1 == cwd) || (temp_1 == gamma) || (temp_2 == cwd) || (temp_2 == gamma))
                {
                    temp_1 = (int) ((Math.random()*lim_fin)+lim_inicio);
                    temp_2 = (int) ((Math.random()*lim_fin)+lim_inicio);

                    if (temp_1 < temp_2) 
                    {
                        alpha = temp_1;
                        beta = temp_2;
                    }else{
                        alpha = temp_2;
                        beta = temp_1;
                    }
                }
                
                //salida = comando.substring(posicion_actual,posicion_final);
                tcpPlot.plotTcp(iter, cwd, beta, alpha, gamma, windows_size);
             
                iter++;
                
                if (windows_size < gamma)
                {
                    windows_size = windows_size * 2;
                    ServerForm.logTXA.append(cmdLine+"Slow Start");
                    
                    posicion_actual = posicion_final;
                    posicion_final = posicion_final + windows_size;
                    cont = cont + windows_size;
                }else{
                    //Si el tamaño de la ventanta este dentro de los intervalor gamma, alpha
                    if ((windows_size >= gamma)  && (windows_size <= alpha))
                    {
                        windows_size = windows_size + 1;
                        ServerForm.logTXA.append(cmdLine+"Umbral Inferior");
                        
                        posicion_actual = posicion_final;
                        posicion_final = posicion_final + windows_size;
                        cont = cont + windows_size;
                    }else{
                        //Si el tamaño de la ventanta esta en el medio
                        if ((windows_size > alpha) && (windows_size < beta)) 
                        {
                            ServerForm.logTXA.append(cmdLine+"Umbral Central");
                            
                            posicion_actual = posicion_final;
                            posicion_final = posicion_final + windows_size;
                            cont = cont + windows_size;
                        }else{
                            //Si el tamaño de la ventana sobrespasa beta
                            if ((windows_size >= beta) && (windows_size <= cwd)) 
                            {
                                ServerForm.logTXA.append(cmdLine+"Umbral Superior");
                                windows_size = windows_size - 1;
                                
                                posicion_actual = posicion_final;
                                posicion_final = posicion_final + windows_size;
                                cont = cont + windows_size;
                            //existe conjestion
                            }else{
                                windows_size = windows_size - 1;
                                ServerForm.logTXA.append(cmdLine+"Congestion");
                                
                                posicion_actual = posicion_final;
                                posicion_final = posicion_final + windows_size;
                                cont = cont + windows_size;
                            }
                        }
                    }
                }
                if (cont > tam) 
                {
                    int temp_inicio = posicion_final - windows_size;
                    int temp_fin = temp_inicio + (tam - (cont - windows_size));

                    //salida = comando.substring(temp_inicio,temp_fin);
                    tcpPlot.plotTcp(iter, cwd, beta, alpha, gamma, windows_size);
                    //temporizador.start();
                    //Thread.sleep(timer);
                    iter++;

                    if (windows_size < gamma)
                    {
                        windows_size = windows_size * 2;
                        ServerForm.logTXA.append(cmdLine+"Slow Start");
                        
                        windows_size = 5;
                        posicion_actual = 0;
                        posicion_final = 0;
                    }else{
                        if ((windows_size >= gamma)  && (windows_size <= alpha))
                        {
                            windows_size = windows_size + 1;
                            ServerForm.logTXA.append(cmdLine+"Umbral Inferior");
                            
                            windows_size = 5;
                            posicion_actual = 0;
                            posicion_final = 0;
                        }else{
                            if ((windows_size > alpha) && (windows_size < beta)) 
                            {
                                ServerForm.logTXA.append(cmdLine+"Umbral Central");
                                
                                windows_size = 5;
                                posicion_actual = 0;
                                posicion_final = 0;
                            }else{
                                if ((windows_size >= beta) && (windows_size <= cwd)) 
                                {
                                    ServerForm.logTXA.append(cmdLine+"Umbral Superior");
                                    windows_size = windows_size - 1;
                                    
                                    windows_size = 5;
                                    posicion_actual = 0;
                                    posicion_final = 0;
                                }else{
                                    ServerForm.logTXA.append(cmdLine+"Congestion");
                                    windows_size = windows_size - 1;
                                    
                                    windows_size = 5;
                                    posicion_actual = 0;
                                    posicion_final = 0;
                                }
                            }
                        }
                    }
                    ban = false;
                }

            }while(ban);
        } catch (Exception e) {}
        
    }
}
