/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.solitariospider.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import cr.ac.una.solitariospider.model.PartidaDto;
import cr.ac.una.solitariospider.util.AppContext;
import cr.ac.una.solitariospider.util.FlowController;
import cr.ac.una.solitariospider.util.Formato;
import cr.ac.una.solitariospider.util.Mensaje;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author Lennyn
 */

public class ComenzarTableroController extends Controller implements Initializable {

    @FXML
    private JFXTextField txtNickname;
    @FXML
    private JFXRadioButton radBtnFacil;
    @FXML
    private ToggleGroup tggDificultad;
    @FXML
    private JFXRadioButton radBtnIntermedio;
    @FXML
    private JFXRadioButton radBtnDificil;
    @FXML
    private JFXButton btnComenzar;
    AppContext partidaPrincipal;
    PartidaDto partidaDto; 
    @FXML
    private JFXButton btnVolver;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtNickname.setTextFormatter(Formato.getInstance().letrasFormat(15));
        radBtnFacil.setUserData("1");
        radBtnIntermedio.setUserData("2");
        radBtnDificil.setUserData("4");
    }
    
    @Override
    public void initialize() {
    }
    
    private Boolean iniciarJugador() {
//        comenzarPartida.getInstance();
        Boolean datos = new Boolean(true);
        partidaDto =  (PartidaDto) partidaPrincipal.getInstance().get("partidaPrincipal");
        try {
            if (tggDificultad.getSelectedToggle() != null) {
                if (!txtNickname.getText().isEmpty()) {
                    String dificultad = new String(tggDificultad.getSelectedToggle().getUserData().toString());
                    String nickname = new String(txtNickname.textProperty().getValue().toString());
                    partidaDto.setInfo(nickname, dificultad);
                    partidaPrincipal.getInstance().setPartida("partidaPrincipal", partidaDto);
                } else {
                    datos = false;
                }
            } else {
                datos = false;
            }
        } catch (Exception e) {
             Logger.getLogger(ComenzarTableroController.class.getName()).log(Level.SEVERE, "Error al crear la partida.", e);
        }
        return datos;
    }
    
    @FXML
    private void onActionComenzarPartida(ActionEvent event) {
        try {
            if(iniciarJugador()) {
                ((Stage) btnComenzar.getScene().getWindow()).close();
                FlowController.getInstance().goViewInWindow("TableroView", "Solitario Spider: Tablero");
            } else {
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Comenzar partida", getStage(), "Debe ingresar un Nickname y alguna dificultad para continuar.");
            }
        } catch (Exception ex) {
            Logger.getLogger(ComenzarTableroController.class.getName()).log(Level.SEVERE, "Error al iniciar la partida.", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Comenzar partida", getStage(), "Ocurrio un error comenzando la partida.");
        }
        
    }

    @FXML
    private void onActionVolverInicio(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("InicioView", "Solitario Spider: inicio");
        ((Stage) btnVolver.getScene().getWindow()).close();
    }

}
