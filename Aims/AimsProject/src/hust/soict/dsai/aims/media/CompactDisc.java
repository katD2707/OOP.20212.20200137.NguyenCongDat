package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.playable.Playable;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	
	public CompactDisc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title) {
		super(title);
	}
	
	public CompactDisc(String title, float cost) {
		super(title, cost);
	}
	
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public CompactDisc(String title, String category, float cost, String artist, ArrayList<Track> tracks) {
		this(title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int getLength() {
		int totalLength = 0;
		for (Track  track: tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	
	public void addTrack(Track track_pending) {
		for (Track track: tracks) {
			if (track.equals(track_pending)) {
				System.out.println("The track is already in the list of tracks");
				return ;
			}
		}
		tracks.add(track_pending);
		System.out.println("Track has been added successfully");
	}
	
	public void removeTrack(Track track_pending) {
		ArrayList<Track> newTrack = new ArrayList<Track>();
		int before = tracks.size();
		
		for (Track track: tracks) {
			if (track.getTitle().equals(track_pending.getTitle())) {
				newTrack.add(track);
			}
		}
		this.tracks = newTrack;
		int after = tracks.size();
		
		if (before==after) {
			System.out.println("The input track is not in the list of tracks");
		}
		else {
			System.out.println("The track has been removed");
		}
	}
	
	public void play() {
		System.out.println("Playing CD " + this.getTitle());
		System.out.println("CD length: " + ((this.getLength()==0)?null:this.getLength()));
		System.out.println("CD artist: " + ((this.getArtist()=="")?null:this.getArtist()));
		System.out.println("CD category: " + ((this.getCategory()=="")?null:this.getCategory()));
		System.out.println("CD director: " + ((this.getDirector()=="")?null:this.getDirector()));
		System.out.println("CD cost: " + ((this.getCategory()=="")?null:this.getCost()));
		System.out.println("-------------------------------------------------------------------------");
		for (Track  track: tracks) {
			track.play();
		}
	}
	
}
