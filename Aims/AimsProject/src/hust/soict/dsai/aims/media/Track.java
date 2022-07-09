package hust.soict.dsai.aims.media;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.exception.PlayerException;
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
	
	public JPanel play() throws PlayerException{
		JPanel play = new JPanel();
		play.setLayout(new BoxLayout(play, BoxLayout.Y_AXIS)); 
		JLabel titleLabel;
		titleLabel = new JLabel("Playing track: " + this.getTitle());
		titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		if (this.getLength()<=0) {
			JOptionPane.showMessageDialog(play, "Error: Track " + this.getTitle() + " is non-positive!",
                    "Illegal Track length", JOptionPane.ERROR_MESSAGE);
			throw new PlayerException("Error: Track " + this.getTitle() + " is non-positive!");
		}
		else {
			JLabel lengthLabel = new JLabel("Track length: " + this.getLength());
			lengthLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			play.add(lengthLabel);
		}
		
		play.add(titleLabel);
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
