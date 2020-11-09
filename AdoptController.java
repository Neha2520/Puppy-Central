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
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AdoptController implements Initializable {
    
    
    @FXML
    private ListView<String> listview;
    
    @FXML
    private ComboBox<String> cbreed;

    @FXML
    private Button details;

    @FXML
    private Slider age;

    @FXML
    private Label lage;
     
     @FXML
    private Button show;

   


    

    
    
    public static final int initial = 6;
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cbreed.getItems().addAll("GERMAN SHEAPHERD","BULL DOG","POODLE","LABRADOR","ROTTWEILER","DOBERMAN");
        age.setValue(initial);
        lage.setText(Integer.toString(initial));
        lage.textProperty().bindBidirectional(age.valueProperty(),NumberFormat.getNumberInstance());
       
        
        
       }   
    
    
     @FXML
    void breedact(ActionEvent event) {
        Connection con = null;
			PreparedStatement ps = null;
			
			ResultSet rs = null;
		
			try{
			 String url = "jdbc:mysql://localhost:3306/puppycentral";
			 String user = "root";
			 String pass ="nehas";
			 String query = "SELECT name FROM babies WHERE breed = ? AND age_in_months between ? AND ?";
			con = DriverManager.getConnection(url,user,pass);
			ps= con.prepareStatement(query);
			ps.setString(1, cbreed.getValue());
                        if(Integer.parseInt(lage.getText())>1 &&Integer.parseInt(lage.getText())<=12)
                        {
			ps.setString(2,"2");
                        ps.setString(3,"12");
                        
                        }
                        else if(Integer.parseInt(lage.getText())>12 &&Integer.parseInt(lage.getText())<=48 )
                        {
                           ps.setString(2,"13");
                        ps.setString(3,"48"); 
                        }
                        
			rs = ps.executeQuery();
                        
                        
                        while(rs.next())
                        {
                            listview.getItems().addAll(rs.getString(1));
                            System.out.println(rs.getString(1));
                        }
                        }catch(Exception e)
                        {
                            e.printStackTrace();
                        }
        
        
  }
    
    
    @FXML
    void chkdet(ActionEvent event) throws IOException {
        String xname = listview.getSelectionModel().getSelectedItem();
        String xbreed ="";
        int xage =0;
        String xcolor="";
        String xspec="";
       Connection con = null;
			PreparedStatement ps = null;
			
			ResultSet rs = null;
      
    try{
			 String url = "jdbc:mysql://localhost:3306/puppycentral";
			 String user = "root";
			 String pass ="nehas";
			 String query = "SELECT * FROM babies WHERE name =?";
			con = DriverManager.getConnection(url,user,pass);
			ps= con.prepareStatement(query);
                        ps.setString(1,xname);
                        rs = ps.executeQuery();
                        while(rs.next())
                        {
                            xbreed = rs.getString(2);
                            xage = rs.getInt(3);
                            xcolor = rs.getString(4);
                            xspec = rs.getString(5);
                        }
     
                        
      
      
      FXMLLoader loader = new FXMLLoader(getClass().getResource("AdoptDetails.fxml"));
				Parent root = (Parent) loader.load();
				AdoptDetailsController obj = loader.getController();
                                obj.namedet(xname,xbreed,xage,xcolor,xspec);
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }
}
    
    
      
    
    
    
    
    
    

