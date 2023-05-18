package com.codecademy;

import java.io.*;
import java.net.*;

public class FirstClient {
  public static void main(String[] args) {
    // your code here
    try (Socket clientSocket = new Socket("localhost", 6868)) {
      try (DataOutputStream dataStreamOut = new DataOutputStream(clientSocket.getOutputStream())) {
        dataStreamOut.writeUTF("Happy Coding!");
        dataStreamOut.flush();
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }
}
