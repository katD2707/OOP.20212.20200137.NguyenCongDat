package hust.soict.dsai.aims.utils;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class DVDUtils {
	
	public static void swap(DigitalVideoDisc[] dvd_list, int j, int i) {
		DigitalVideoDisc tmp = dvd_list[j];
		dvd_list[j] = dvd_list[i];
		dvd_list[i] = tmp;
	}
	
	public static StringBuffer compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		StringBuffer message = new StringBuffer();
		message.append("Dvd ");
		if (dvd1.getCost() == dvd2.getCost()) {
			message.append(dvd1.getTitle()); 
			message.append(" and dvd ");
			message.append(dvd2.getTitle());
			message.append(" have the same cost");
		}
		else if (dvd1.getCost() < dvd2.getCost()) {
			message.append(dvd1.getTitle());
			message.append(" costs less than dvd ");
			message.append(dvd2.getTitle());
		}
		else {
			message.append(dvd1.getTitle());
			message.append(" costs more than dvd ");
			message.append(dvd2.getTitle());
		}
		return message;
	}
	
	public static StringBuffer compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		int compare = (dvd1.getTitle().toLowerCase()).compareTo(dvd2.getTitle().toLowerCase());
		StringBuffer message = new StringBuffer();
		message.append("Dvd ");
		if (compare==0) {
			message.append(dvd1.getTitle()); 
			message.append(" and dvd ");
			message.append(dvd2.getTitle());
			message.append(" have the same title");
		}	
		else if (compare<0) {
			message.append(dvd1.getTitle());
			message.append(" appears before dvd ");
			message.append(dvd2.getTitle());
			message.append(" in cart");
		}
		else {
			message.append(dvd1.getTitle());
			message.append(" appears after dvd ");
			message.append(dvd2.getTitle());
			message.append(" in cart");
			}
		return message;
	}
	
	
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvd_list) {
		if (dvd_list.length==1) {
			return dvd_list;
		}
		for (int i=1; i<dvd_list.length; i++) {
			if (dvd_list[i]!=null) {
				for (int j=0; j<i; j++) {
					if (dvd_list[j].getCost() < dvd_list[i].getCost()) {
						swap(dvd_list, j, i);
					}
					else if (dvd_list[j].getCost() == dvd_list[i].getCost()) {
						int compareTitle = (dvd_list[j].getTitle().toLowerCase()).compareTo(dvd_list[i].getTitle().toLowerCase());
						if (compareTitle>0) {
							swap(dvd_list, j, i);
						}
						else if (compareTitle==0) {
							if (dvd_list[j].getLength() < dvd_list[i].getLength()) {
								swap(dvd_list, j, i);
							}
						}
					}
				}
			}
		}
		return dvd_list;
	}
	
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvd_list) {
		for (int i=1; i<dvd_list.length; i++) {
			if (dvd_list[i]!=null) {
				for (int j=0; j<i; j++) {
					int compareTitle = (dvd_list[j].getTitle().toLowerCase()).compareTo(dvd_list[i].getTitle().toLowerCase());
					if (compareTitle>0) {
						swap(dvd_list, j, i);
					}
					else if (compareTitle==0) {
						if (dvd_list[j].getCost() < dvd_list[i].getCost()) {
							swap(dvd_list, j, i);
						}
						else if (dvd_list[j].getCost() == dvd_list[i].getCost()) {
							if (dvd_list[j].getLength() < dvd_list[i].getLength()) {
								swap(dvd_list, j, i);
							}
						}
					}
				}
			}
		}
		return dvd_list;
	}
	
}
