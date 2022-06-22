package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField titleField;
	private JTextField costField;
	private JTextField categoryField;
	private JTextField artistField;
	private JTextField trackField; 
	
	public AddCompactDiscToStoreScreen(Store store) {
		super(store);
		
		JPanel input = new JPanel();
		input.setLayout(new GridLayout(5,2,10,10));
		
		JLabel title = new JLabel("Title: ");
		this.titleField = new JTextField();
		input.add(title);
		input.add(titleField);
		
		JLabel cost = new JLabel("Cost: ");
		this.costField = new JTextField();
		input.add(cost);
		input.add(costField);
		
		JLabel category = new JLabel("Category: ");
		this.categoryField = new JTextField();
		input.add(category);
		input.add(categoryField);
		
		JLabel artist = new JLabel("Artist: ");
		this.artistField = new JTextField();
		input.add(artist);
		input.add(artistField);
		
		JLabel tracks = new JLabel("Track (Seperate by space, (title and length) respectively):");
		this.trackField = new JTextField();
		input.add(tracks);
		input.add(trackField);
		
		this.add(input, BorderLayout.CENTER);
		
		JPanel submitPanel = new JPanel();
		submitPanel.setLayout(new BoxLayout(submitPanel, BoxLayout.Y_AXIS));
		submitPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JButton submit = new JButton("Submit");
		submit.setAlignmentX(CENTER_ALIGNMENT);
		submit.addActionListener(new btnListener());
		submitPanel.add(submit, BorderLayout.CENTER);
		submitPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		
		this.add(submitPanel, BorderLayout.SOUTH);
		this.setSize(600,400);
	}
	
	
	private class btnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String[] trackList = trackField.getText().split("\\s+");
			
			if (titleField.getText().equals("") ||
					artistField.getText().equals("") ||
					categoryField.getText().equals("") ||
					costField.getText().equals("") ) {
				JDialog d = warningPanel();
			}
			else {
				CompactDisc cd = new CompactDisc(titleField.getText(), 
													categoryField.getText(), 
													artistField.getText(), 
													Float.parseFloat(costField.getText()));
				if (trackList.length > 0) {
					if (trackList.length % 2 == 0) {
						for (int i=0; i<trackList.length; i+=2) {
							Track item = new Track(trackList[i], Integer.parseInt(trackList[i+1]));
							cd.addTrack(item);
						}
					}							
				}
				store.addMedia(cd);
				titleField.setText("");
				categoryField.setText("");
				costField.setText("");
				artistField.setText("");
				trackField.setText("");
			}	
		}
	}
}
