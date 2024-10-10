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
        ServerSocket sS0 = new ServerSocket(3000); //Porta dove il server aspetta richiesta
        Socket s0 = sS0.accept(); //quando arriva una connessione, viene accettata e rende la nuova porta su cui avverra il vero passaggio di dati
        System.out.println("Un client si è collegato alla porta " + s0.getPort());

        BufferedReader in = new BufferedReader(new InputStreamReader(s0.getInputStream())); //stream dati in entrata
        DataOutputStream out = new DataOutputStream(s0.getOutputStream()); //stream dati inn uscita
        String stringaIn;
        
        do {
            stringaIn = in.readLine(); //attendo che arrivi una stringa sullo stream
            System.out.println("Stringa ricevuta: " + stringaIn);

            String sMaiuscola = stringaIn.toUpperCase(); //trasformo la stringa in maiuscola
            out.writeBytes(sMaiuscola + "\n"); //rispondo al client inviando la stringa
        } while (!stringaIn.equals("!")); //se il client manda "!", il server si chiude

        s0.close();
        sS0.close();

        System.out.println("Server terminato");    
    }
}