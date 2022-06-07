package hust.soict.dsai.aims.utils;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class MediaUtils {
	
	public static void swap(ArrayList<Media> dvd_list, int j, int i) {
		Media tmp = dvd_list.get(j);
		dvd_list.set(j, dvd_list.get(i));
		dvd_list.set(i, tmp);
	}
	
	public static StringBuffer compareByCost(Media media1, Media media2) {
		StringBuffer message = new StringBuffer();
		message.append("Media ");
		if (media1.getCost() == media2.getCost()) {
			message.append(media1.getTitle()); 
			message.append(" and media ");
			message.append(media2.getTitle());
			message.append(" have the same cost");
		}
		else if (media1.getCost() < media2.getCost()) {
			message.append(media1.getTitle());
			message.append(" costs less than media ");
			message.append(media2.getTitle());
		}
		else {
			message.append(media1.getTitle());
			message.append(" costs more than media ");
			message.append(media2.getTitle());
		}
		return message;
	}
	
	public static StringBuffer compareByTitle(Media media1, Media media2) {
		int compare = (media1.getTitle().toLowerCase()).compareTo(media2.getTitle().toLowerCase());
		StringBuffer message = new StringBuffer();
		message.append("Media ");
		if (compare==0) {
			message.append(media1.getTitle()); 
			message.append(" and media ");
			message.append(media2.getTitle());
			message.append(" have the same title");
		}	
		else if (compare<0) {
			message.append(media1.getTitle());
			message.append(" appears before media ");
			message.append(media2.getTitle());
			message.append(" in cart");
		}
		else {
			message.append(media1.getTitle());
			message.append(" appears after media ");
			message.append(media2.getTitle());
			message.append(" in cart");
			}
		return message;
	}
	
	public static ArrayList<Media> sortByCost(ArrayList<Media> dvd_list) {
		if (dvd_list.size()==1) {
			return dvd_list;
		}
		for (int i=1; i<dvd_list.size(); i++) {
			for (int j=0; j<i; j++) {
				if (dvd_list.get(j).getCost() < dvd_list.get(i).getCost()) {
					swap(dvd_list, j, i);
				}
				else if (dvd_list.get(j).getCost() == dvd_list.get(i).getCost()) {
					int compareTitle = (dvd_list.get(j).getTitle().toLowerCase()).compareTo(dvd_list.get(i).getTitle().toLowerCase());
					if (compareTitle>0) {
						swap(dvd_list, j, i);
					}
				}
			}
		}
		return dvd_list;
	}
	
	public static ArrayList<Media> sortByTitle(ArrayList<Media> dvd_list) {
		for (int i=1; i<dvd_list.size(); i++) {
			for (int j=0; j<i; j++) {
				int compareTitle = (dvd_list.get(j).getTitle().toLowerCase()).compareTo(dvd_list.get(i).getTitle().toLowerCase());
				if (compareTitle>0) {
					swap(dvd_list, j, i);
				}
				else if (compareTitle==0) {
					if (dvd_list.get(j).getCost() < dvd_list.get(i).getCost()) {
						swap(dvd_list, j, i);
					}
				}
			}
		}
		return dvd_list;
	}
	
}
