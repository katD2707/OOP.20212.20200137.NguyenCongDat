package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class DiskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create new Cart
		Cart cart = new Cart();
				
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
													"Animation", 
													"Roger Allers", 
													87, 
													19.95f);
		cart.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
													"Science Fiction", 
													"George Lucas", 
													87, 
													24.95f);
		cart.addDigitalVideoDisc(dvd2);
				
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
													"Animation", 
													18.99f);
		cart.addDigitalVideoDisc(dvd3);
				
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Snow white", 
													"Animation", 
													21.91f);
		cart.addDigitalVideoDisc(dvd4);
				
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Aladin", 
													"Animation", 
													18.99f);
		
		cart.addDigitalVideoDisc(dvd5);
		
		System.out.println(dvd3.getDateAdded());
		//test searching by title method
		cart.searchByTitle("kiNG");
	}

}
