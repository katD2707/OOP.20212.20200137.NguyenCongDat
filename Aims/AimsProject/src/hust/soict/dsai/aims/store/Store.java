package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		this.itemsInStore.add(media);
	}
	
	public void removeMedia(Media media) {
		if (media==null) {
			System.out.println("Media is blank!");
			return ;
		}
		
		for (int i=0; i<this.itemsInStore.size(); i++) {
			if (media.equals(this.itemsInStore.get(i))) {
				itemsInStore.remove(i);
				System.out.println("Media has been removed successfully");
				return ;
			}
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
	
	public String searchByTitle(String title) {
		System.out.println("----------------------------------------------------------------");
		int n_find = 0;
		for (Media media: itemsInStore) {
			if (media.isMatch(title)) {
				n_find = 1;
				return media.toString();
			}
			
		}
		if (n_find==0) {
			return "No match is found";
		}
		System.out.println("----------------------------------------------------------------");
		return "";
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
