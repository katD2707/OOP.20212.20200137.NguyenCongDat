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

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
	private JTextField titleField;
	private JTextField costField;
	private JTextField categoryField; 
	private JTextField directorField;  
	private JTextField lengthField;  
	
	public AddDigitalVideoDiscToStoreScreen(Store store) {
		super(store);
		
		JPanel input = new JPanel();
		input.setLayout(new GridLayout(5, 2, 10, 10));
		
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
		
		JLabel director = new JLabel("Director: ");
		this.directorField = new JTextField();
		input.add(director);
		input.add(directorField);
		
		JLabel length = new JLabel("Length: ");
		this.lengthField = new JTextField();
		input.add(length);
		input.add(lengthField);
		
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
			if (titleField.getText().equals("") ||
					directorField.getText().equals("") ||
					categoryField.getText().equals("") ||
					lengthField.getText().equals("") ||
					costField.getText().equals("") ) {
				JDialog d = warningPanel();
			}
			else {
				store.addMedia(new DigitalVideoDisc(titleField.getText(), 
													directorField.getText(), 
													categoryField.getText(), 
													Integer.parseInt(lengthField.getText()), 
													Float.parseFloat(costField.getText())));
				titleField.setText("");
				directorField.setText("");
				costField.setText("");
				lengthField.setText("");
				categoryField.setText("");

			}
		}
		
		
	}
	
}
