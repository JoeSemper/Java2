package hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static Socket socket = null;

    static DataInputStream in;
    static DataOutputStream out;

    static final int PORT = 8189;
    static final String IP_ADDRESS = "localhost";
    static Scanner scanner;
    static String str;

    public static void main(String[] args) {

        try {
            socket = new Socket(IP_ADDRESS, PORT);
            System.out.println("Подключился");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);


            // чтение
            new Thread(() -> {
                try {
                    String str = null;
                    while (true) {
                        try {
                            str = in.readUTF();

                            if (str.equals("/end")) {
                                break;
                            }

                            System.out.println(str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                } catch (Exception e){

                }
            }).start();

                // отправка
                try {
                    while (true) {
                        str = scanner.nextLine();

                        if (str.equals("/end")) {
                            break;
                        }
                        try {
                            out.writeUTF(str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

