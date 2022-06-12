package hust.soict.dsai.test.polymorphism;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class TestPolymorphismToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Media> mediae = new ArrayList<Media>();
		
		CompactDisc cd = new CompactDisc("TheWeeknd");
		DigitalVideoDisc dvd = new DigitalVideoDisc("Snow white");
		Book book = new Book("Jungle book");
		
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		
		for (Media m:mediae) {
			System.out.println(m.toString());
		}
		
	}

}
