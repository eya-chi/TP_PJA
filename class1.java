package Dev_TP2;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java. util. Scanner;
public class class1 {
static int nbr;
   public static void main(String [] args) {
	   System.out.println("Entrer le nombre d'objeets à créer");
	   Scanner input = new Scanner( System.in );
	  nbr = input.nextInt();
	   for(int n=0;n<nbr;n++) {
		   
		   Employee e = new Employee();
		      
		    e.name = input.next();
		      e.address = input.next();
		      e.SSN = input.nextInt();
		      e.number = input.nextInt(); 
		     
		      try {
		          FileOutputStream fileOut =
		          new FileOutputStream("/tmp/emp.dat");
		          ObjectOutputStream out = new ObjectOutputStream(fileOut);
		          out.writeObject(e);
		          out.close();
		          fileOut.close();
		          System.out.printf("Serialized data is saved in /tmp/emp.dat", args);
		       } catch (IOException i) {
		          i.printStackTrace();
		       }
		    }
	   }
    
      
     
}