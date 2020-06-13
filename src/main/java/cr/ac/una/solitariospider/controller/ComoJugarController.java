/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.solitariospider.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.solitariospider.util.FlowController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lennyn
 */
public class ComoJugarController extends Controller implements Initializable {

    @FXML
    private JFXButton btnVolver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void initialize() {
        
    }

    @FXML
    private void OnActionVolverInicio(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("InicioView", "Solitario Spider: inicio");
        ((Stage) btnVolver.getScene().getWindow()).close();
    }
    
}
