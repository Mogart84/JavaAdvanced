package lesson6hw;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 8189);
             Scanner inServer = new Scanner(socket.getInputStream());
             PrintWriter outServer = new PrintWriter(socket.getOutputStream(),true);
             Scanner inConsole = new Scanner(System.in)) {

            new Thread(() -> {
                while (true) {
                    String strFromServer = inServer.nextLine();

                    if (strFromServer.equals("/end")) {
                        System.out.println("Сервер отключился");
                        break;
                    }

                    System.out.println("От сервера: " + strFromServer);
                }
            }).start();

            while (true) {
                String strToServer = inConsole.nextLine();
                outServer.println(strToServer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
