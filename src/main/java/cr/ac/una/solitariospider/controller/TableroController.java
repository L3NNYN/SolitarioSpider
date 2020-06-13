/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.solitariospider.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import cr.ac.una.solitariospider.PrimaryController;
import cr.ac.una.solitariospider.model.CartaDto;
import cr.ac.una.solitariospider.model.PartidaDto;
import cr.ac.una.solitariospider.util.AppContext;
import cr.ac.una.solitariospider.util.Formato;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Lennyn
 */
public class TableroController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
//    private VBox columna;
    @FXML
    private VBox tablero;
    @FXML
    private VBox columna1;
    @FXML
    private VBox columna2;
    @FXML
    private VBox columna3;
    @FXML
    private VBox columna4;
    @FXML
    private VBox columna5;
    @FXML
    private VBox columna6;
    @FXML
    private VBox columna7;
    @FXML
    private VBox columna8;
    @FXML
    private VBox columna9;
    @FXML
    private VBox columna10;
    
    public VBox columnaTablero[];
    public ArrayList<VBox> col;
    public ArrayList<ArrayList<CartaDto>> columna;
    public ArrayList<CartaDto> mazo;
    
    public String[] palos = {"c", "d", "h", "s"};
    public SimpleStringProperty nickname;
    public SimpleStringProperty estiloFrontal;
    public SimpleStringProperty estiloTrasero;
    
    public int dificultad;
    PartidaDto partidaPrincipalDto;
    CartaDto carta;
    CartaDto ultimaCarta;
//    AppContext partidaPrincipal;
    AppContext estiloPartida;
    AppContext partidaPrincipal;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Primero se crean las instancias de las cartas y la partida que ya ha sido creada anteriormente
        //Para asi mantener la configuracion del Nickname junto con la cantidad de Palos.
        this.columnaTablero = new VBox[10];
        this.carta = new CartaDto();
        this.ultimaCarta = new CartaDto();
        
        this.partidaPrincipalDto = new PartidaDto();
        this.partidaPrincipalDto =  (PartidaDto) partidaPrincipal.getInstance().get("partidaPrincipal");
        
        this.nickname =  new SimpleStringProperty(partidaPrincipalDto.getNickname());
        this.dificultad = partidaPrincipalDto.getDificultad();
        this.estiloFrontal = new SimpleStringProperty(partidaPrincipalDto.getEstiloFrontal());
        this.estiloTrasero = new SimpleStringProperty(partidaPrincipalDto.getEstiloTrasero());
        
        this.col = new ArrayList<>();
        col.add(columna1);
        
        this.mazo = new ArrayList<CartaDto>();
        this.columna = new ArrayList<ArrayList<CartaDto>>();
        for(int i = 0; i < 10; i++) {
            columna.add(new ArrayList<CartaDto>());
        }
        System.out.println(estiloTrasero.get());
//        iniciarColumnas();
        
        //Primero se repartiran las 104 cartas dentro del mazo con los Palos elegidos.
        comenzarBaraja();
        
        //Se reparte entre las 10 columnas cartas aleatorias con las que se va a iniciar.
        repartirColumnas();
        dibujar();
