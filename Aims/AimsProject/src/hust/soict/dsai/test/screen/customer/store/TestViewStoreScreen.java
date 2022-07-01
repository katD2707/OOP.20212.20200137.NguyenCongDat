package hust.soict.dsai.test.screen.customer.store;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
	private static Store store;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		store = new Store();
		
		
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

		launch(args);
	}
}
