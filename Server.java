package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(1234);
        while(true){
            Socket client = server.accept();
            DataInputStream in = new DataInputStream(client.getInputStream());
            String message = in.readUTF();
            System.out.println(message);
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF(message + " (from server)");
            in.close();
            out.close();
            client.close();

        }
    }

}