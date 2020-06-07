package lesson6hw;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Сервер запущен!");

            try (Socket socket = server.accept()) {
                System.out.println("Клиент подключился ");

                try(Scanner inClient = new Scanner(socket.getInputStream());
                    PrintWriter outClient = new PrintWriter(socket.getOutputStream(), true);
                    Scanner inConsole = new Scanner(System.in);) {

                    new Thread(() -> {
                        while (true) {
                            String strFromClient = inClient.nextLine();

                            if (strFromClient.equals("/end")) {
                                System.out.println("Клиент отключился");
                                break;
                            }

                            System.out.println("От клиента: " + strFromClient);
                        }
                    }).start();

                    while (true) {
                        String strToClient = inConsole.nextLine();
                        outClient.println(strToClient);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
