import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ThreadTask extends ThreadedServer {
	private static final String SERVER_IP = "localhost";
    private static int SERVER_PORT = 9000;
	 Socket socket = null;
	    PrintWriter out = null;
	    BufferedReader in = null;
	    Scanner sc;
	    String serverResponse = null;
	public void example(int c) throws UnknownHostException, IOException{
        for (int i=0; i<c; i++) {
            
            try {
                Thread.sleep(10);
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
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }    
    }
 
 
    public static void main(String[] args) {
    	
    Thread th1 = new Thread();    
    th1.start();
    
    try {
    Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    System.out.println("fin du thread");
 
    }
 


}
