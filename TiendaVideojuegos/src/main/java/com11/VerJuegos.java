/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com11;

import daojuegos.Juegos;
import daojuegos.JuegosRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author carlo
 */
@Named(value = "verJuegos")
@RequestScoped
public class VerJuegos extends Juegos {
    private List<Juegos> listaJuegos = new ArrayList<Juegos>();

    public List<Juegos> getListaJuegos() {
        return listaJuegos;
    }

    public void setListaJuegos(List<Juegos> listaJuegos) {
        this.listaJuegos = listaJuegos;
    }
    
    /**
     * Creates a new instance of VerPersonas
     */
    public VerJuegos() {
    }
    
    @PostConstruct
    public void init(){
        listaJuegos = JuegosRepositorio.getListaJuegos();
    }
    
}
