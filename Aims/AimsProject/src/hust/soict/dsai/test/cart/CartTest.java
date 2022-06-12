package hust.soict.dsai.test.cart;


import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		// Create new Cart
		Cart cart = new Cart();
				
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
													"Animation", 
													"Roger Allers", 
													87, 
													19.95f);
		cart.addMedia(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
													"Science Fiction", 
													"George Lucas", 
													87, 
													4.95f);
		cart.addMedia(dvd2);
				
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
													"Animation", 
													18.99f);
		cart.addMedia(dvd3);
				
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Snow white", 
													"Animation", 
													21.91f);
		cart.addMedia(dvd4);
				
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Aladin", 
													"Animation", 
													18.99f);
		cart.addMedia(dvd5);
		cart.removeMedia(dvd1);
		//Test print method
		cart.print();
		//Test search method
		cart.searchById(4);
		
	}

}
