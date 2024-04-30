
package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearConsola(String nombre) {
        Consola nueva = new Consola();
        nueva.setNombre(nombre);
        
        controlPersis.crearConsola(nueva);
    }

    public void crearVideojuego(String nombre, String anio, String genero, String consola, String trailer) {
        Consola sistema = controlPersis.traerConsola(consola);
        Videojuego nuevo = new Videojuego();
        nuevo.setNombre(nombre);
        nuevo.setAnio(anio);
        nuevo.setGenero(genero);
        nuevo.setTrailer(trailer);
        nuevo.setConsola(sistema);
        
        controlPersis.crearVideojuego(nuevo);
    }

    public List<Videojuego> traerVideojuegos(String consola) {
        Consola sistema = controlPersis.traerConsola(consola);
        return sistema.getBiblioteca();
    }

    public void eliminarVideojuego(String nombre) {
        controlPersis.eliminarVideojuego(nombre);
    }
}
