package hust.soict.dsai.test.screen.customer.cart;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.customer.controller.CartController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewCartScreen extends Application {
	private static Cart cart = new Cart();
	private static Store store = new Store();
	
	public void start(Stage primaryStage) throws Exception {
		final String cart_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Cart.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(cart_FXML_FILE_PATH));
		CartController cartController = new CartController(store, cart);
		fxmlLoader.setController(cartController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Cart");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		cart = new Cart();
		
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Harry Potter and the Philosopher's stone (2001)",
				"J.K Rollin",
				"Animation",
				0,
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
		cd6.addTrack(new Track("Cool", 0));
		cd6.addTrack(new Track("Levitating", 3));
		cd6.addTrack(new Track("Hallucinate", -1));
		cd6.addTrack(new Track("Break my hear", 4));
		cd6.addTrack(new Track("New rule", 4));
		
		Book book7 = new Book("The Hunger Games", 
		5.5f);
		
		Book book8 = new Book("Catching Fire", 
		4.9f);
		
		Book book9 = new Book("Mockingjay", 
		5.1f);
		
		//test adding multiple Digital video discs method
		
		try {
			cart.addMedia(dvd1);
			cart.addMedia(dvd2);
			cart.addMedia(dvd3);
			cart.addMedia(dvd4);
			cart.addMedia(dvd5);
			cart.addMedia(cd6);
			cart.addMedia(book7);
			cart.addMedia(book8);
			cart.addMedia(book9);

		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		launch(args);
	}
}
