package hw6;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {

    static ServerSocket server = null;
    static Socket socket = null;

    static DataInputStream in;
    static DataOutputStream out;

    static final int PORT = 8189;
    static String str;
    static Scanner scanner = new Scanner(System.in);;

    public static void main(String[] args) {

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");
            socket = server.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

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
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

