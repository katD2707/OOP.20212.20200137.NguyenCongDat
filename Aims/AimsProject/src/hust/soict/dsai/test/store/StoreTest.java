package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
		
		DigitalVideoDisc dvd = new DigitalVideoDisc("Aladin", 
													"Animation", 
													18.99f);
		
		//test adding 1 Digital video disc method
		store.addMedia(dvd);
		//test removing 1 Digital video disc method
		store.removeMedia(dvd);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Aladin", 
						"Animation", 
						18.99f); 
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
						"Science Fiction", 
						"George Lucas", 
						87, 
						24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
						"Animation", 
						18.99f);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Snow white", 
						"Animation", 
						21.91f);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King", 
						"Animation", 
						"Roger Allers", 
						87, 
						19.95f);

		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Aladin", 
						"Animation", 
						18.99f);
		
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Aladin", 
						"Animation", 
						18.99f);
		
		//test adding multiple Digital video discs method
		store.addMedia(dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, dvd7);
		store.displayStore();
		
		//test removing multiple Digital video discs method
		store.removeMedia(dvd3);
		
	}

}
