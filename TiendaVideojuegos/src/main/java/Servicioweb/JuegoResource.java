/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicioweb;
import dao.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * REST Web Service
 *
 * @author jesus
 */
@Path("juego")
@RequestScoped
public class JuegoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of JuegoResource
     */
    public JuegoResource() {
    }
    
@GET
@Path("/juegos")
@Produces(MediaType.APPLICATION_JSON)
public Response getPersonas(){
    try {
         JuegoRep juegoRepositorio = new JuegoRep();
            List<Juego> listaJuegos = juegoRepositorio.listaJuegos();
            JsonArrayBuilder arregloJuegos = Json.createArrayBuilder();
            for(Juego juego : listaJuegos){
                JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
                JsonObject jsonObject = jsonObjectBuilder
                        .add("desarrollador", juego.getDesarrollador())
                        .add("fechaLanzamiento", juego.getFechaLanzamiento())
                        .add("genero", juego.getGenero())
                        .add("modoJuego", juego.getModoJuego())
                        .add("nombre", juego.getNombre())
                        .add("plataforma", juego.getPlataforma())
                        .add("precio", juego.getPrecio())
                        .add("idioma", juego.getIdioma())
                        .add("idJuego", juego.getIdJuego())
                        .build();
                arregloJuegos.add(jsonObject);
            }
          JsonObjectBuilder jsonObjectBuilder2 = Json.createObjectBuilder();
            JsonObject jsonFinal = jsonObjectBuilder2.add("juegos", arregloJuegos).build();
            StringWriter jsonString = new StringWriter();
            JsonWriter jsonWriter = Json.createWriter(jsonString);
            jsonWriter.writeObject(jsonFinal);
            return Response.ok(jsonString.toString()).build();    
    } catch (Exception e) {
        System.out.println(e.getMessage());
        String resultado = "{\"error\": \"Ocurrió un error\"}";
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(resultado).build();
    }
}

@POST
    @Path("/agregarJuego")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ingresarJuego(String content){
        try{
            JsonReader jsonReader = Json.createReader(new StringReader(content));
            JsonObject jsonObject = jsonReader.readObject();
            Juego juego = new Juego();
            juego.setDesarrollador(jsonObject.getString("desarrollador"));
            juego.setFechaLanzamiento(jsonObject.getString("fechalanzamiento"));
            juego.setGenero(jsonObject.getString("genero"));
            juego.setIdioma(jsonObject.getString("idioma"));
            juego.setModoJuego(jsonObject.getString("modoJuego"));
            juego.setNombre(jsonObject.getString("nombre"));
            juego.setPlataforma(jsonObject.getString("plataforma"));
            juego.setPrecio(jsonObject.getString("precio"));
            JuegoRep juegoRepositorio = new JuegoRep();
            juegoRepositorio.crearJuego(juego);
            return Response.ok("{\"resultado\": \"Exitoso\"}").build();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            String resultado = "{\"error\": \"Ocurrió un error\"}";
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(resultado).build();
        }
    }

}
