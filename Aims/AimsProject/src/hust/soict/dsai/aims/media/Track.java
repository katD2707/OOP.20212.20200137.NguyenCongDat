package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.playable.Playable;

public class Track implements Playable {
	private String title;
	private int length;
	
	public Track(String title) {
		this.title = title;
	}
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public void play() {
		if (this.getLength()<=0) {
			System.out.println("Track " + this.getTitle() + " can not be played");
		}
		else {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
	}
	
	@Override
	public String toString() {
		return "Track: " + this.getTitle() + "\n" + "Length: " + this.getLength();
	}
	
	@Override
	public boolean equals(Object track) {
		if ((this.getLength()==((Track)track).getLength()) && 
				(this.getTitle().toLowerCase().contains(((Track)track).getTitle().toLowerCase()))) {
			return true;
		}
		return false;
	}
}
