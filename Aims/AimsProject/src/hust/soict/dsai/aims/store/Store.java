package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_STORE_ITEMS = 1000;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	private int num_dvd = 0;
	private DigitalVideoDisc nullDVD = new DigitalVideoDisc("");
	
	public void addMedia() {
		
	}
	
	public void removeMedia() {
		
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
