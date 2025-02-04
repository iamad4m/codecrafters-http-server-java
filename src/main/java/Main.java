import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
  public static void main(String[] args) {
    // You can use print statements as follows for debugging, they'll be visible when running tests.
    System.out.println("Logs from your program will appear here!");
    // Uncomment this block to pass the first stage
    //
     ServerSocket serverSocket = null;
     Socket clientSocket = null;

     try {
         // Since the tester restarts your program quite often, setting SO_REUSEADDR
         // ensures that we don't run into 'Address already in use' errors
         serverSocket = new ServerSocket(4221);
         serverSocket.setReuseAddress(true);
         while (true) {
             clientSocket = serverSocket.accept(); // Wait for connection from client.
            new Thread(new RequestHandler(clientSocket, args)).start();
         }
     } catch (IOException e){
         System.out.println("IOException: " + e.getMessage());
     }
  }
}
