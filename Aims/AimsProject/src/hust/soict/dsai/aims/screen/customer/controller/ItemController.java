package hust.soict.dsai.aims.screen.customer.controller;
import java.awt.Dialog.ModalityType;

import javax.naming.LimitExceededException;
import javax.swing.JDialog;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.playable.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ItemController {
    
    private Media media;
    private Cart cart;
    private Store store;
    
    public ItemController(Store store, Cart cart) {
    	this.cart = cart;
    	this.store = store;
    }
    
	@FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;
    
	public void setData(Media media) {
		this.media = media;
		lblTitle.setText(media.getTitle());
		lblCost.setText(media.getCost()+" $");
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
		}
	}
	
    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceededException {
    	this.cart.addMedia(media);
    	try {
    		final String CART_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Cart.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
    		fxmlLoader.setController(new CartController(store, cart));
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Cart");
    		stage.show();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
//    	Alert alert = new Alert(AlertType.INFORMATION);
//		alert.setTitle("Add item to cart");
//		alert.setHeaderText("Results:");
//		alert.setContentText('"' + this.media.getTitle() + '"' + " is added successfully!");
//
//		alert.showAndWait();
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
    	// create a dialog Box
        JDialog d = new JDialog();
        d.setTitle("Play media");
        // create a label
        
        JPanel message = new JPanel();
        if (this.media instanceof DigitalVideoDisc) {
        	message = ((DigitalVideoDisc)this.media).play();
        }
        else if (this.media instanceof CompactDisc) {
        	message = ((CompactDisc)this.media).play();
        }

        d.add(message);

        
        // setsize of dialog
        d.setSize(500,500);
        d.setLocationRelativeTo(null);
        // set visibility of dialog
        d.setVisible(true);
        d.setModalityType(ModalityType.TOOLKIT_MODAL);
        d.toFront();
    }
    
    
}
