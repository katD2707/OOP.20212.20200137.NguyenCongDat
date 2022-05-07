
public class Cart {
	private int qtyOrdered = 0;
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc has been added");
		}
		else if (qtyOrdered == (MAX_NUMBERS_ORDERED - 2)) {
			System.out.println("The cart is almost full");
		}
		else {
			System.out.println("The cart is full");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		int num_added = 0;
		for (int i=0; i<dvdList.length; i++) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = dvdList[i];
				num_added += 1;
				qtyOrdered += 1;
				System.out.println("Item " + (i+1) + " in DVD list has been added to cart");
			}
			else {
				System.out.println("Cart can't store the whole dvd list");
			}
		}
		System.out.println("Number of disc added: ");
		System.out.println(num_added);
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered += 1;
			System.out.println("DVD 1 has been added");
		}
		else {
			System.out.println("The cart is full");
		}
		
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd2;
			qtyOrdered += 1;
			System.out.println("DVD 2 has been added");
		}
		else {
			System.out.println("The cart is full");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd, int n_disc) {
		int num_added = 0;
		for (int i=0; i<n_disc; i++) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = dvd;
				qtyOrdered += 1;
				num_added += 1;
				System.out.println("DVD has been added");
			}
			else {
				System.out.println("The cart is full");
			}
		}
		System.out.println("Number of disc added: ");
		System.out.println(num_added);	
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int num_del = 0;
		for (int i=0; i<=qtyOrdered; i++) {
			if (itemsOrdered[i].getTitle().equals(disc.getTitle())) {
					itemsOrdered[i] = itemsOrdered[qtyOrdered];
					itemsOrdered[qtyOrdered] = null;
					qtyOrdered -= 1;
					num_del += 1;
			}
		}
			
		System.out.println("Number of discs removed: ");
		System.out.println(num_del);
	}
	
	public float totalCost() {
		float total = 0;
		for (int i=0; i<itemsOrdered.length; i++) {
			if (itemsOrdered[i] != null) {
				total += itemsOrdered[i].getCost();
			}
		}
		return total;
	}
}

