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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket cliente = newSocket("localhost", 8000);
            InputStream flujoEntrada = cliente.getInputStream();
            OutputStream flujoSalida = cliente.getOutputStream();
            BufferedReader lectura = new BufferedReader(new InputStreamReader(flujoEntrada));
            PrintWriter escritura = new PrintWriter(flujoSalida, true);
            BufferedReader lecturaUsuario = new BufferedReader(new InputStreamReader(System.in));
            String mensajeLeido = " ";
            String mensajeUsuario = " ";
            while (true) {
                System.out.println("Que mensaje desea enviar: ");
                mensajeUsuario = lecturaUsuario.readLine();
                escritura.println(mensajeUsuario);
                mensajeLeido = lectura.readLine();
                System.out.println("Me contestaron " + mensajeLeido);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Socket newSocket(String localhost, int i) {
        return null;
    }
}
