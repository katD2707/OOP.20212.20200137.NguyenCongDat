package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.store.Store;

public class AddItemToStoreScreen extends JFrame{
	protected Store store;
	private JDialog d;
	
	public AddItemToStoreScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);

		
		setTitle("Item");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);

	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		
		JMenuItem view = new JMenuItem("View store");
		view.addActionListener(new btnListener());
		
		JMenu smUpdateStore = new JMenu("Update Store");

		JMenuItem book = new JMenuItem("Add book");
		JMenuItem cd = new JMenuItem("Add CD");
		JMenuItem dvd = new JMenuItem("Add DVD");
		
		menu.add(view);
		
		book.addActionListener(new OptionListener());
		cd.addActionListener(new OptionListener());
		dvd.addActionListener(new OptionListener());
		
		smUpdateStore.add(book);
		smUpdateStore.add(cd);
		smUpdateStore.add(dvd);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JDialog warningPanel() {
		d = new JDialog();
        d.setTitle("Warning");
        // create a label
        
        JPanel messagePanel = new JPanel();
        
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        messagePanel.add(Box.createRigidArea(new Dimension(20, 20)));
        JLabel message = new JLabel("Please fill all fields");
        message.setAlignmentX(CENTER_ALIGNMENT);
        
        messagePanel.add(message);
        
        messagePanel.add(Box.createRigidArea(new Dimension(20, 20)));
        
        JButton confirm = new JButton("Confirmed");
        confirm.setAlignmentX(CENTER_ALIGNMENT);
        confirm.addActionListener(new ConfirmListener());

        messagePanel.add(confirm);
        messagePanel.add(Box.createRigidArea(new Dimension(20, 20)));
        d.add(messagePanel);
        
        d.setSize(200,150);
        d.setLocationRelativeTo(null);
        // set visibility of dialog
        d.setVisible(true);
        d.toFront();
        
        return d;
	}
	
	private class OptionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command = e.getActionCommand();
			if (command.equals("Add book")) {
				new AddBookToStoreScreen(store);
			} 
			else if (command.equals("Add CD")) {
				new AddCompactDiscToStoreScreen(store);	
			}
			else {
				new AddDigitalVideoDiscToStoreScreen(store);
			}
			dispose();
		}
	}
	
	private class ConfirmListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			d.dispose();
		}
		
	}
	
	private class btnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new StoreManagerScreen(store);
			dispose();
		}
		
	}
}
