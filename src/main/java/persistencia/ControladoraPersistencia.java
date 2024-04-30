
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Consola;
import logica.Videojuego;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    
    ConsolaJpaController consolaJpa = new ConsolaJpaController();
    VideojuegoJpaController videojuegoJpa = new VideojuegoJpaController();

    public void crearConsola(Consola nueva) {
        try {
            consolaJpa.create(nueva);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Consola traerConsola(String consola) {
        return consolaJpa.findConsola(consola);
    }

    public void crearVideojuego(Videojuego nuevo) {
        try {
            videojuegoJpa.create(nuevo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarVideojuego(String nombre) {
        try {
            videojuegoJpa.destroy(nombre);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
