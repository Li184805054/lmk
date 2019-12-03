import Customer.*;
import Movie.*;
import Rental.*;
public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Movie m1=new Movie("Math",15);
		Movie m2=new Movie("English",20);
		Movie m3=new Movie("Science",10);
		
		Renta1 r1=new Renta1(m1,3);
		Renta1 r2=new Renta1(m2,5);
		Renta1 r3=new Renta1(m3,4);
		
		Customer1 c1=new Customer1("Lily");
		Customer1 c2=new Customer1("Mike");
		
		c1.addRental(r1); 	
                c1.addRental(r2); 	
                c1.addRental(r3);
		c2.addRental(r1); 
                c2.addRental(r2);
		System.out.println(c1.statement());
		System.out.println(c2.statement());
	}

}
