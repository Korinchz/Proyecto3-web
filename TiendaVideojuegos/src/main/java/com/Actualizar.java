/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
import dao.Juego;
import dao.JuegoRep;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author carlo
 */
@Named(value = "actualizar")
@RequestScoped
public class Actualizar {
JuegoRep Juegorepositorio = new JuegoRep();
        Juego juego = new Juego();
        
      String nombreActualiza, desarrolladorActualiza,generoActualiza,precioActualiza, modoActualiza,fechaLanzamientoActualiza, plataformaActualiza,idiomaActualiza;
       int BuscaID;

    public JuegoRep getJuegorepositorio() {
        return Juegorepositorio;
    }

    public void setJuegorepositorio(JuegoRep Juegorepositorio) {
        this.Juegorepositorio = Juegorepositorio;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public String getNombreActualiza() {
        return nombreActualiza;
    }

    public void setNombreActualiza(String nombreActualiza) {
        this.nombreActualiza = nombreActualiza;
    }

    public String getDesarrolladorActualiza() {
        return desarrolladorActualiza;
    }

    public void setDesarrolladorActualiza(String desarrolladorActualiza) {
        this.desarrolladorActualiza = desarrolladorActualiza;
    }

    public String getGeneroActualiza() {
        return generoActualiza;
    }

    public void setGeneroActualiza(String generoActualiza) {
        this.generoActualiza = generoActualiza;
    }

    public String getPrecioActualiza() {
        return precioActualiza;
    }

    public void setPrecioActualiza(String precioActualiza) {
        this.precioActualiza = precioActualiza;
    }

    public String getModoActualiza() {
        return modoActualiza;
    }

    public void setModoActualiza(String modoActualiza) {
        this.modoActualiza = modoActualiza;
    }

    public String getFechaLanzamientoActualiza() {
        return fechaLanzamientoActualiza;
    }

    public void setFechaLanzamientoActualiza(String fechaLanzamientoActualiza) {
        this.fechaLanzamientoActualiza = fechaLanzamientoActualiza;
    }

    public String getPlataformaActualiza() {
        return plataformaActualiza;
    }

    public void setPlataformaActualiza(String plataformaActualiza) {
        this.plataformaActualiza = plataformaActualiza;
    }

    public String getIdiomaActualiza() {
        return idiomaActualiza;
    }

    public void setIdiomaActualiza(String idiomaActualiza) {
        this.idiomaActualiza = idiomaActualiza;
    }

    public int getBuscaID() {
        return BuscaID;
    }

    public void setBuscaID(int BuscaID) {
        this.BuscaID = BuscaID;
    }
   public void actualizar(){
            juego.setIdJuego(BuscaID);
            juego.setDesarrollador(desarrolladorActualiza);
            juego.setFechaLanzamiento(fechaLanzamientoActualiza);
            juego.setGenero(generoActualiza);
            juego.setIdioma(idiomaActualiza);
            juego.setModoJuego(modoActualiza);
            juego.setNombre(nombreActualiza);
            juego.setPlataforma(plataformaActualiza);
            juego.setPrecio(precioActualiza);
         Juegorepositorio.actualizarJuego(juego);
}
    public Actualizar() {
    }
    
    
    
    private String time;

    @PostConstruct
    public void init() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        time = sdfDate.format(now);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    
}
