
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Videojuego;


@WebServlet(name = "SvVideojuego", urlPatterns = {"/SvVideojuego"})
public class SvVideojuego extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");      
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nombre = request.getParameter("nombre");
        String anio = request.getParameter("anio");
        String genero = request.getParameter("genero");
        String consola = request.getParameter("consola");
        String trailer = request.getParameter("trailer");
        
        if(nombre.isBlank() || anio.isBlank() || genero.isBlank())
            response.sendRedirect("altaVideojuegoError.jsp");
        else {
            control.crearVideojuego(nombre,anio,genero,consola,trailer);
            response.sendRedirect("index.jsp");
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
