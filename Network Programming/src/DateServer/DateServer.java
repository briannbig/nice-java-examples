package DateServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/*
* Simple Server
* Doesn't  read any data from the client
* Limitation:::: Only serves one client at a time*/

public class DateServer {
    private static ServerSocket serverSocket; //serverSocket just listens
    public static void main(String[] args) {
        try {
            System.out.println("Opening Port....");
            serverSocket = new ServerSocket(5771);
            System.out.println("****Just successfully opened port 5771****");
            int count = 0;
          while (true){
              try {
                  Socket socket = serverSocket.accept(); //socket (plain) communicates with the client
                  //the .accept() call is a BLOCKING CALL
                  PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                  out.println("Sever Address: "+ serverSocket.toString() + " DATE: "+ new Date().toString());
                  count++;
                  System.out.println("Client served " + count + " times");
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
