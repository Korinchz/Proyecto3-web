/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daojuegos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlo
 */
public class JuegosRepositorio {
    private static List<Juegos> listaJuegos = new ArrayList<>();

    public static List<Juegos> getListaJuegos() {
        return listaJuegos;
    }

    public static void setListaJuegos(List<Juegos> listaJuegos) {
        JuegosRepositorio.listaJuegos = listaJuegos;
    }
    
    public static void agregarJuegos(Juegos juegos){
        listaJuegos.add(juegos);
    }
    
  
}
