/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puppycentral;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AdoptDetailsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField tname;

    @FXML
    private TextField tbreed;

    @FXML
    private TextField tage;

    @FXML
    private TextField tcolor;

    @FXML
    private TextField tspec;

    @FXML
    private Button bback;

    @FXML
    private Button badopt;

    @FXML
    void adpt(ActionEvent event)throws Exception {
        
                        
        Connection con = null;
			PreparedStatement ps = null;
			
			
                       
                       int noOfAdpt =0;
                       String password = JOptionPane.showInputDialog("confirm password");
                       
                       
      
    try{
         String url = "jdbc:mysql://localhost:3306/puppycentral";
			 String user = "root";
			 String pass ="nehas";
			 String query = "UPDATE users set no_of_adopts = no_of_adopts+1 where password =?";
			con = DriverManager.getConnection(url,user,pass);
			ps= con.prepareStatement(query);
                        ps.setString(1,password);
                        ps.executeUpdate();
                        
                        
			JOptionPane.showMessageDialog(null, "CONGRATULATIONS ON YOUR NEW FRIEND");
        
    }catch(Exception e)
    {
      e.printStackTrace();
    }
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("Adopt.fxml"));
			Scene sc = new Scene(root); 
			Stage primaryStage = new Stage();
			primaryStage.setScene(sc);
			primaryStage.show();
			primaryStage.setResizable(false);

    }
    public void namedet(String name,String breed,int age,String color,String spec)
    {
        tname.setText(name);
        tbreed.setText(breed);
        tage.setText(String.valueOf(age)+"Months");
        tcolor.setText(color);
        tspec.setText(spec);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
