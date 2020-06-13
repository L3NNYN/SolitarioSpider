 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.solitariospider.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author Lennyn
 */

public class PartidaDto {
    public SimpleStringProperty id;
    public SimpleStringProperty nickname;
    public int dificultad;
    public int puntaje;
    public int movimientos;
    public int pilas;
    public SimpleStringProperty estiloFrontal;
    public SimpleStringProperty estiloTrasero;
    public ArrayList<CartaDto> mazo;
//    public ArrayList<CartaDto> mazo;
    public ArrayList<ArrayList<CartaDto>> columna;
    public String[] palos = {"c", "d", "h", "s"};
    CartaDto carta;
    
    
    //Constructor sin parametros
    
    public PartidaDto() {
        this.id = new SimpleStringProperty();
        this.mazo = new ArrayList<CartaDto>();
        this.columna = new ArrayList<ArrayList<CartaDto>>();
        this.estiloFrontal = new SimpleStringProperty("1");
        this.estiloTrasero = new SimpleStringProperty("b");
        this.nickname = new SimpleStringProperty();
        this.dificultad = new Integer(new String("1"));
        for(int i = 0; i < 10; i++) {
            columna.add(new ArrayList<CartaDto>());
        }
//        repartir();
    }

    public PartidaDto(String nickname, String dificultad) {
        this();
        try {
            this.nickname.set(nickname);
            this.dificultad = (Integer.valueOf(dificultad));
//            repartir();
        } catch (NumberFormatException ex) {
            Logger.getLogger(PartidaDto.class.getName()).log(Level.SEVERE, "Error al iniciar la partida.", ex);
        }
    }
    
    public void setEstilo(String estiloFrontal, String estiloTrasero) {
        this.estiloFrontal.set(estiloFrontal);
        this.estiloTrasero.set(estiloTrasero);
        System.out.println("Funciona estilo");
    }
    
    public void setInfo(String nickname, String dificultad) {
            this.nickname.set(nickname);
            this.dificultad = (Integer.valueOf(dificultad));
    }
    
    //Metodo que reparte la baraja
    //Reparte un palo y un numero como valor que tendra
//    private void repartir() {
//        System.out.println("PRIMERA PARTE");
//        Integer n = 0; 
//            for(int j = 1; j <= 13; j++) {
//                if(dificultad == 1) {
//                    carta = new CartaDto(String.valueOf(j), palos[0]);
//                    for(int k = 0; k < 8; k++) {
//                        mazo.add(carta);
//                        n++;
//                    }
//                } else if (dificultad == 2) {
//                        for(int k = 0; k < 2; k++) {
//                        carta = new CartaDto(String.valueOf(j), palos[k]);
//                            for(int w = 0; w < 4; w++) {
//                                mazo.add(carta);
//                                n++;
//                            }
////                                
//                        }
//                    } else {
//                        for(int k = 0; k < 4; k++) {
//                            carta = new CartaDto(String.valueOf(j), palos[k]);
//                                for(int w = 0; w < 2; w++) {
//                                    mazo.add(carta);
//                                    n++;
//                                }
//                        }
//                    }
//        }
//        
//        System.out.println(n);
//        //Se revuelven las cartas en la lista para que no sea "predecible".
//        Collections.shuffle(mazo);
////        for(CartaDto car : mazo) {
////            System.out.println(car.toString());
////        }
//        System.out.println("SEGUNDA PARTE");
//        //Reparte cartas a las columnas.
//        for(int i=0; i < 10; i++) {
//            System.out.println(i);
//            if(i < 4) {
//                    for(int j = 0; j < 5; j++) {
//                CartaDto ultimaCarta = mazo.get(0);
//                        if(j == 4) {
//                            ultimaCarta.setMostrar(true);
//                            columna.get(i).add(ultimaCarta);
//                            
//                        } else {
//                            columna.get(i).add(ultimaCarta);
//                        }
//                mazo.remove(0);
//                    } 
//            } else {
//                for(int j = 0; j < 4; j++) {
//                    CartaDto ultimaCarta = mazo.get(0);
//                     if(j == 3) {
//                        ultimaCarta.setMostrar(true);
//                        columna.get(i).add(ultimaCarta);
//                    } else {
//                        columna.get(i).add(mazo.get(0));
//                     }
//                     mazo.remove(0);
//                } 
//            }
//        }
//        System.out.println( columna.get(0).get(0).toString());
//        
//    }
    
    public void imprimir() {
//        for(int i = 0; i < 10; i++){
//            if(i < 4) {
//                for(int j = 0; j < 5; j++) {
//                    columna.get(i).add(mazo.get(0));
//                    mazo.remove(0);
//                } 
//            } else {
//                for(int j = 0; j < 4; j++) {
//                    columna.get(i).add(mazo.get(0));
//                    mazo.remove(0);
//                } 
//            }
//        }
            for(ArrayList<CartaDto> car : columna) {
                System.out.println(car.toString());
            }
        
    }
    
    
    public CartaDto prueba() {
        return columna.get(0).get(0);
    }
    public CartaDto prueba2() {
        return columna.get(0).get(0);
    }
    
    //Hace la evaluacion para agregar una nueva carta a la columna.
    public void validarColumna(CartaDto cartaNue) {
        Boolean valido = true;
        CartaDto cartaAnt = columna.get(0).get(columna.size() - 1);
        if(Integer.parseInt(cartaAnt.getRank()) < Integer.parseInt(cartaNue.getRank())) {
            valido = false;
        }
    }
    
    //Reparte 10 cartas a todas las columnas.
//    public void repartirCartasMazo() {
//        for(int i=0; i < 10; i++) {
//            columna.get(i).add(mazo.get(0));
//            mazo.remove(0);
//        }
//    }
    
    
    
    //Comprobar que todas las columnas tengan al menos una carta antes
    //De repartir las 10 cartas.
    public Boolean validarRepartoMazo() {
        Boolean repartir = true;
            for(int i = 0; i < 10; i++) {
                if(columna.get(i).isEmpty()) {
                    repartir = false;
                }
            }
        return repartir;
    }
    
    
    public PartidaDto(Long id, SimpleStringProperty nickname) {
//        this.color = new ArrayList<>();
//        this.id = id.toString();
        this.nickname = nickname;
    }
    
    public Long getId() {
        if(id.get()!=null && !id.get().isEmpty())
            return Long.valueOf(id.get());
        else
            return null;
    }

    public void setId(Long id) {
        this.id.setValue(Long.toString(id));
    }

    public String getNickname() {
        return nickname.get();
    }

    public void setNickname(String nickname) {
        this.nickname.setValue(nickname);
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public String getEstiloFrontal() {
        return estiloFrontal.get();
    }

    public String getEstiloTrasero() {
        return estiloTrasero.get();
    }
   
    
    
}
