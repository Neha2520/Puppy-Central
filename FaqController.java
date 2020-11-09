/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puppycentral;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FaqController implements Initializable {

    /**
     * Initializes the controller class.
     */ @FXML
    private TextArea faq;
     
     public void faqs() throws FileNotFoundException
     {
         File obj = new File("E:\\Netbeans Project\\puppycentral\\src\\images\\Recommendations.txt");
         Scanner myReader = new Scanner(obj);
         while(myReader.hasNextLine())
         {
             
         String Data = myReader.nextLine();
         faq.appendText("\n"+Data);
         }
         faq.setDisable(true);
         
     }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
