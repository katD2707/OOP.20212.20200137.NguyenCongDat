package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.MediaUtils;
import java.util.Random;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (itemsOrdered.size()<MAX_NUMBERS_ORDERED) {
			if (media != null) {
				for (Media item: itemsOrdered) {
					if (media.equals(item)) {
						System.out.println("Media is already in cart");
						return ;
					}
				}
				this.itemsOrdered.add(media);
				System.out.println("Media is added successfully");
			}
		}
		else {
			System.out.println("Cart is full");
		}
	}
	
	public void removeMedia(Media media) {
		ArrayList<Media> newOrdered = new ArrayList<Media>();
		
		int before = itemsOrdered.size();
		for (Media item: itemsOrdered) {
			if (item.getTitle()!=media.getTitle()) {
				newOrdered.add(item);
			}
		}
		this.itemsOrdered = newOrdered;
		
		int after = itemsOrdered.size();
		if (before==after) {
			System.out.println("No media has been removed");
		}
		else {
			System.out.println((before-after) + " items has been removed");
		}
	}
	
	public float totalCost() {
		float total = 0;
		for (Media item: itemsOrdered) {
			total += item.getCost();
		}
		return total;
	}
	
	public void costSortDisplay() {
		System.out.println("----------------------------------------------------------------");
		this.itemsOrdered = MediaUtils.sortByCost(itemsOrdered);
		System.out.println("Sort by cost: ");
		for (Media media: itemsOrdered) {
			System.out.println(media.toString());
		}
		System.out.println("----------------------------------------------------------------");
	}
	
	public void titleSortDisplay() {
		System.out.println("----------------------------------------------------------------");
		this.itemsOrdered = MediaUtils.sortByTitle(itemsOrdered);
		System.out.println("Sort by title: ");
		for (Media media: itemsOrdered) {
			System.out.println(media.toString());
		}
		System.out.println("----------------------------------------------------------------");
	}
	
	public void searchById(int id) {
		System.out.println("----------------------------------------------------------------");
		for (Media media: itemsOrdered) {
			if (media.getId() == id) {
				System.out.println("Disc found!");
				System.out.println(media.toString());
				System.out.println("----------------------------------------------------------------");
				
				return ;
			}
		} 
		System.out.println("No match is found");
		System.out.println("----------------------------------------------------------------");
		
	}
	
	public void display() {
		System.out.println("***********************CART***********************");
		for (Media media: itemsOrdered) {
			System.out.println(media.toString());
		}
		System.out.println("**************************************************");
		
	}
	public void print() {
		this.itemsOrdered = MediaUtils.sortByTitle(itemsOrdered);
		System.out.println("***********************CART***********************");
		for (Media media: itemsOrdered) {
			System.out.println(media.toString());
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("**************************************************");
	}
	
	public void searchByTitle(String title) {
		System.out.println("----------------------------------------------------------------");
		int n_find = 0;
		for (Media media: itemsOrdered) {
			if (media.isMatch(title)) {
				if (n_find == 0) {
					System.out.println("Disc found!");
				}
				n_find += 1;
				System.out.println(media.toString());
			}
		}
		if (n_find==0) {
			System.out.println("No match is found");
		}
		System.out.println("----------------------------------------------------------------");
	}
	
	public Media getALuckyItem() {
		if (itemsOrdered.size()>=5) {
			Random rn = new Random();
			int randNum = rn.nextInt(itemsOrdered.size());
			this.itemsOrdered.remove(randNum);
			return itemsOrdered.get(randNum);
		}
		System.out.println("You haven't bought enough items to get a lucky item");
		return null;
	}
	
	public int getNumOrdered() {
		return this.itemsOrdered.size();
	}
	
	
}

