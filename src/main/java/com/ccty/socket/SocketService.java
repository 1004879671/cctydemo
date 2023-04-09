package com.ccty.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketService extends Thread{

    private ServerSocket serverSocket ;

    public SocketService(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }



    public void run(){

        while (true){

            try {
                Socket socket = serverSocket.accept();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String str = dataInputStream.readUTF();


                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF("我是socket服务端");



            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
