package hust.soict.dsai.aims.utils;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media>{

	@Override
	public int compare(Media o1, Media o2) {
		int TitleCompare = o1.getTitle().compareToIgnoreCase(o2.getTitle());
		int CostCompare = (o1.getCost() - o2.getCost())<=0?1:-1;
		
		return (TitleCompare==0)?CostCompare:TitleCompare;
	}
}
