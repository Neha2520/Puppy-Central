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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ForgotPasswordController implements Initializable{
	
	
	
	 @FXML
	    private ComboBox<String> ccode;

	    @FXML
	    private TextField tphn;

	    @FXML
	    private Button confirm;

	    @FXML
	    private Label lnpas;

	    @FXML
	    private PasswordField tnpas;

	    @FXML
	    private Label lcpas;

	    @FXML
	    private PasswordField tcpas;

	    @FXML
	    private Button reset;

	    @FXML
	    private Button back;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ccode.getItems().addAll("+91","+93","+54","+1");
		
	}
	
	
	public void confirmAction(ActionEvent e)throws Exception
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;
	
		try {
		 String url = "jdbc:mysql://localhost:3306/puppycentral";
		 String user = "root";
		 String pass ="nehas";
		 String query = "SELECT country_Code,phone_no FROM users WHERE phone_no =? and country_code =?";
		con = DriverManager.getConnection(url,user,pass);
		ps= con.prepareStatement(query);
		
		ps.setString(1, tphn.getText());
		ps.setString(2,ccode.getValue());
		rs = ps.executeQuery();
		
		
		
		if(rs.next())
        {
			ccode.setDisable(true);
			tphn.setDisable(true);
			lnpas.setVisible(true);
			tnpas.setVisible(true);
			lcpas.setVisible(true);
			tcpas.setVisible(true);
			reset.setVisible(true);
	    }
		else
		{
			JOptionPane.showMessageDialog(null, "PLEASE ENTER YOUR REGISTERED PHONE NUMBER");
		}
		
		}catch(Exception ex)
		{
			System.out.print(ex);
		}
	}
	
	
	public void resetAction(ActionEvent e)throws Exception
	{
		if(tnpas.getText().equals(tcpas.getText()))
		{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			 String url = "jdbc:mysql://localhost:3306/puppycentral";
			 String user = "root";
			 String pass ="nehas";
			 String query = "UPDATE users SET password = ?  WHERE phone_no =? AND country_code = ?";
			con = DriverManager.getConnection(url,user,pass);
			ps= con.prepareStatement(query);
			ps.setString(1, tcpas.getText());
			ps.setString(2, tphn.getText());
			ps.setString(3,ccode.getValue());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "PASSWORD RESET SUCCESSFUL");
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene sc = new Scene(root); 
			primaryStage.setScene(sc);
			primaryStage.show();
			primaryStage.setResizable(false);
		}catch(Exception ex)
		{
			System.out.print(ex);
		}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"PASSWORD DON'T MATCH");
		}
		
	}
	
	public void backction(ActionEvent e)throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene sc = new Scene(root); 
		primaryStage.setScene(sc);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	
	
	

}
