package puppycentral;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;


import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController implements Initializable{
	@FXML
    private TextField tuser;

    @FXML
    private PasswordField tpassword;

    @FXML
    private Button forgotpass;

    @FXML
    private Button login;

    @FXML
    private Button back;

    @FXML
    private Button signup;
    
    
    public String usernamereturn()
    {
        return tuser.getText();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	 @FXML
		public void forgotAction(ActionEvent e)throws Exception
		{
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("ForgotPassword.fxml"));
			Scene sc = new Scene(root); 
			primaryStage.setScene(sc);
			primaryStage.show();
			primaryStage.setResizable(false);
		}
	 
	 @FXML
		public void backAction(ActionEvent e)throws Exception
		{
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
			Scene sc = new Scene(root); 
			primaryStage.setScene(sc);
			primaryStage.show();
			primaryStage.setResizable(false);
		}
	 @FXML
		public void signUpAction(ActionEvent e)throws Exception
		{
		 Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
			Scene sc = new Scene(root); 
			primaryStage.setScene(sc);
			primaryStage.show();
			primaryStage.setResizable(false);
		}
	 @FXML
		public void loginAction(ActionEvent e)throws Exception
		{
		 Connection con = null;
			PreparedStatement ps = null;
			
			ResultSet rs = null;
		
			try {
			 String url = "jdbc:mysql://localhost:3306/puppycentral";
			 String user = "root";
			 String pass ="nehas";
			 String query = "SELECT name,password FROM users WHERE name = ? AND password = ?";
			con = DriverManager.getConnection(url,user,pass);
			ps= con.prepareStatement(query);
			ps.setString(1, tuser.getText());
			ps.setString(2, tpassword.getText());
			rs = ps.executeQuery();
			
			
			
			if(rs.next())
	        {
				
			FXMLLoader loader = new FXMLLoader(getClass().getResource("welcome.fxml"));
			Parent root = (Parent) loader.load();
			WelcomeController obj = loader.getController();
			obj.ForUser("Welcome "+tuser.getText());
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();		
		    }
			else
			{
				JOptionPane.showMessageDialog(null, "INCORRECT ID OR PASSWORD");
			}
			
			}catch(Exception ex)
			{
				System.out.print(ex);
			}
		}

}
