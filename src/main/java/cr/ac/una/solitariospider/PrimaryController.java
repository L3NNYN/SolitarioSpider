package cr.ac.una.solitariospider;

import cr.ac.una.solitariospider.model.CartaDto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class PrimaryController {

    private final int margin = 10;
		
    private final int cardWidth = 71;
    private final int cardHeight = 96;
    @FXML
    private VBox root;
    @FXML
    private Button primaryButton;
    Rectangle rectangle;
    @FXML
    private Label lblPrimary;
    final Delta dragDelta = new Delta();
    @FXML
    private AnchorPane raat;
    
    @FXML
    private void switchToSecondary() throws IOException {
        Rectangle rectangle = new Rectangle(60,90);
        draw();
    }
    
    public void dibujar() {
//        CartaDto carta = draw();
    }

    private void draw() {
    Rectangle rectangle = new Rectangle(60,90);
      Image img = new Image("cr/ac/una/solitariospider/estilo1/13s.gif");
      rectangle.setFill(new ImagePattern(img));
      raat.getChildren().add(rectangle);
       dragNode(rectangle);
//      MouseControlUtil.makeDraggable(rectangle);
//      Group rect = new Group(rectangle); 
//       rectangle.setOnMouseDragReleased((event) -> {
//        System.out.println("centerBorderPane drag released");
//        });
    }
    public void dragNode(Node node) {
        final Delta dragDelta = new Delta();

        node.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dragDelta.x = node.getLayoutX() - mouseEvent.getSceneX();
                System.out.println(mouseEvent.getSceneX());
                dragDelta.y = node.getLayoutY() - mouseEvent.getSceneY();
            }
        });

        node.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                node.setCursor(Cursor.HAND);
            }
        });

        node.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                node.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
                node.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
            }
        });

        node.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                node.setCursor(Cursor.HAND);
            }
        });
    }
    
    class Delta { double x, y; }

    @FXML
    private void labelRelease(MouseEvent mouseEvent) {
        lblPrimary.setCursor(Cursor.OPEN_HAND);
    }

    @FXML
    private void labeldDragg(MouseEvent mouseEvent) {
        lblPrimary.setCursor(Cursor.CLOSED_HAND);
        lblPrimary.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
        lblPrimary.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
    }

    @FXML
    private void labelEnter(MouseEvent mouseEvent) {
        lblPrimary.setCursor(Cursor.OPEN_HAND);
    }

    @FXML
    private void labelPress(MouseEvent mouseEvent) {
        lblPrimary.setCursor(Cursor.CLOSED_HAND);
        dragDelta.x = lblPrimary.getLayoutX() - mouseEvent.getSceneX();
        dragDelta.y = lblPrimary.getLayoutY() - mouseEvent.getSceneY();
    }


}

