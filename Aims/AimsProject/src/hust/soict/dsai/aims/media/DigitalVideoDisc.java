package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.playable.Playable;

public class DigitalVideoDisc extends Disc implements Playable {
	
	public DigitalVideoDisc() {
		super();
	}
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, float cost) {
		super(title, cost);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public DigitalVideoDisc(String title, String director, String category, int length, float cost) {
		super(title, director, category, length, cost);
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setLength(int length) {
		this.length = length;
	}	
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		if (this.getLength()<=0) {
			System.out.println("This DVD cannot be played");
		}
		else {
			System.out.println("DVD length: " + this.getLength());
			System.out.println("DVD cost: " + this.getCost());
		}
	}
	
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + 
				((this.getCategory()=="") ? null : this.getCategory()) + " - " + 
				((this.getDirector()=="") ? null : this.getDirector()) + " - " + 
				((this.getLength()==0) ? null : this.getLength()) + ": " + 
				((this.getCost()==0.) ? null : (this.getCost() + "$")); 
	}
}
