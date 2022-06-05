package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.DVDUtils;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia() {
		
	}
	
	public void removeMedia() {
		
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

