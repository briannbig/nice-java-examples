package TCPSockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPEchoClient {
    private static InetAddress host;
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        accessServer();
    }
    private static void accessServer(){
        Socket link = null; //step 1
        try {
            link = new Socket(host, PORT); //step 1
            Scanner input = new Scanner(link.getInputStream()); //step 2
            PrintWriter output = new PrintWriter(link.getOutputStream()); //step 2
            Scanner sc = new Scanner(System.in);
            String message, response;
            do {
                System.out.println("Enter Message: ");
                message = sc.next();
                output.println(message);  //step 3
                response = input.nextLine(); //step 3
                System.out.println("\nSERVER> " + response);
            }
            while (!message.equals("***"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("**Closing Connection.....**");
                link.close();   ///step 4
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Unable to close Normally");
                System.exit(1);
            }
        }
    }
}
