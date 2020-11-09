package puppycentral;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class WelcomeController implements Initializable {
	
	 @FXML
	 
	    private Button adopt;

	    @FXML
	    private Button foster;

	    @FXML
	    private Button babysit;

	    @FXML
	    private Button visit;

	    @FXML
	    private Button rec;

	    @FXML
	    private Button donate;

	    @FXML
	    private Button contact;

	    @FXML
	    private Button policy;

	    @FXML
	    private Button faq;

	    @FXML
	    public  Button signup;

	    @FXML
	    public  Button login ;
	    @FXML
	    public Label lname;
             @FXML
    private MediaView mv;
    private MediaPlayer mp;
    private Media me;
	    

	    public  void ForUser(String text)
		{   
			lname.setText(text);
			login.setVisible(false);
			signup.setVisible(false);
		} 

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
             String path = new File("E:\\Netbeans Project\\puppycentral\\src\\images\\puppycentralvideo.mp4").getAbsolutePath();
        me = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(me);
        mv.setMediaPlayer(mp);
        mp.setAutoPlay(true);
		
		
	}
	
	
	 @FXML
	public void loginAction(ActionEvent e)throws Exception
	{
		
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene sc = new Scene(root); 
		Stage primaryStage = new Stage();
		primaryStage.setScene(sc);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	 @FXML
	public void SignUpAction(ActionEvent e)throws Exception
	{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
			Parent root = (Parent) loader.load();
			SignUpController obj = loader.getController();
			
			obj.cap();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();	
	}
	 
	 public void adoptAction(ActionEvent e)throws Exception
		{
			
			Parent root = FXMLLoader.load(getClass().getResource("Adopt.fxml"));
			Scene sc = new Scene(root); 
			Stage primaryStage = new Stage();
			primaryStage.setScene(sc);
			primaryStage.show();
			primaryStage.setResizable(false);
		}
         
         @FXML
    void fosteract(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("Foster.fxml"));
			Scene sc = new Scene(root); 
			Stage primaryStage = new Stage();
			primaryStage.setScene(sc);
			primaryStage.show();
			primaryStage.setResizable(false);

    }
    @FXML
    void babysitact(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("babysit.fxml"));
			Scene sc = new Scene(root); 
			Stage primaryStage = new Stage();
			primaryStage.setScene(sc);
			primaryStage.show();
			primaryStage.setResizable(false);

    }
     @FXML
    void contactact(ActionEvent event) {
        JOptionPane.showMessageDialog(null,"Address : 500 Terry Francois Street\n" +"San Francisco, CA 94158\n" + "Contact no.: 123-456-7890 \n"+"Email : puppycentra2025@gmail.com \n"+"Follow us on Instagram : @puppy_central_offecial \n");

    }

    @FXML
    void donateact(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Donate.fxml"));
			Scene sc = new Scene(root); 
			Stage primaryStage = new Stage();
			primaryStage.setScene(sc);
			primaryStage.show();
			primaryStage.setResizable(false);

    }

    @FXML
    void faqact(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Faq.fxml"));
			Parent root = (Parent) loader.load();
			FaqController obj = loader.getController();
			
			obj.faqs();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();


    }
      @FXML
    void polictact(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StorePolicy.fxml"));
			Scene sc = new Scene(root); 
			Stage primaryStage = new Stage();
			primaryStage.setScene(sc);
			primaryStage.show();
			primaryStage.setResizable(false);


    }

    @FXML
    void recomendact(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("Recommend.fxml"));
			Scene sc = new Scene(root); 
			Stage primaryStage = new Stage();
			primaryStage.setScene(sc);
			primaryStage.show();
			primaryStage.setResizable(false);

    }

	
}
