
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Videojuego implements Serializable {
    @Id
    private String nombre;
    private String anio;
    private String genero;
    private String trailer;
    private String linkCompra;
    private String portada;
    @ManyToOne
    @JoinColumn (name = "fk_console")
    private Consola sistema; 

    public Videojuego() {
    }

    public Videojuego(String nombre, String anio, String genero, String trailer, String linkCompra, String portada, Consola consola) {
        this.nombre = nombre;
        this.anio = anio;
        this.genero = genero;
        this.trailer = trailer;
        this.linkCompra = linkCompra;
        this.portada = portada;
        this.sistema = consola;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getLinkCompra() {
        return linkCompra;
    }

    public void setLinkCompra(String linkCompra) {
        this.linkCompra = linkCompra;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public Consola getConsola() {
        return sistema;
    }

    public void setConsola(Consola consola) {
        this.sistema = consola;
    }
    
    
}
