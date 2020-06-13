package cr.ac.una.solitariospider;

import cr.ac.una.solitariospider.model.PartidaDto;
import cr.ac.una.solitariospider.util.AppContext;
import cr.ac.una.solitariospider.util.FlowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
//
    private static Scene scene;
    
    @Override
    public void start(Stage stage) throws IOException {
        PartidaDto partida = new PartidaDto();
        System.out.println(partida.estiloTrasero.getValue());
        AppContext.getInstance().setPartida("partidaPrincipal", partida);
        FlowController.getInstance().InitializeFlow(stage,null);
        FlowController.getInstance().goViewInWindow("ComenzarTableroView", "Solitario Spider: inicio");
    }
    
    public static void main(String[] args) {
        launch();
    }
    

}