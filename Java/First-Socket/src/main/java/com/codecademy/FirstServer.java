package com.codecademy;

import java.io.*;
import java.net.*;

public class FirstServer {
  public static void main(String[] args) {
    // your code here
    try (ServerSocket firstServerSocket = new ServerSocket(6868)) {
      Socket socketConnection = firstServerSocket.accept();

      DataInputStream dataStreamIn = new DataInputStream(socketConnection.getInputStream());
      String readString = (String) dataStreamIn.readUTF();

      System.out.println("message = " + readString);

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
