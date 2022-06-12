package hust.soict.dsai.test.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class TestMediaCompareTo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Media> collect = new ArrayList<Media>();
		
		CompactDisc compactDisc = new CompactDisc("Intel");
		compactDisc.addTrack(new Track("IBM Symphony", 13));
		compactDisc.addTrack(new Track("Warmup", 3));
		compactDisc.addTrack(new Track("Scales", 4));
		compactDisc.addTrack(new Track("Introduction", 6));
		
		compactDisc.play();
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladin", 
													"Animation", 
													"Unknown", 
													90,
													18.99f); 

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Star Wars", 
													"Science Fiction", 
													"George Lucas", 
													87, 
													24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
													"Fantasy", 
													"Unknown",
													91,
													18.99f);
		
		//Play DVDs
		dvd1.play();
		dvd2.play();
		dvd3.play();
		
		//Add the DVD objects to the ArrayList
		collect.add(dvd1);
		collect.add(dvd2);
		collect.add(dvd3);
		
		//Iterate through the ArrayList and output their titles
		//(Unsorted order)
		java.util.Iterator iterator = collect.iterator();
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println("The DVDs currently in the order are: ");
		
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		
			//Sort the collection of DVDs - based on the compareTo() method
		java.util.Collections.sort((java.util.List)collect);
		
		//Iterate through the ArrayList and output their titles -
		//in sorted order
		iterator = collect.iterator();
		
		System.out.println("-------------------------------------------------------------------");
		System.out.println("The DVDs in sorted order are: ");
		
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
	
		System.out.println("-------------------------------------------------------------------");
	}

}
