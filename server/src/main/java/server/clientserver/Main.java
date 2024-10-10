package server.clientserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server in ascolto");
        ServerSocket sS0 = new ServerSocket(3000);
        Socket s0 = sS0.accept();
        System.out.println("Un client si è collegato alla porta " + s0.getPort());

        BufferedReader in = new BufferedReader(new InputStreamReader(s0.getInputStream()));
        DataOutputStream out = new DataOutputStream(s0.getOutputStream());
        String stringaIn;
        
        do {
            stringaIn = in.readLine();
            System.out.println("Stringa ricevuta: " + stringaIn);

            String sMaiuscola = stringaIn.toUpperCase();
            out.writeBytes(sMaiuscola + "\n");
        } while (!stringaIn.equals("!"));

        s0.close();
        sS0.close();

        System.out.println("Server terminato");    
    }
}