package server.clientserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server in ascolto");
        ServerSocket sS0 = new ServerSocket(3000);
        Socket s0 = sS0.accept();
        System.out.println("Server terminato");    
    }
}