package hust.soict.dsai.aims.media;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.exception.PlayerException;
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
	
	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
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
	
	public JPanel play() throws PlayerException {
		JPanel play = new JPanel();
		play.setLayout(new BoxLayout(play, BoxLayout.Y_AXIS));
		
		JLabel titleLabel = new JLabel("Playing CD: " + this.getTitle());
		titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		play.add(titleLabel);
		
		JLabel lengthLabel;
		
		if (this.getArtist()!=null) {
			JLabel artistLabel = new JLabel("CD artist: " + this.getArtist());
			artistLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			play.add(artistLabel);
		}
		
		if (this.getLength()<=0) {
			lengthLabel = new JLabel("This CD cannot be played");
			
			JOptionPane.showMessageDialog(play, "Error: CD length is non-positive!",
                    "Illegal DVD length", JOptionPane.ERROR_MESSAGE);
			throw new PlayerException("Error: CD length is non-negative!");
		}
		else {
			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while (iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					play.add(nextTrack.play());
				} catch (PlayerException e) {
					throw e;
				}
			}
			lengthLabel = new JLabel("CD length: " + this.getLength());
		}
		
		lengthLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		play.add(lengthLabel);

		play.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		return play;

		
	}
	
	public String toString() {
		System.out.println("Compact disc: " + this.getTitle());
		System.out.println("Category: " + this.getCategory()); 
		System.out.println("Artist: " + this.getArtist());
		System.out.println("Director: " + this.getDirector()); 
		System.out.println("Length: " + this.getLength());
		System.out.println("Cost: " + this.getCost());
		
		for (Track  track: tracks) {
			System.out.println(track.toString());
		}
		
		return null;
		
	}
	
}
