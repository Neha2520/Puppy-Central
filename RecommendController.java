/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puppycentral;

import java.io.FileWriter;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class RecommendController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private TextField tname;

    @FXML
    private TextField tcont;

    @FXML
    private TextField temail;

    @FXML
    private TextArea tarec;

    @FXML
    private Button submit;

    @FXML
    private Button back;
    

    @FXML
    void backact(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
			Scene sc = new Scene(root); 
			Stage primaryStage = new Stage();
			primaryStage.setScene(sc);
			primaryStage.show();
			primaryStage.setResizable(false);

    }

    @FXML
    void submitact(ActionEvent event) throws IOException {
         
             FileWriter obj1 = new FileWriter("Recommendations.txt",true);
             try{
                 obj1.write("Name : "+tname.getText()+"\n");
                 obj1.write("Contact no. : "+tcont.getText()+"\n");
                 obj1.write("Email : "+temail.getText()+"\n");
        		 obj1.write("RECOMMENDATION: \n");
        		 obj1.write(tarec.getText()+"\n");
        		 obj1.write("\n \n");
        		 obj1.close();
                         
                         JOptionPane.showMessageDialog(null,"THANKYOU "+tname.getText()+" FOR YOUR VALUABLE RECOMMENDATON");
                 
             }catch(Exception e)
             {
                 e.printStackTrace();
             }


    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
