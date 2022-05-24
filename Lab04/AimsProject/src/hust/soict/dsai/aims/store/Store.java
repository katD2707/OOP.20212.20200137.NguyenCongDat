package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_STORE_ITEMS = 1000;
	private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_STORE_ITEMS];
	private int num_dvd = 0;
	private DigitalVideoDisc nullDVD = new DigitalVideoDisc("");
	
	public void addDVD(DigitalVideoDisc dvd) {
		System.out.println("----------------------------------------------------------------");
		if (this.num_dvd<MAX_STORE_ITEMS) {
			System.out.println("Disc added to store: ");
			this.itemsInStore[num_dvd] = dvd;
			this.num_dvd += 1;
			System.out.println(dvd.toString());
		}
		else {
			System.out.println("Store is full");
		}
		System.out.println("----------------------------------------------------------------");
		System.out.println();
	}
	
	public void addDVD(DigitalVideoDisc... dvd_list) {
		for (DigitalVideoDisc dvd : dvd_list) {
			this.addDVD(dvd);
		}
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
		System.out.println("----------------------------------------------------------------");
		for (int i=0; i<this.num_dvd; i++) {
			if (this.itemsInStore[i].getTitle().equals(dvd.getTitle())) {
				System.out.println("Disc removed from store:");
				System.out.println(this.itemsInStore[i].toString());
				itemsInStore[i] = itemsInStore[num_dvd-1];
				itemsInStore[num_dvd-1] = null;
				num_dvd -= 1;
				return ;
			}
		}
		System.out.println("No match is found");
		System.out.println("----------------------------------------------------------------");
		System.out.println();
	}
	
	public void removeDVD(DigitalVideoDisc... dvd_list) {
		System.out.println("----------------------------------------------------------------");
		System.out.println("Discs removed from store: ");
		for (int i=0; i<dvd_list.length; i++) {
			boolean stop = false;
			for (int j=0; j<num_dvd; j++) {
				if (itemsInStore[j].getTitle().equals(dvd_list[i].getTitle())
						&& stop != true) {
					System.out.println(itemsInStore[j].toString());
					itemsInStore[j] = itemsInStore[num_dvd-1];
					itemsInStore[num_dvd-1] = null;
					num_dvd -= 1;
					stop = true;
				}
			}
		}
		System.out.println("----------------------------------------------------------------");
		System.out.println();
	}
	
	public void displayStore() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("Available dvds in store: ");
		for (int i=0; i<num_dvd; i++) {
			System.out.println(itemsInStore[i].toString());
		}
		System.out.println("----------------------------------------------------------------");
		System.out.println();
	}
	
	public void searchByTitle(String title) {
		System.out.println("----------------------------------------------------------------");
		int n_find = 0;
		for (int i=0; i<num_dvd; i++) {
			if (itemsInStore[i].isMatch(title)) {
				n_find += 1;
				System.out.println(itemsInStore[i].toString());
			}
		}
		if (n_find==0) {
			System.out.println("No match is found");
		}
		System.out.println("----------------------------------------------------------------");
	}
	
	public DigitalVideoDisc getDVD(String title) {
		for (int i=0; i<num_dvd; i++) {
			if (itemsInStore[i].isMatch(title)) {
				return itemsInStore[i];
			}
		}
		System.out.println("No match is found");
		return nullDVD;
	}
}
