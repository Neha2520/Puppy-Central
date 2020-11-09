package puppycentral;

import java.net.URL;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController implements Initializable{
	 @FXML
	    private Button login;

	    @FXML
	    private Button tnc;

	    @FXML
	    private TextField tname;

	    @FXML
	    private TextField temail;

	    @FXML
	    private TextField tcont;

	    @FXML
	    private TextField tpass;

	    @FXML
	    private CheckBox catnc;

	    @FXML
	    private Button signup;

	    @FXML
	    private ComboBox<String> ccode;
	    
	    @FXML
	    private Label lcaptcha;

	    @FXML
	    private TextField tcaptcha;
	

	   
	    public void cap()
		{
	    	char data[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
	        char index[]=new char[7];

	        Random r=new Random();
	        int i =0;

	        for( i=0;i<(index.length);i++)
	        {
	            int ran=r.nextInt(data.length);
	            index[i]=data[ran];
	            String captcha=String.valueOf(index);
	            lcaptcha.setText(captcha);
	           
	        }
		}
		
	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ccode.getItems().addAll("+91","+93","+54","+1");
		
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
	 public void tncAction(ActionEvent e)throws Exception
		{
		  JOptionPane.showMessageDialog(null, "no cash no credit just pick up and relax ;)");
		}
	 
	 public void SignUpAction(ActionEvent e)throws Exception
		{
		 
		 Connection con = null;
			PreparedStatement ps = null;
			String nm = tname.getText();
			 String em = temail.getText();
			 String cc = (String) ccode.getValue();
			 String ph = tcont.getText();
			 String pss = tpass.getText();
			 
			 if(nm.isEmpty()||em.isEmpty()||cc.isEmpty()||ph.isEmpty()||pss.isEmpty())
			 {
				 JOptionPane.showMessageDialog(null, "ALL FIELS ARE MANDATORY");
			 }
			 
			
			 else if(catnc.isSelected() && lcaptcha.getText().equals(tcaptcha.getText()))
			 {
			try {
				 String url = "jdbc:mysql://localhost:3306/puppycentral";
				 String user = "root";
				 String pass ="nehas";
				 String query = "insert into users values(?,?,?,?,?,?,?,?)";
				con = DriverManager.getConnection(url,user,pass);
				ps= con.prepareStatement(query);
				ps.setString(1, nm);
				ps.setString(2, em);
				ps.setString(3, cc);
				ps.setString(4, ph);
				ps.setString(5, pss);
                                ps.setString(6,null);
                                ps.setString(7,null);
                                ps.setString(8,null);
				ps.execute();
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("welcome.fxml"));
				Parent root = (Parent) loader.load();
				WelcomeController obj = loader.getController();
				obj.ForUser("Welcome "+tname.getText());
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();	
				
				
			}catch(Exception ex)
			{
				System.out.print(ex);
			}
			 }
			 
			 else if(lcaptcha.getText().equals(tcaptcha.getText()))
			 {
				 JOptionPane.showMessageDialog(null, "PLEASE SELECT OUR TERMS AND CONDITION TO CONTINUE");
			 }
			 
			 else
			 {
				 cap();
				 JOptionPane.showMessageDialog(null, "ENTER THE CORRECT CAPTCHA");
			 }
		}

}
