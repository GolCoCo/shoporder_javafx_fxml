import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LoginFormController implements Initializable {
	
	private Stage stage;
	private String username = "user";
	private String password = "pass";
	private String msgdlgcontent = "Username and Password incorrect!";
	
    @FXML
    private Button SingInBtn;
    
    @FXML
    private TextField UserNameTextField;
    
    @FXML
    private TextField PasswordTextField;
    
    private void showIncorrectDialog() {
    	Alert alert = new Alert(AlertType.WARNING);
    	alert.setTitle("Alert");
    	alert.setContentText(msgdlgcontent);
    	alert.show();
    	UserNameTextField.setText("");
    	PasswordTextField.setText("");
    }
    
   private void ShowMainFormDialog() {
   		stage.hide();
	   	MainForm dialog = new MainForm(stage);
        dialog.getDialogPane().getButtonTypes().addAll(
                ButtonType.CLOSE
        );
	   	dialog.showAndWait();
   }
    
    // function that initialize event handler
    private void initEventHandler() {
    	
        EventHandler<ActionEvent> eventEventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	
                if(actionEvent.getSource() == SingInBtn){
                	
                	String tname = UserNameTextField.getText();
                	String tpass = PasswordTextField.getText();
                	System.out.println(tname);
                	System.out.println(tpass);
                	
                	if((tname.equals(username)  ) && (tpass.equals(password))) {
                		
                		ShowMainFormDialog();
                		System.out.println("Success Login!");
                		
                	}else {
                		
                		showIncorrectDialog();
                	}
                }
            }
        };

        SingInBtn.setOnAction(eventEventHandler);
    }
    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        stage = LoginForm.getPrimaryStage();
        stage.addEventHandler(WindowEvent.WINDOW_SHOWING, (WindowEvent window) -> {
        	initEventHandler();
        });
    } 
}
