/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.solitariospider.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Lennyn
 */
public class CartaDto {
    public SimpleStringProperty id;
    public SimpleStringProperty rank;
    public SimpleStringProperty palo;
    public SimpleStringProperty estiloTrasero;
    public SimpleStringProperty estiloFrontal;
    public SimpleBooleanProperty mostrar;

    public CartaDto(String rank, String palo, String estiloFrontal, String estiloTrasero) {
        this();
        this.rank.set(rank);
        this.estiloFrontal.set(estiloFrontal);
        this.estiloTrasero.set(estiloTrasero);
        this.palo.set(palo);
        this.mostrar.set(false);
    }
    

    public CartaDto() {
        this.id = new SimpleStringProperty();
        this.rank = new SimpleStringProperty();        
        this.palo = new SimpleStringProperty();
        this.estiloFrontal =  new SimpleStringProperty();
        this.estiloTrasero =  new SimpleStringProperty();
        this.mostrar = new SimpleBooleanProperty(false);
    }

    public CartaDto(CartaDto cartaDto) {
        this();
        this.rank.set(cartaDto.getRank());
        this.estiloFrontal.set(cartaDto.getEstiloFrontal());
        this.estiloTrasero.set(cartaDto.getEstiloTrasero());
        this.palo.set(cartaDto.getPalo());
        this.mostrar.set(false);
    }

//    public Long getId() {        
//        if(id.get()!=null && !id.get().isEmpty())
//            return Long.valueOf(id.get());
//        else
//            return null;
//    }

    public void setId(Long id) {
        this.id.set(id.toString());
    }

    public String getRank() {
        return rank.get();
    }

    public void setRank (String valor) {
        this.rank.set(valor);
    }

    public String getEstiloTrasero() {
        return estiloTrasero.get();
    }
    
    public void setPalo (String valor) {
        this.rank.set(valor);
    }

    public String getPalo() {
        return estiloTrasero.get();
    }

    public void setEstiloTrasero(String estiloTrasero) {
        this.estiloTrasero.set(estiloTrasero);
    }

    public String getEstiloFrontal() {
        return estiloFrontal.get();
    }

    public void setEstiloFrontal(String estiloFrontal) {
        this.estiloFrontal.set(estiloFrontal);
    }

//    public ImageView getCart() {
//        return new ImageView("/cr/ac/una/solitariospider/estilo" + estiloFrontal.get() + "/"+ rank.get() + palo.get() +".gif");
//    }
    
    public ImageView getCarta() {
         if(mostrar.getValue()) {
             return new ImageView("/cr/ac/una/solitariospider/estilo" + estiloFrontal.get() + "/" + rank.get() + palo.get() +".gif");
         } else {
             return new ImageView("/cr/ac/una/solitariospider/estilo2/" + estiloTrasero.get() + ".gif");
         }
    }
    
    public void setCarta() {
        // new Image(url)
    Image image = new Image("/cr/ac/una/solitariospider/estilo" + estiloFrontal.get() + "/" + rank.get() + palo.get() +".gif");
    BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
    BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    Background background = new Background(backgroundImage);
//    setBackground(background);
//    return VBox();
    }
//    public Rectangle getCarta() {
//        Rectangle carta = new Rectangle(60, 90);
//        if(mostrar.getValue()) {
//            Image img = new Image("cr/ac/una/solitariospider/estilo1/" + rank.get() + palo.get() +".gif");
//            carta.setFill(new ImagePattern(img));
//        }
//        return carta;
//    }
    
    public Boolean getMostrar() {
        return mostrar.get();
    }

    public void setMostrar(Boolean mostrar) {
        this.mostrar.set(mostrar);;
    }

    public String getValor() {
        return rank.get() + palo.get(); 
    }
    
    public String mostrarCarta() {
        if(mostrar.getValue()) {
            return rank.get() + palo.get(); 
        }
        return "Esta boca abajo.";
    }
    
    @Override
    public String toString() {
        return "CartaDto{tipo=" + rank.getValue() + palo.getValue() + ", boca arriba: " + mostrar.toString() + "}";
    }
    
    
}
