/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.json_server;


import java.net.*;
import java.io.*;
import javax.json.*;
/**
 *
 * @author Riccardo Fossati
 */
public class JSON_Server {

    public static void main(String[] args) throws IOException {
    
        // Vengono inizializzate le 2 socket
        ServerSocket serverSock = new ServerSocket(3000);
        Socket socket = serverSock.accept();

        // Creazione della stream della socket (in uscita)
        BufferedWriter outData = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        //Creazione dell'oggetto 'contatto' di tipo JSON
        JsonObject contatto = Json.createObjectBuilder()
                .add("Nome: ", "Riccardo")
                .add("Cognome: ", "Fossati")
                .add("Telefono: ", "3291121718")
                .build();
        
        //Vengono stampati in output i dati inseriti
        System.out.println(contatto.toString());
        
        // Creazione della stream di JSON che permette di scrivere nella stream della socket
        JsonWriter scrivi = Json.createWriter(outData);

        // L'oggetto JSON 'contatto' viene inviato via socket e viene data conferma in output
        scrivi.writeObject(contatto);
        scrivi.close();
        outData.close();
        System.out.println("JSON inviato");

        // Come ultima cosa vengono chiuse le socket
        socket.close();
        serverSock.close();
        
        
    }
}