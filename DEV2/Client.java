import java.net.*;
import java.util.Scanner;
import java.io.*;


public class Client {

    private static final String SERVER_IP = "localhost";
    private static int SERVER_PORT = 9000;

    public static void main(String [] args) {
    Socket socket = null;
    PrintWriter out = null;
    BufferedReader in = null;
    Scanner sc;
    String serverResponse = null;
    try {
        socket = new Socket(SERVER_IP, SERVER_PORT);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        sc = new Scanner(System.in);
        do {
            out.println(sc.nextLine()); 
            serverResponse = in.readLine(); 
            System.out.println(serverResponse);
        } while (!sc.nextLine().equals("quit"));
        System.out.println("Connexion ended ");
       
    } catch(Exception e){
            System.out.println("Exception occured " + e.getMessage());
    }
    finally {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}
