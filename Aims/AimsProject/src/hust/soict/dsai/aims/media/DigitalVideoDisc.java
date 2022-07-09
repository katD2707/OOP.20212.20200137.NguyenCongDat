package hust.soict.dsai.aims.media;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.exception.PlayerException;
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
	
	public JPanel play() throws PlayerException {
		JPanel play = new JPanel();
		play.setLayout(new BoxLayout(play, BoxLayout.Y_AXIS));
		
		JLabel titleLabel = new JLabel("Playing DVD: " + this.getTitle());
		titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		JLabel lengthLabel;
		
		if (this.getLength()<=0) {
			lengthLabel = new JLabel("This DVD cannot be played");
			JOptionPane.showMessageDialog(play, "Error: DVD length is non-positive!",
                    "Illegal DVD length", JOptionPane.ERROR_MESSAGE);
			throw new PlayerException("Error: DVD length is non-positive!");
			
		}
		else {
			lengthLabel = new JLabel("DVD length: " + this.getLength());
		}
		lengthLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		play.add(titleLabel);
		play.add(lengthLabel);
		play.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		return play;
	}
	
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + 
				this.getCategory() + " - " + 
				this.getDirector() + " - " + 
				this.getLength() + ": " + 
				this.getCost() + "$"; 
	}
}
