package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        while (true) {
            Socket server = new Socket("localhost", 1234);
            DataInputStream in = new DataInputStream(server.getInputStream());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            Scanner inConsole = new Scanner(System.in);
            out.writeUTF(inConsole.next());
            String m = in.readUTF();
            System.out.println(m);
            in.close();
            out.close();
            server.close();
        }
    }
}