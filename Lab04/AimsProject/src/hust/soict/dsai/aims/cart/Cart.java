package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils;

public class Cart {
	private int qtyOrdered = 0;
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
		
	public int getNumOrdered() {
		return qtyOrdered;
	}

	public int addDigitalVideoDisc(DigitalVideoDisc disc) {
		System.out.println("----------------------------------------------------------------");
		if (!disc.getTitle().equals("")) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = disc;
				qtyOrdered += 1;
				System.out.println("Disc " + disc.getTitle() + " has been added");
				if (qtyOrdered >= (MAX_NUMBERS_ORDERED-2)) {
					System.out.println("The cart is almost full");
				}
				System.out.println("----------------------------------------------------------------");
				
				return 1;
			}
			else {
				System.out.println("The cart is full");
				System.out.println("----------------------------------------------------------------");
				
				return 0;
			}
		}
		System.out.println("----------------------------------------------------------------");
		
		return 0;
	}
		
	
	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
		int num_added = 0;
		for (int i=0; i<dvdList.length; i++) {
			num_added += this.addDigitalVideoDisc(dvdList[i]);
		}
		System.out.print("Number of disc added: ");
		System.out.println(num_added);
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (!dvd1.getTitle().equals("")) {
			this.addDigitalVideoDisc(dvd1);
		}
		
		if (!dvd2.getTitle().equals("")) {
			this.addDigitalVideoDisc(dvd2);
		}
		
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd, int n_disc) {
		int num_added = 0;
		if (!dvd.getTitle().equals("")) {
			for (int i=0; i<n_disc; i++) {
				num_added += this.addDigitalVideoDisc(dvd);
			}
			
			System.out.print("Number of discs added: ");
			System.out.println(num_added);	
			System.out.println("----------------------------------------------------------------");
			
		}
		
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		System.out.println("----------------------------------------------------------------");
		int num_del = 0;
		int num_ordered = qtyOrdered;
		for (int i=0; i<num_ordered; i++) {
			if (itemsOrdered[i].getTitle().equals(disc.getTitle())) {
					itemsOrdered[i] = null;
					qtyOrdered -= 1;
					num_del += 1;
			}
		}
		
		int id = 0;
		for (int i=qtyOrdered; i<(qtyOrdered+num_del); i++) {
			if (itemsOrdered[i]!=null) {
				boolean stop = false;
				for (int j=id; j<qtyOrdered; j++) {
					if ((itemsOrdered[j]==null)&&(stop!=true)) {
						itemsOrdered[j] = itemsOrdered[i];
						itemsOrdered[i] = null;
						id += 1;
						stop = true;
					}
				}
			}
		}
			
		System.out.print("Number of disc has title " + disc.getTitle() + " removed: ");
		System.out.println(num_del);
		System.out.println("----------------------------------------------------------------");
		System.out.println("");
	}
	
	public float totalCost() {
		float total = 0;
		for (int i=0; i<qtyOrdered; i++) {
			if (itemsOrdered[i] != null) {
				total += itemsOrdered[i].getCost();
			}
		}
		return total;
	}
	
	public void costSortDisplay() {
		System.out.println("----------------------------------------------------------------");
		this.itemsOrdered = DVDUtils.sortByCost(itemsOrdered);
		System.out.println("Sort by cost: ");
		for (int i=0; i<qtyOrdered; i++) {
			System.out.println(this.itemsOrdered[i].toString());
		}
		System.out.println("----------------------------------------------------------------");
	}
	
	public void titleSortDisplay() {
		System.out.println("----------------------------------------------------------------");
		this.itemsOrdered = DVDUtils.sortByTitle(itemsOrdered);
		System.out.println("Sort by title: ");
		for (int i=0; i<qtyOrdered; i++) {
			System.out.println(this.itemsOrdered[i].toString());
		}
		System.out.println("----------------------------------------------------------------");
	}
	
	public void searchById(int id) {
		System.out.println("----------------------------------------------------------------");
		for (int i=0; i< qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				System.out.println("Disc found!");
				System.out.println(itemsOrdered[i].toString());
				System.out.println("----------------------------------------------------------------");
				
				return ;
			}
		} 
		System.out.println("No match is found");
		System.out.println("----------------------------------------------------------------");
		
	}
	
	public void display() {
		System.out.println("***********************CART***********************");
		for (int i=0; i<qtyOrdered; i++) {
			System.out.println(this.itemsOrdered[i].toString());
		}
		System.out.println("**************************************************");
		
	}
	public void print() {
		this.itemsOrdered = DVDUtils.sortByTitle(itemsOrdered);
		System.out.println("***********************CART***********************");
		for (int i=0; i<qtyOrdered; i++) {
			System.out.println(this.itemsOrdered[i].toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("**************************************************");
	}
	
	public void searchByTitle(String title) {
		System.out.println("----------------------------------------------------------------");
		int n_find = 0;
		for (int i=0; i<qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title)) {
				if (n_find == 0) {
					System.out.println("Disc found!");
				}
				n_find += 1;
				System.out.println(itemsOrdered[i].toString());
			}
		}
		if (n_find==0) {
			System.out.println("No match is found");
		}
		System.out.println("----------------------------------------------------------------");
	}
	
	
}

