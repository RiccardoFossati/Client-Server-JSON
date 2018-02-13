package com.mycompany.jsonclient;

import java.net.*;
import java.io.*;
import javax.json.*;
/**
 *
 * @author Riccardo Fossati
 */
public class JSON_Client {

    public static void main(String[] args) throws IOException {
        
        //Viene inizializzata la socket
        Socket socket = new Socket("127.0.0.1", 3000);

        // Creazione della stream della socket (in entrata)
        BufferedReader inData = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Creazione della stream di JSON per la lettura dalla stream della socket
        JsonReader leggi = Json.createReader(inData);
        
        // Lettura dell'oggetto 'contatto' di tipo JSON in arrivo dalla socket
        JsonObject contatto = leggi.readObject();
        leggi.close();
        inData.close();
        
        //Vengono stampati i dati ricevuti dal Server
        System.out.println("JSON ricevuto: " + contatto.toString());
        
        // Chiusura della socket
        socket.close();
    }
    
}