//        dibujarCartas();
//        iniciarColumnas();
    }    
    
    @Override
    public void initialize() {
        
    }
    
    private void iniciarColumnas() {
        columnaTablero[0] = columna1;
        columnaTablero[1] = columna2;
        columnaTablero[2] = columna3;
        columnaTablero[3] = columna4;
        columnaTablero[4] = columna5;
        columnaTablero[5] = columna6;
        columnaTablero[6] = columna7;
        columnaTablero[7] = columna8;
        columnaTablero[8] = columna9;
        columnaTablero[9] = columna10;
        for(int i = 0; i < 10; i++) {
        ImageView cart;
//        for(ArrayList<CartaDto> cartaDto : columna) {
//            VBox vb = new CartaDto();
//            VBox cartVBox = new VBox(vb);
//            vb.getStyleClass().add("carta");
//            columnaTablero[i].getChildren().add(vb);
//            dragNode(vb);
//        }
        }
    }
    
    
    //El mazo/baraja usa un condicional if() que determinar con que cantidad de Palos se va a crear.
    private void comenzarBaraja() {
        Integer n = 0; 
            for(int j = 1; j <= 13; j++) {
                if(dificultad == 1) {
                    carta = new CartaDto(String.valueOf(j), palos[0], estiloFrontal.get(), estiloTrasero.get());
                    for(int k = 0; k < 8; k++) {
                        mazo.add(carta);
                        n++;
                    }
                } else if (dificultad == 2) {
                        for(int k = 0; k < 2; k++) {
                            carta = new CartaDto(String.valueOf(j), palos[k], estiloFrontal.get(), estiloTrasero.get());
                            for(int w = 0; w < 4; w++) {
                                mazo.add(carta);
                                n++;
                            }
                        }
                    } else {
                        for(int k = 0; k < 4; k++) {
                            carta = new CartaDto(String.valueOf(j), palos[k], estiloFrontal.get(), estiloTrasero.get());
                            for(int w = 0; w < 2; w++) {
                                mazo.add(carta);
                                n++;
                            }
                        }
                    }
            }
//        impList();
            
        
            
        //Se revuelven las cartas en la lista para que no sea "predecible".
        Collections.shuffle(mazo);

    }

    //Reparte cartas a las columnas.
    //Las cartas inicialmente estan boca abajo pero, si se determina que es la ultima
    //De la columna entonces le da vuelta (boca arriba) antes de agregarla.
    public void repartirColumnas() {
        int a = 0;
        for(int i=0; i < 10; i++) {
            if(i <= 3) {
                for(int j = 0; j <= 5; j++) {
                    ultimaCarta = new CartaDto(mazo.get(0));
                        if(j == 5) {
                                ultimaCarta.setMostrar(true);
                                columna.get(i).add(ultimaCarta);
                                a++;
                        } else {
                            columna.get(i).add(ultimaCarta);
                        }
                    mazo.remove(0);
                } 
            } else {
                for(int j = 0; j <= 4; j++) {
                    ultimaCarta = new CartaDto(mazo.get(0));
                        if(j == 4) {
                           ultimaCarta.setMostrar(true);
                           columna.get(i).add(ultimaCarta);
                           a++;
                       } else {
                           columna.get(i).add(ultimaCarta);
                        }
                     mazo.remove(0);
                }
            }
        }
        
//        impListPr();
    }
    
    public void impListPr() {
        int l = 0;
        for (int i =0; i < 10; i++) {
            System.out.println("Columna: " + i);
            for(int j = 0; j <columna.get(i).size(); j++) {
                System.out.println(columna.get(i).get(j).toString());
            }
        }
    }
    
    
    public void impList() {
        for (int i =0; i < 10; i++) {
            System.out.println("Columna: " + i);
            for(CartaDto car : columna.get(i)) {
                for(int j = 0; j <= columna.get(i).size(); j++) {
                    System.out.println(columna.get(i).get(j).getMostrar().toString());
                }
            }
        }
    }
    
    
    
    public void repartirMazo() {
        for (int i = 0; i < 10; i++) {
            for(CartaDto carta : columna.get(i)) {
//                ImageView cara = carta.getCarta();
//                columna1.getChildren().add(cara);
            }
        }
    }
    


    
    private void dibujarCartas() {
        ImageView cart = new ImageView();
        for(ArrayList<CartaDto> cartaDto: columna) {
             cart = cartaDto.get(0).getCarta();
            VBox cartVBox = new VBox(cart);
//             cartVBox.accessibleTextProperty("sdsd");
            columna1.getChildren().add(cartVBox);
            dragNode(cartVBox);
        }
    }
    
    public void dibujar() {
        
        ImageView vb = columna.get(0).get(0).getCarta();
        VBox cartVBox = new VBox(vb);
        
        cartVBox.setId(columna.get(0).get(0).getValor());
        columna1.getChildren().add(cartVBox);
        
        vb = columna.get(0).get(2).getCarta();
        
        VBox cox = new VBox(vb);
        cox.setPadding(new Insets(-50, 0, 0, 0));
        cartVBox.getChildren().add(cox);
        
//        cartVBox.setId(columna.get(0).get(0).getValor());
        dragNode(cartVBox);
        dragNode(cox);
    }
    
    public void dragNode(Node node) {
//        Node node = 
        final Delta dragDelta = new Delta();
        node.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                columna1.getChildren().remove(node);
                dragDelta.x = node.getLayoutX() - mouseEvent.getSceneX();
                dragDelta.y = node.getLayoutY() - mouseEvent.getSceneY();
                
            }
        });

        node.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                columna1.getChildren().add(node);
                node.setCursor(Cursor.HAND);
            }
        });

        node.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
//                root.getChildren().add(node);
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
}
    
