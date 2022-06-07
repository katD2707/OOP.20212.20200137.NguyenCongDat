package hust.soict.dsai.test.utils;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.MediaUtils;

public class DVDTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.6f);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "cccc", "cccc", 3, 5.6f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("AAAA", "dddd", "dddd", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		
		System.out.println(MediaUtils.compareByCost(dvd1, dvd2));
		System.out.println(MediaUtils.compareByTitle(dvd5, dvd3));
		
		ArrayList<Media> arrDVD = new ArrayList<Media>();
		arrDVD.add(dvd1);
		arrDVD.add(dvd2);
		arrDVD.add(dvd3);
		arrDVD.add(dvd4);
		arrDVD.add(dvd5);
		
		ArrayList<Media> sorted = MediaUtils.sortByCost(arrDVD);
		System.out.println("Sort by cost: ");
		for (int i=0; i<sorted.size(); i++) {
			System.out.println(sorted.get(i).toString());
		}
		
		sorted = MediaUtils.sortByTitle(arrDVD);
		System.out.println("Sort by title: ");
		for (int i=0; i<sorted.size(); i++) {
			System.out.println(sorted.get(i).toString());
		}
	}

}
