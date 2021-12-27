import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.lang.Runnable;

public class ThreadedServer implements Runnable{
	  PrintWriter out = null;
      String clientInput = null;
      BufferedReader input = null;
      Socket socket = null;
      String nomrep = null;
      String nomFichier = null;
	public void run() {
         {
        	 try {
                 ServerSocket serverSocket = new ServerSocket(9000);
                 out = new PrintWriter(socket.getOutputStream(), true);
                 input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 
                 while (true) {
                 	clientInput = input.readLine();
                 	while(!clientInput.equals("quit")) {
                     socket = serverSocket.accept();
                     System.out.println("Server Listening on Port _9000");
                     if(clientInput.equals("list"+nomrep)) {
                     	
     					ListFile(nomrep);
                     }
                     else if(clientInput.equals("get"+nomFichier)) {
                     	ReadTxt(nomFichier);
                     }
                 	}
                 }
             }
                 	
                     catch (Exception e) {
                         e.printStackTrace();
                    } finally {
                            try {
                                socket.close();
                                
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                    }
                    }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	private static void ReadTxt(String nomFichier) {
		
		 BufferedReader reader;
	        boolean pasFini = true;
	        String ligne;
	 
	        try {
	            reader = new BufferedReader(
	                    new FileReader("nomFichier.txt"));
	 
	            while (pasFini) {
	                ligne = reader.readLine();
	 
	                if (ligne != null) {
	                    System.out.println(ligne);
	                } else {
	                    pasFini = false;
	                }
	            }
	 
	            reader.close();
	        } catch (IOException ioe) {
	            System.err.println(ioe);
	            System.exit(1);
	        }
	}



	private static void ListFile(String nomrep) throws IOException {
	     File dir  = new File("C:\\Users\\PC\\Desktop\\"+nomrep);
		File[] liste = dir.listFiles();
		for(File item : liste){
		  if(item.isFile())
		  { 
		    System.out.format("Nom du fichier: %s%n", item.getName()); 
		  } 
		  else if(item.isDirectory())
		  {
		    System.out.format("Nom du répertoir: %s%n", item.getName()); 
		  }
		  else {
			 System.out.println("ERROR : File/directory does not exist");
		  }
		 
		}
	  }
	public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadedServer()); 
        
        t1.start();
        
       
        
	}      
}
