/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.solitariospider.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import cr.ac.una.solitariospider.model.PartidaDto;
import cr.ac.una.solitariospider.util.AppContext;
import cr.ac.una.solitariospider.util.FlowController;
import cr.ac.una.solitariospider.util.Mensaje;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Lennyn
 */
public class PersonalizarController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnGuardarImagen;
    @FXML
    private JFXButton btnSubirImagen;
    
    FileChooser fileChooser = new FileChooser();
    @FXML
    private ImageView imgvParteTrasera;
    @FXML
    private JFXButton btnVolver;
    @FXML
    private JFXRadioButton radBtnClasico;
    @FXML
    private ToggleGroup tggEstiloFrontal;
    @FXML
    private JFXRadioButton radBtnModerno;
    @FXML
    private JFXRadioButton radBtnAzul;
    @FXML
    private ToggleGroup tggEstiloTrasero;
    @FXML
    private JFXRadioButton radBtnRojo;
    @FXML
    private JFXButton btnGuardar;

    PartidaDto partidaDto;
    AppContext partidaPrincipal;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser.setInitialDirectory(new File("C:\\"));
        radBtnClasico.setUserData("1");
        radBtnModerno.setUserData("2");
        radBtnAzul.setUserData("b");
        radBtnRojo.setUserData("a");
//        PartidaDto partidaDto = new PartidaDto();
    }    

    @Override
    public void initialize() {
    }

    @FXML
    private void onActionGuardarImagen(ActionEvent event) {
            Window stage = btnGuardarImagen.getScene().getWindow(); //get a handle to the stage
            fileChooser.setTitle("Save File"); //set the title of the Dialog window
            String defaultSaveName = "mySave";
            fileChooser.setInitialFileName(defaultSaveName); //set the default name for file to be saved
            //create extension filters. The choice will be appended to the end of the file name
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("jpeg Files", "*.jpeg"),
                    new FileChooser.ExtensionFilter("png Files", "*.png"),
                    new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            try
            {
                //Actually displays the save dialog - blocking
                File file = fileChooser.showSaveDialog(stage);
                if (file != null)
                {
                    File dir = file.getParentFile();//gets the selected directory
                    //update the file chooser directory to user selected so the choice is "remembered"
                    fileChooser.setInitialDirectory(dir); 
                    //TODO: handle saving data to disk or DB etc.
                }
            } catch (Exception ex)
            {

            }
    }

    @FXML
    private void onActionSubirImagen(ActionEvent event) {
        Window stage = this.btnSubirImagen.getScene().getWindow();
        fileChooser.setTitle("Load File");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Documents", "*.docx", "*.txt", "*.pdf"),
        new FileChooser.ExtensionFilter("Images", "*.png", "*.gif", "*.jpg"));
        File file = fileChooser.showOpenDialog(stage);
        {
            if (file != null)
            {
                File loadFile = file.getParentFile();
                fileChooser.setInitialDirectory(loadFile);
                String name = file.getName();
                String[] n = name.split("\\.");
                if (!n[0].isEmpty())
                {
                    //handle loading the file appropriately.
                }


            }   
        }
    }

    private Boolean setEstilo() {
        Boolean estilo = new Boolean(true);
        partidaDto =  (PartidaDto) partidaPrincipal.getInstance().get("partidaPrincipal");
         if (tggEstiloFrontal.getSelectedToggle() != null) {
            if (tggEstiloTrasero.getSelectedToggle() != null) {
                    String estiloFrontal = new String(tggEstiloFrontal.getSelectedToggle().getUserData().toString());
                    String estiloTrasero = new String(tggEstiloTrasero.getSelectedToggle().getUserData().toString());
                    partidaDto.setEstilo(estiloFrontal, estiloTrasero);                    
                    partidaPrincipal.getInstance().setPartida("partidaPrincipal", partidaDto);
                    estilo = true;
         } else {
                estilo = false;
            }
         } else {
            estilo = false;
         }
        return estilo; 
    }
    
    @FXML
    private void onActionVolverInicio(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("InicioView", "Solitario Spider: inicio");
        ((Stage) btnVolver.getScene().getWindow()).close();
    }

    @FXML
    private void onActionGuardarEstilo(ActionEvent event) {
        try {
            if(setEstilo()) {
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Personalizar", getStage(), "Estilo guardado satisfactoriamente.");
            } else {
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Personalizar", getStage(), "Debe ingresar un Nickname y alguna dificultad para continuar.");
            }
        } catch (Exception ex) {
            Logger.getLogger(ComenzarTableroController.class.getName()).log(Level.SEVERE, "Error personalizando.", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Personalizar", getStage(), "Ocurrio un error comenzando la partida.");
        }
    }
}

