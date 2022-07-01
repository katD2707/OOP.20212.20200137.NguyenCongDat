package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton drawingEraser;

    @FXML
    private RadioButton drawingPen;
    
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
	    if (drawingPen.isSelected()) {
	    	Circle newCircle = new Circle(event.getX(), event.getY(),
	    								4, Color.BLACK);
	    	drawingAreaPane.getChildren().add(newCircle);
	    }
	    else if (drawingEraser.isSelected()) {
	    	Circle newCircle = new Circle(event.getX(), event.getY(),
					4, Color.WHITE);
	    	drawingAreaPane.getChildren().add(newCircle);
	    }
    }

   
}
