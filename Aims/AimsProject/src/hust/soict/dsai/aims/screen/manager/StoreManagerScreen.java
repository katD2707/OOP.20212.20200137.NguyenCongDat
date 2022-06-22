package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class StoreManagerScreen extends JFrame {
	private Store store;
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
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
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		
		menu.add(new JMenuItem("View store"));
		
		JMenu smUpdateStore = new JMenu("Update Store");

		JMenuItem book = new JMenuItem("Add book");
		JMenuItem cd = new JMenuItem("Add CD");
		JMenuItem dvd = new JMenuItem("Add DVD");
	
		book.addActionListener(new OptionListener());
		cd.addActionListener(new OptionListener());
		dvd.addActionListener(new OptionListener());
		
		smUpdateStore.add(book);
		smUpdateStore.add(cd);
		smUpdateStore.add(dvd);
		

		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
		
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
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(5,5,2,2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i=0;i<mediaInStore.size();i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
			
		}
		
		return center;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Store store = new Store();
				
				DigitalVideoDisc dvd1 = new DigitalVideoDisc("Harry Potter and the Philosopher's stone (2001)",
															"J.K Rollin",
															"Animation",
															120,
															3.0f);
				
				DigitalVideoDisc dvd2 = new DigitalVideoDisc("Harry Potter and the Chamber of Secrets (2002)", 
								"J.K Rollin",
								"Animation",
								119,
								3.5f); 
				
				DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban (2004)",  
								"J.K Rollin",
								"Animation",
								118,
								4.5f);
				
				DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter and the Goblet of Fire (2005)", 
								"J.K Rollin",
								"Animation",
								120, 
								4.5f);
				
				DigitalVideoDisc dvd5 = new DigitalVideoDisc("Fetch the Bolt Cutters", 
								"Unknown",
								"Animation",
								115, 
								10.39f);
				
				CompactDisc cd6 = new CompactDisc("Future Nostalgia", "Pop", "Dua Lipa", 9.6f);
				cd6.addTrack(new Track("Physical", 3));
				cd6.addTrack(new Track("Cool", 4));
				cd6.addTrack(new Track("Levitating", 3));
				cd6.addTrack(new Track("Hallucinate", 3));
				cd6.addTrack(new Track("Break my hear", 4));
				cd6.addTrack(new Track("New rule", 4));
				
				Book book7 = new Book("The Hunger Games", 
								5.5f);
				
				Book book8 = new Book("Catching Fire", 
								4.9f);
				
				Book book9 = new Book("Mockingjay", 
						5.1f);
		
				//test adding multiple Digital video discs method
				store.addMedia(dvd1);
				store.addMedia(dvd2);
				store.addMedia(dvd3);
				store.addMedia(dvd4);
				store.addMedia(dvd5);
				store.addMedia(cd6);
				store.addMedia(book7);
				store.addMedia(book8);
				store.addMedia(book9);
						
		
		
		new StoreManagerScreen(store);
	}
}
