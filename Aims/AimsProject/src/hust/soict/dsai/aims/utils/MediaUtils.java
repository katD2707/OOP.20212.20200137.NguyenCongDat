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
	
	public static void sortByCost(ArrayList<Media> dvd_list) {
		java.util.Collections.sort(dvd_list, Media.COMPARE_BY_COST_TITLE);
	}
	
	public static void sortByTitle(ArrayList<Media> dvd_list) {
		java.util.Collections.sort(dvd_list, Media.COMPARE_BY_TITLE_COST);
	}
	
}
