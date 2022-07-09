package hust.soict.dsai.aims.playable;

import javax.swing.JPanel;

import hust.soict.dsai.aims.exception.PlayerException;

public interface Playable {
	public JPanel play() throws PlayerException;
}
