import java.util.ArrayList;

public class Cart {
	private int qtyOrdered = 0;
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("Reach maximum orders");
		}
		else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i=0; i<itemsOrdered.length; i++) {
			if (itemsOrdered[i] == disc) {
				itemsOrdered[i] = null;
				qtyOrdered -= 1;
			}
		}
	}
}

