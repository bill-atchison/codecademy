package com.codecademy;

import java.io.*;
import java.net.Socket;

public class ClientSide {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 1234)) {
            try (DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream())) {
                try (DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream())) {
                    BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
                    String string1 = null;
                    String string2 = null;

                    while (true) {
                        if (string1 != null && string1.equalsIgnoreCase("done")) break;

                        string1 = bufferedReader.readLine();
                        dataOutputStream.writeUTF(string1);
                        dataOutputStream.flush();

                        string2 = dataInputStream.readUTF();
                        System.out.println(string2);
                    }

                }
            }

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
