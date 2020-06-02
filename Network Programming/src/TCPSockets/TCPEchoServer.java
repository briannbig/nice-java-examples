package TCPSockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/************************************************** /
/    Server that echoes back client's messages.     /
/    At end of dialogue, sends message indicating   /
/    number of messages received. Uses TCP.         /
 ***************************************************/
public class TCPEchoServer {
    private static ServerSocket serverSocket;
    private static final int PORT = 1234;

    public static void main(String[] args) {
        System.out.println("Opening ports........");
        try {
            serverSocket = new ServerSocket(PORT);  //Step 1
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Unable to attach to port\nREASON: "+ e.toString());
        }
        System.out.println("Ports Open Success\nHandling Client");
        do {
            handleClient();
        }
        while (true);
    }
    private static void handleClient(){
        Socket link = null;                                     //step 2
        try {
            link = serverSocket.accept();                       //step 2
            Scanner input = new Scanner(link.getInputStream()); //step 3
            PrintWriter output = new PrintWriter(link.getOutputStream(), true); //step3
            int numMessages = 0;
            String message = input.nextLine();                  //*************step 4
            while (!message.equals("***")){
                System.out.println("Message received");
                numMessages++;
                output.println("Message " + numMessages + ": " + message); //step 4
                message = input.nextLine();
            }
            output.println(numMessages + " Messages received"); //step 4
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                System.out.println("\n*Closing Connection.....*");
                link.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Unable to exit properly: \nREASON: " + e.toString());
            }
        }
    }
}
/********STEPS*******************************
* 1. create a ServerSocket object.
* 2. put the server in a waiting state. {Socket link = ServerSocketObject.accept();}
* 3. setting up input and output streams
 * a. {Scanner input = new Scanner(link.getInputStream());} --> obtaining String from streams associated with the Socket returned in step 2
 * b.
* 4. Send and Receive Data.
 * a. input.nextLine() for receiving data
 * b. output.println() for sending data
* 5. Closing the Connection
 * * */
