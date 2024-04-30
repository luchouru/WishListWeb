
package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Consola implements Serializable {
    @Id
    private String nombre;
    @OneToMany (mappedBy = "sistema")
    private List<Videojuego> biblioteca;

    public Consola() {
    }

    public Consola(String nombre, List<Videojuego> biblioteca) {
        this.nombre = nombre;
        this.biblioteca = biblioteca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Videojuego> getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(List<Videojuego> biblioteca) {
        this.biblioteca = biblioteca;
    }
    
    
    
}
