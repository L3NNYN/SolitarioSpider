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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lennyn
 */
public class InicioController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnPartida;
    @FXML
    private JFXButton btnPersonalizar;
    @FXML
    private JFXButton btnPuntajes;
    @FXML
    private JFXButton btnAcerdaDe;
    @FXML
    private JFXButton btnComoJugar;

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
    private void onActionIniciarPartida(ActionEvent event) {
        ((Stage) btnPartida.getScene().getWindow()).close();
         FlowController.getInstance().goViewInWindow("ComenzarTableroView", "Solitario Spider: Comenzar");
    }

    @FXML
    private void onActionVentanaPersonalizar(ActionEvent event) {
        ((Stage) btnPersonalizar.getScene().getWindow()).close();
        FlowController.getInstance().goViewInWindow("PersonalizarView", "Solitario Spider: Personalizacion");
    }

    @FXML
    private void onActionVentanaComoJugar(ActionEvent event) {
        ((Stage) btnComoJugar.getScene().getWindow()).close();
        FlowController.getInstance().goViewInWindow("ComoJugarView", "Solitario Spider: Como Jugar");
    }

    @FXML
    private void onActionVentanaAcercaDe(ActionEvent event) {
        ((Stage) btnAcerdaDe.getScene().getWindow()).close();
        FlowController.getInstance().goViewInWindow("AcercaDeView", "Solitario Spider: Acerca De");
    }

    @FXML
    private void onActionVentanaPuntuaciones(ActionEvent event) {
        ((Stage) btnPuntajes.getScene().getWindow()).close();
        FlowController.getInstance().goViewInWindow("PuntuacionesView", "Solitario Spider: Puntuaciones");
    }
    
}
