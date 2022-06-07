package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_STORE_ITEMS = 1000;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		this.itemsInStore.add(media);
	}
	
	public void addMedia(Media media1, Media media2) {
		if (media1 != null) {
			this.itemsInStore.add(media1);
		}
		if (media2 != null) {
			this.itemsInStore.add(media2);
		}
	}
	
	public void addMedia(Media... medias) {
		for (Media media: medias) {
			if (media != null) {
				this.itemsInStore.add(media);
			}
		}
	}
	
	public void removeMedia(Media media) {
		ArrayList<Media> newOrdered = new ArrayList<Media>();
		int before = itemsInStore.size();
		
		if (media==null) {
			System.out.println("Media is blank!");
			return ;
		}
		
		for (Media item: itemsInStore) {
			if (item.getTitle()!=media.getTitle()) {
				newOrdered.add(item);
			}
		}
		this.itemsInStore = newOrdered;
		int after = itemsInStore.size();
		if (before==after) {
			System.out.println("No media has been removed");
		}
		else {
			System.out.println((before-after) + " items has been removed");
		}
	}

	
	public void displayStore() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("Available dvds in store: ");
		for (Media media: itemsInStore) {
			System.out.println(media.toString());
		}
		System.out.println("----------------------------------------------------------------");
		System.out.println();
	}
	
	public void searchByTitle(String title) {
		System.out.println("----------------------------------------------------------------");
		int n_find = 0;
		for (Media media: itemsInStore) {
			n_find = 1;
			System.out.println(media.isMatch(title));
		}
		if (n_find==0) {
			System.out.println("No match is found");
		}
		System.out.println("----------------------------------------------------------------");
	}
	
	public Media getMedia(String title) {
		for (Media media: itemsInStore) {
			if (media.isMatch(title)) {
				return media;
			}
		}
		System.out.println("No match is found");
		return null;
	}
}
