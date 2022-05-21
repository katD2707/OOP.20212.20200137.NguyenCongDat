
public class Aims {
	public static void main(String[] args) {
		// Create new Cart
		Cart anOrder = new Cart();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
													"Animation", 
													"Roger Allers", 
													87, 
													19.95f);
		anOrder.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
													"Science Fiction", 
													"George Lucas", 
													87, 
													24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
													"Animation", 
													18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Snow white", 
													"Animation", 
													21.91f);
		anOrder.addDigitalVideoDisc(dvd4);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Aladin", 
													"Animation", 
													18.99f);
		anOrder.addDigitalVideoDisc(dvd5);
		//print total cost of the items in the cart
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
		//test removeDigitalVideoDisc method
		anOrder.removeDigitalVideoDisc(dvd5);
		
		//test overloading addDigitalVideoDisc method
		DigitalVideoDisc items[] = new DigitalVideoDisc[5];
		items[0] = new DigitalVideoDisc("The Lion King", 
				"Animation", 
				"Roger Allers", 
				87, 
				19.95f);
		items[1] = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", 
				"George Lucas", 
				87, 
				24.95f);
		
		items[2] = new DigitalVideoDisc("The Lion King", 
				"Animation", 
				"Roger Allers", 
				87, 
				19.95f);
		items[3] = new DigitalVideoDisc("Aladin", 
				"Animation", 
				18.99f);
		items[4] = new DigitalVideoDisc("Aladin", 
				"Animation", 
				18.99f);
		
		//test overloading addDigitalVideoDisc method with 2 parameters
		anOrder.addDigitalVideoDisc(items[0], items[1]);

	}
}
