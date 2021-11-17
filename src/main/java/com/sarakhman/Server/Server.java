package com.sarakhman.Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(3000);
             Socket socket = serverSocket.accept();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            while (true) {
                String fromClient = bufferedReader.readLine();

                System.out.println(fromClient);

                String forClient = "ECHO" + fromClient;
                bufferedWriter.write(forClient);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
