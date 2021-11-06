package Dev_TP2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class class3 {
	public static void main(String [] args) {
	Employee e = new Employee();
	Scanner sc = new Scanner( System.in );
	System.out.println("Entrer le numero d'employé");
	RandomAccessFile raf = null;
	try {
		raf = new RandomAccessFile("empdirect.dat", "r");
	} catch (FileNotFoundException e2) {
				e2.printStackTrace();
	}
	 int num=sc.nextInt();
	 try {
		raf.readInt();
		 if(num==e.SSN) {
				System.out.println(num+e.name+e.address+e.number);
			 }
		 else {
			 System.out.println("Employé n'éxiste pas");
		 }
		 raf.close();
	} catch (IOException e1) {
		e1.printStackTrace();
		
	}
	
	
}
}