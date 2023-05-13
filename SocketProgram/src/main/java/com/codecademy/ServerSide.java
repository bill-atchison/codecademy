package com.codecademy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            Socket socketConnection = serverSocket.accept();

            try (DataInputStream dataInputStream = new DataInputStream(socketConnection.getInputStream())) {
                try (DataOutputStream dataOutputStream = new DataOutputStream(socketConnection.getOutputStream())) {
                    BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
                    String string1 = null;
                    String string2 = null;

                    while (true) {
                        if (string1 != null && string1.equalsIgnoreCase("done")) break;

                        string1 = dataInputStream.readUTF();
                        System.out.println(string1);

                        string2 = bufferedReader.readLine();
                        dataOutputStream.writeUTF(string2);
                        dataOutputStream.flush();
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
