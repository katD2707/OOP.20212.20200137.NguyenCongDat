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

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	private JTextField titleField;
	private JTextField costField;
	private JTextField categoryField;
	
	public AddBookToStoreScreen(Store store) {
		super(store);
		
		JPanel input = new JPanel();
		input.setLayout(new GridLayout(3,2,10,10));
		
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
		this.setSize(400,300);
	}
	
	
	private class btnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (titleField.getText().equals("") || 
					categoryField.getText().equals("") ||
						costField.getText().equals("") ) {
				JDialog d = warningPanel();
			}
			else {
				Book book = new Book(titleField.getText(), categoryField.getText(), Float.parseFloat(costField.getText()));
				titleField.setText("");
				categoryField.setText("");
				costField.setText("");
				store.addMedia(book);
			}
			
		}
		
		
	}
}
