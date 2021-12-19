/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author jesus
 */
public class JuegoRep {
  
    //-------------------------------------------//
    public List<Juego> listaJuegos(){
        EntityManager conexion = Conexion_JPA_ORM.getEntityManagerFactory().createEntityManager();
        try{
            Query query = conexion.createNamedQuery("Juego.findAll");
            List<Juego> juegos = query.getResultList();
            return juegos;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        finally{
            conexion.close();
        }
    }
    public Juego leerJuegos(int idJuego){
        EntityManager conexion = Conexion_JPA_ORM.getEntityManagerFactory().createEntityManager();
        try{
            Query query = conexion.createNamedQuery("Juego.findByIdJuego");
            query.setParameter("idJuego", idJuego);
            List<Juego> juegos = query.getResultList();
            return juegos.isEmpty() ? null : juegos.get(0);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        finally{
            conexion.close();
        }
    }
    public Boolean crearJuego(Juego juego){
        EntityManager conexion = Conexion_JPA_ORM.getEntityManagerFactory().createEntityManager();
        try{
            juego.setIdJuego(null);
            conexion.getTransaction().begin();
            conexion.persist(juego);
            conexion.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        finally{
            conexion.close();
        }
    }
     public Boolean actualizarJuego(Juego juego){
        EntityManager conexion = Conexion_JPA_ORM.getEntityManagerFactory().createEntityManager();
        try{
            conexion.getTransaction().begin();
            conexion.merge(juego);
            conexion.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        finally{
            conexion.close();
        }
    }
     public Boolean eliminarJuego(int idJuego){
        EntityManager conexion = Conexion_JPA_ORM.getEntityManagerFactory().createEntityManager();
        try{
            conexion.getTransaction().begin();
            Juego juego = conexion.find(Juego.class, idJuego);
            conexion.remove(juego);
            conexion.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        finally{
            conexion.close();
        }
    }
   
  
      
}
