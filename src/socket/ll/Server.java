/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket.ll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Estudiante
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Servidor esperando");
        Socket cliente = serverSocket.accept();
        System.out.println("   ");
        InputStream flujoEntrada = cliente.getInputStream();
        OutputStream flujoSalida = cliente.getOutputStream();
        BufferedReader lectura = new BufferedReader (new InputStreamReader(flujoEntrada));
        PrintWriter escritura = new PrintWriter(flujoSalida, true);
        String mensajeLeido=" ";
        while(true){
            mensajeLeido = lectura.readLine();
            escritura.println("ECO" + mensajeLeido);
        }
        
    }
    
}
