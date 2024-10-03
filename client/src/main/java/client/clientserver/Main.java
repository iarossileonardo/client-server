package client.clientserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client partito");
        Socket s0 = new Socket("localhost", 3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(s0.getInputStream()));
        DataOutputStream out = new DataOutputStream(s0.getOutputStream());

        String s = "Ciao come va?";

        out.writeBytes(s + "\n");

        String sM = in.readLine();

        System.out.println("Stringa maiuscola: " + sM);
        
         
        System.out.println("client terminato");
    }
}