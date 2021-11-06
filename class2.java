package Dev_TP2;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
	public class class2 {

	   public static void main(String [] args) {
	      Employee e = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("/tmp/emp.dat");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Employee) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
	     
	      System.out.println("Deserialized Employee...");
	      System.out.println("Name: " + e.name);
	      System.out.println("Address: " + e.address);
	      System.out.println("SSN: " + e.SSN);
	      System.out.println("Number: " + e.number);
	      
	      try {
			RandomAccessFile raf = new RandomAccessFile("empdirect.dat", "rw");
			
			try {
				raf.seek(0);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			for(int n=0;n<class1.nbr;n++) {
			raf.writeUTF(e.name);
			raf.writeUTF(e.address);
			raf.write(e.SSN);
			raf.write(e.number);
			raf.close();
			}
		} 
			catch (FileNotFoundException e1) {
		
			e1.printStackTrace();
		} catch (IOException e1) {
				
				e1.printStackTrace();
			}
	   }
	}
	