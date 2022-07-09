package hust.soict.dsai.aims.screen.customer.controller;

import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.playable.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class CartController {
	
	private Cart cart;
	private Store store;
	
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;
    
    @FXML
    private TextField tfFilter;
    

    @FXML
    private RadioButton radioBtnFilterID;

    @FXML
    private RadioButton radioBtnFilterTitle;
    
    public CartController(Store store, Cart cart) {
    	this.cart = cart;
    	this.store = store;
    }
    
    @FXML
    public void initialize() {
    	colMediaId.setCellValueFactory(
    			new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(
    			new PropertyValueFactory<Media, Float>("cost"));

    	if (cart.getItemsOrdered()!=null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    	}
    
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);

    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
    		@Override
    		public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    			updateButtonBar(newValue);
    		}
    	});

    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> observable, 
    										String oldValue, String newValue) {
    			showFilteredMedia(newValue);
    		}
    	});

    	costLabel.textProperty().bind(new SimpleStringProperty(String.valueOf(cart.totalCost())));
  
    }
    
    void showFilteredMedia(String newValue) {
    	FilteredList<Media> filteredMedia = new FilteredList<>(cart.getItemsOrdered(), p -> true);
    	if (newValue==null || newValue.isEmpty() || newValue.equals("")) {
    		filteredMedia.setPredicate(p -> true);
    	}
    	else {
	    	if (radioBtnFilterID.isSelected()) {
	    		filteredMedia.setPredicate(p -> p.getId()==Integer.parseInt(newValue));
	    	} else if (radioBtnFilterTitle.isSelected()) {
	    		filteredMedia.setPredicate(p -> p.isMatch(newValue.toLowerCase()));
	    	} 
    	}
    	tblMedia.setItems(filteredMedia);
    }
    
    void updateButtonBar(Media media) {
    	if (media==null) {
    		btnPlay.setVisible(false);
    		btnRemove.setVisible(false);
    	}
    	else {
    		btnRemove.setVisible(true);
    		if (media instanceof Playable) {
    			btnPlay.setVisible(true);
    		}
    		else {
    			btnPlay.setVisible(false);
    		}
    	}
    }
    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
    	JDialog d = new JDialog();
        d.setTitle("Play media");
        // create a label
        
        JPanel message = new JPanel();
        Media mediaSelected = tblMedia.getSelectionModel().getSelectedItem();
        if (mediaSelected instanceof DigitalVideoDisc) {
        	message = ((DigitalVideoDisc)mediaSelected).play();
        }
        else if (mediaSelected instanceof CompactDisc) {
        	message = ((CompactDisc)mediaSelected).play();
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

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	tblMedia.setItems(cart.getItemsOrdered());
    	costLabel.textProperty().bind(new SimpleStringProperty(String.valueOf(cart.totalCost())));
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
    		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
    		fxmlLoader.setController(new ViewStoreController(store, cart));
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Store");
    		stage.show();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    }

}
