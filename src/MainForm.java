
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
import javafx.stage.Window;

/*
 * Class for MainForm Dialog
 */
public class MainForm extends Dialog<Object> {

    @FXML
    private Button SandwichOrderBtn1;
    @FXML
    private Button IceCreamOrderBtn1;
    
    public Window stage;

    private void ShowSandwichForm() {
   		stage.hide();
   		
	   	SandwichOrderForm dialog = new SandwichOrderForm(this, stage);
        dialog.getDialogPane().getButtonTypes().addAll(
                ButtonType.CLOSE
        );
	   	dialog.showAndWait();
   }
    
    private void ShowIceCreamOrderForm() {
   		stage.hide();
   		
	   	IceCreamOrderForm dialog = new IceCreamOrderForm(this,stage);
        dialog.getDialogPane().getButtonTypes().addAll(
                ButtonType.CLOSE
        );
	   	dialog.showAndWait();
   }
    private void initEventHandler() {
    	
	    EventHandler<ActionEvent> eventEventHandler = new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent actionEvent) {
	        	
	            if(actionEvent.getSource() == IceCreamOrderBtn1){           
	            	
	            	System.out.println("IceCreamOrder Form!");
	            	ShowIceCreamOrderForm();	
	            		
	            }else {
	            	
	            	System.out.println("Sandwich Form!");
	            	ShowSandwichForm();
	            }
	        }
		    };
	    SandwichOrderBtn1.setOnAction(eventEventHandler);
	    IceCreamOrderBtn1.setOnAction(eventEventHandler);
	}
    
    
    public MainForm(Window owner) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("MainForm.fxml"));
            loader.setController(this);
            
            DialogPane dialogPane = loader.load();

            initOwner(owner);
            
            initModality(Modality.APPLICATION_MODAL);
            stage  = owner;
            setResizable(true);
            setTitle("Morrisville Shop Main screen");
            setDialogPane(dialogPane);
            initEventHandler();
            setOnShowing(dialogEvent -> Platform.runLater(() -> SandwichOrderBtn1.requestFocus()));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    @FXML
    private void initialize(URL url, ResourceBundle rb) {

    }
}