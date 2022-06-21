package hust.soict.dsai.aims.media;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
	public JPanel play() {
		JPanel play = new JPanel();
		play.setLayout(new BoxLayout(play, BoxLayout.Y_AXIS)); 
		JLabel titleLabel;
		
		if (this.getLength()<=0) {
			titleLabel = new JLabel("Track " + this.getTitle() + " can not be played");
			play.add(titleLabel);
		}
		else {
			titleLabel = new JLabel("Playing track: " + this.getTitle());
			titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			play.add(titleLabel);
			
			JLabel lengthLabel = new JLabel("Track length: " + this.getLength());
			lengthLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			play.add(lengthLabel);
		}
		return play;
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
