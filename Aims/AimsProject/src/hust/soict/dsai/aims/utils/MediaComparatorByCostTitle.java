package hust.soict.dsai.aims.utils;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media>{

	@Override
	public int compare(Media o1, Media o2) {
		if (o1.getCost()>o2.getCost()) {
			return -1;
		} else if (o1.getCost()<o2.getCost()) {
			return 1;
		}	else {
			return o1.getTitle().compareTo(o2.getTitle());
		}
		
	}

}
