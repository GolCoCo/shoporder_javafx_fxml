
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Window;

/*
 * Class for MainForm Dialog
 */
public class SandwichOrderForm extends Dialog<Object> {

    @FXML
    private Button HomeBtn;
    
    @FXML
    private Button SubmitBtn;
    
    @FXML
    private Button CancelBtn;
    
    @FXML
    private TextField CustomerNameTextField;
    @FXML
    private TextField TaxRateTextField;
    @FXML
    private TextField DiscountTextField;
    @FXML
    private TextField QuantityTextField;
    @FXML
    private TextField BreadTypeTextField;
    @FXML
    private TextField BreadTypePricePriceTextField;
    @FXML
    private TextField TypeTextField;
    @FXML
    private TextField TypePriceTextField;
    @FXML
    private TextArea ResultTextArea;
    
    public Window stage;

    private MainForm mform;
    private void initEventHandler() {
    	
	    EventHandler<ActionEvent> eventEventHandler = new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent actionEvent) {
	        	
	            if(actionEvent.getSource() == CancelBtn){           
	            		
	            	System.out.println("CancelBtn Clicked!");
	            	cancelbtn_listener();
	            		
	            }else if(actionEvent.getSource() == SubmitBtn){
	            	
	            	System.out.println("SubmitBtn Clicked!");
	            	try {
	            		submitbtn_listener();
	            	}catch(Exception e) {
	            		ResultTextArea.setText("Please Enter all value correctly.");
	            	}
	            }else {
	            	homebtn_listener();
	            	System.out.println("HomeBtn Clicked!");
	            }
	        }
		    };
		    CancelBtn.setOnAction(eventEventHandler);
		    SubmitBtn.setOnAction(eventEventHandler);
		    HomeBtn.setOnAction(eventEventHandler);
	}
    
    public void cancelbtn_listener() {
    	TypeTextField.setText("");
    	TypePriceTextField.setText("");
    	BreadTypePricePriceTextField.setText("");
    	BreadTypeTextField.setText("");
    	QuantityTextField.setText("");
    	DiscountTextField.setText("");
    	TaxRateTextField.setText("");
    	CustomerNameTextField.setText("");
    	ResultTextArea.setText("");
    }
    
    public void submitbtn_listener() {
        String cusname = this.CustomerNameTextField.getText();
        double typeprice = Double.valueOf(this.TypePriceTextField.getText());
        double breadtypeprice = Double.valueOf(this.BreadTypePricePriceTextField.getText());
        String breadtype = this.BreadTypeTextField.getText();
        int quantity = Integer.valueOf(this.QuantityTextField.getText());
        double discount = Double.valueOf(this.DiscountTextField.getText());
        double taxrate = Double.valueOf(this.TaxRateTextField.getText());
        String type = this.TypeTextField.getText();
        
        String content = String.format("Name: %s Tax Rate: %f Discount: %f Quantity %d \n"
        		+ "Bread Type: %s  Bread Type Price: %f Type: %s Type Price %f\n", cusname, taxrate, discount, quantity, breadtype, breadtypeprice, type, typeprice);
        
        SandwichOrder sandwichOrder = new SandwichOrder(cusname, taxrate, discount, quantity, breadtype, breadtypeprice, type, typeprice);
        System.out.println("Your total for the sandwich cream order is " + sandwichOrder.total());
        content = content + String.format("====================================\n \tTotal:  %f\n"
        		+ "====================================\n", sandwichOrder.total());
        ResultTextArea.setText(content);
        
    }
    
    public void homebtn_listener() {
    	this.hide();
    	mform.showAndWait();
	   	MainForm dialog = new MainForm(stage);
        dialog.getDialogPane().getButtonTypes().addAll(
                ButtonType.CLOSE
        );
        mform.showAndWait();
    }
    
    public SandwichOrderForm(MainForm form, Window owner) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("SanwichOrderForm.fxml"));
            loader.setController(this);
            
            DialogPane dialogPane = loader.load();

            initOwner(owner);
            
            initModality(Modality.APPLICATION_MODAL);
            stage  = owner;
            setResizable(true);
            setTitle("Sandwich Order Screen:");
            setDialogPane(dialogPane);
            initEventHandler();
            mform = form;
            setOnShowing(dialogEvent -> Platform.runLater(() -> SubmitBtn.requestFocus()));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}