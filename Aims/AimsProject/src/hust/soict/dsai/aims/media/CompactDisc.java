package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	
	public CompactDisc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getArtist() {
		return artist;
	}
	
	public int getLength() {
		//Because each track in the CD has a length, the length of the CD should be the sum of
		//the lengths of all its tracks. 
		
	}
	
	public void addTrack() {
		//The addTrack () method should check if the input track is already in the list of tracks 
		//and inform users
		
	}
	
	public void removeTrack() {
		//The removeTrack () method should check if the input track existed in the list of tracks 
		//and inform users
		
	}
	
}
