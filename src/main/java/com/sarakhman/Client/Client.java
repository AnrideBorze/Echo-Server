package com.sarakhman.Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 3000);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
             BufferedReader bufferedFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Write message for Server");

                String forServer = scanner.nextLine();
                if (forServer.equals("-1")) {
                    break;
                }

                outputStreamWriter.write(forServer);
                String fromServer = bufferedFromServer.readLine();

                System.out.println(fromServer);

                scanner.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
