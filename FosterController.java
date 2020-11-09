/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puppycentral;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FosterController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    
    @FXML
    private TextField tbreed;

    @FXML
    private TextField tage;

    @FXML
    private ColorPicker tcol;

    @FXML
    private TextField tplace;

    @FXML
    private TextField tname;

    @FXML
    private TextField tcont;

    @FXML
    private TextField tadd;

    @FXML
    private Button bsub;

    @FXML
    void subdet(ActionEvent event) {
        
        Connection con = null;
        Color c = tcol.getValue();
			PreparedStatement ps = null;
                        try {
				 String url = "jdbc:mysql://localhost:3306/puppycentral";
				 String user = "root";
				 String pass ="nehas";
				 String query = "insert into foster values(?,?,?,?,?,?,?)";
				con = DriverManager.getConnection(url,user,pass);
				ps= con.prepareStatement(query);
				ps.setString(1, tbreed.getText());
				ps.setInt(2, Integer.parseInt(tage.getText()));
				ps.setString(3, String.valueOf(c));
				ps.setString(4, tplace.getText());
                                ps.setString(5,tname.getText());
				ps.setString(6, tcont.getText());
                                ps.setString(7, tadd.getText());
				ps.execute();
				JOptionPane.showMessageDialog(null, "THANKYOU FOR YOU SUPPORT.. OUR EMPLOYEE WILL BE AT YOUR PLACE SOON");
				
				
			}catch(Exception ex)
			{
				System.out.print(ex);
			}

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
