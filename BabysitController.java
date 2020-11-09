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
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class BabysitController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ComboBox<String> cbreed;

    @FXML
    private ListView<String> lnames;

    @FXML
    private DatePicker date;

    @FXML
    private Button bconf;

    @FXML
    private ImageView imageview;

    @FXML
    void breedchoose(ActionEvent event) {
        Connection con = null;
			PreparedStatement ps = null;
			
			ResultSet rs = null;
		
			try{
			 String url = "jdbc:mysql://localhost:3306/puppycentral";
			 String user = "root";
			 String pass ="nehas";
			 String query = "SELECT name FROM babies WHERE breed = ?";
			con = DriverManager.getConnection(url,user,pass);
			ps= con.prepareStatement(query);
			ps.setString(1, cbreed.getValue());
                         rs = ps.executeQuery();
                        while(rs.next())
                        {
                            lnames.getItems().addAll(rs.getString(1));
                        }
                        }catch(Exception e)
                        {
                            e.printStackTrace();
                        }

    }

    @FXML
    void confirm(ActionEvent event) {
        
        String xname = lnames.getSelectionModel().getSelectedItem();
        if(xname.equals("BOB"))
        {
            Image image = new Image("/images/bob.jpg");
            imageview.setImage(image);
        }
        else if(xname.equals("SHERU"))
        {
            Image image = new Image("/images/sheru.jpg");
            imageview.setImage(image);
        }


    }
    
      @FXML
    void confirmbabysit(ActionEvent event) {
      String password =  JOptionPane.showInputDialog("confirm your password");
        String xname = lnames.getSelectionModel().getSelectedItem();
        LocalDate id = date.getValue();
        String dateofvisit = String.valueOf(id);
        System.out.println(xname);
        System.out.println(password);
        System.out.println(dateofvisit);

        
        Connection con = null;
			PreparedStatement ps = null;
			
			ResultSet rs = null;
      
    try{
			 String url = "jdbc:mysql://localhost:3306/puppycentral";
			 String user = "root";
			 String pass ="nehas";
			 String query = "update users set baby_Sit =? ,date_of_sit = ? where password = ?";
			con = DriverManager.getConnection(url,user,pass);
			ps= con.prepareStatement(query);
                        ps.setString(1,xname);
                        ps.setString(2, dateofvisit);
                        ps.setString(3, password);
                        ps.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, xname+" will be waiting for you on "+dateofvisit);
                        
     }
    catch(Exception e)
    {
        e.printStackTrace();
    }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbreed.getItems().addAll("GERMAN SHEAPHERD","BULL DOG","POODLE","LABRADOR","ROTTWEILER","DOBERMAN");
    }    
    
}
