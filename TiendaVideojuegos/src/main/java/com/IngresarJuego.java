/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com;




import dao.Juego;
import dao.JuegoRep;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;



/**
*
* @author jesus
*/
@Named(value = "ingresarjuegos")
@RequestScoped
public class IngresarJuego extends Juego {
JuegoRep Juegorepositorio = new JuegoRep();
        Juego juego = new Juego();
        
      String nombreJuego, desarrolladorJuego,generoJuego,precioJuego, modoJuegoJuego,fechaLanzamientoJuego, plataformaJuego,idiomaJuego;
       int BuscaID;
        
    public int getBuscaID() {
        return BuscaID;
    }

    public void setBuscaID(int BuscaID) {
        this.BuscaID = BuscaID;
    }
    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public String getDesarrolladorJuego() {
        return desarrolladorJuego;
    }

    public void setDesarrolladorJuego(String desarrolladorJuego) {
        this.desarrolladorJuego = desarrolladorJuego;
    }

    public String getGeneroJuego() {
        return generoJuego;
    }

    public void setGeneroJuego(String generoJuego) {
        this.generoJuego = generoJuego;
    }

    public String getPrecioJuego() {
        return precioJuego;
    }

    public void setPrecioJuego(String precioJuego) {
        this.precioJuego = precioJuego;
    }

    public String getModoJuegoJuego() {
        return modoJuegoJuego;
    }

    public void setModoJuegoJuego(String modoJuegoJuego) {
        this.modoJuegoJuego = modoJuegoJuego;
    }

    public String getFechaLanzamientoJuego() {
        return fechaLanzamientoJuego;
    }

    public void setFechaLanzamientoJuego(String fechaLanzamientoJuego) {
        this.fechaLanzamientoJuego = fechaLanzamientoJuego;
    }

    public String getPlataformaJuego() {
        return plataformaJuego;
    }

    public void setPlataformaJuego(String plataformaJuego) {
        this.plataformaJuego = plataformaJuego;
    }

   public String getIdiomaJuego() {
        return idiomaJuego;
    }

    public void setIdiomaJuego(String idiomaJuego) {
        this.idiomaJuego = idiomaJuego;
    }
   
public void agregar(){
            juego.setDesarrollador(desarrolladorJuego);
            juego.setFechaLanzamiento(fechaLanzamientoJuego);
            juego.setGenero(generoJuego);
            juego.setIdioma(idiomaJuego);
            juego.setModoJuego(modoJuegoJuego);
            juego.setNombre(nombreJuego);
            juego.setPlataforma(plataformaJuego);
            juego.setPrecio(precioJuego);
            Juegorepositorio.crearJuego(juego); 
}     
public void eliminar(){ 
            Juegorepositorio.eliminarJuego(BuscaID);        
}
    public IngresarJuego() {
    }
    


  
}
