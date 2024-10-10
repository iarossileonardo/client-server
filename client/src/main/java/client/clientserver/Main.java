package client.clientserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client partito");
        Socket s0 = new Socket("localhost", 3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(s0.getInputStream()));
        DataOutputStream out = new DataOutputStream(s0.getOutputStream());
        Scanner input = new Scanner(System.in);
        String s;

        do {
            System.out.println("Inserire la stringa da inviare (! per chiudere la connessione)\n");
            s = input.nextLine();
            
            out.writeBytes(s + "\n");
            
            String sM = in.readLine();
            
            System.out.println("Invio dati a server");
            
            System.out.println("Stringa maiuscola: " + sM);
        } while (!s.equals("!"));
        
        input.close();
        s0.close();
        System.out.println("client terminato");
    }
}