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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class DonateController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private Button bfif;

    @FXML
    private Button bhun;

    @FXML
    private Button bfivehun;

    @FXML
    private Button bthousand;

    @FXML
    private TextField tamt;

    @FXML
    private Button bproceed;

    @FXML
    private TextField tcardno;

    @FXML
    private TextField tname;

    @FXML
    private Button bdonate;
    @FXML
    private Label lcardno;
    

    @FXML
    private Label lname;

    
    @FXML
    private TextField tcvv;

    @FXML
    private Label lcvv;

    


    @FXML
    void actfivehun(ActionEvent event) {
        tamt.setText("500");

    }

    @FXML
    void actthou(ActionEvent event) {
         tamt.setText("1000");

    }

    @FXML
    void donateaction(ActionEvent event) throws IOException {
        String password = JOptionPane.showInputDialog("Enter your phone number linked to the card");
        FileWriter obj1 = new FileWriter("Donations.txt",true);
             try{
                 obj1.write("Name : "+tname.getText()+"\n");
                 obj1.write("Contact : "+password+"\n");
                 obj1.write("Card no. : "+tcardno.getText()+"\n");
                 obj1.write("Amount of Donation. : "+tamt.getText()+"\n");
        		 obj1.write("\n \n");
        		 obj1.close();
                         
                         JOptionPane.showMessageDialog(null,"THANKYOU "+tname.getText()+" FOR GIFTING YOUR LOVE TO BABIES");
                 
             }catch(Exception e)
             {
                 e.printStackTrace();
             }

    }

    @FXML
    void fivact(ActionEvent event) {
         tamt.setText("50");

    }

    @FXML
    void hunact(ActionEvent event) {
         tamt.setText("100");

    }

    @FXML
    void payact(ActionEvent event) {
        lcardno.setVisible(true);
        tcardno.setVisible(true);
        lcvv.setVisible(true);
        tcvv.setVisible(true);
        lname.setVisible(true);
        tname.setVisible(true);
        bdonate.setVisible(true);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
