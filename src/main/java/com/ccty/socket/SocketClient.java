package com.ccty.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) {
        Socket socket = new Socket();
        try {
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String str= dataInputStream.readUTF();


            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("你好，我是client。。。");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
