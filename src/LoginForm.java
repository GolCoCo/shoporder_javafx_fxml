
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Main application class for the login application */
public class LoginForm extends Application {
	
	  private static Stage primaryStage;
	  
	  public static void main(String[] args) {
		  System.out.print("javafx project start.");
		  launch(args);
	  }
	  
	  @Override 
	  public void start(Stage stage) throws IOException {
		  
	    primaryStage = stage;
	    Parent root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
	    Scene scene = new Scene(root);  
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("JavaFX Shop Welcome");
	    primaryStage.show();
	    
	  }
	  
	  public static Stage getPrimaryStage() {
	      return primaryStage;
	  }
}