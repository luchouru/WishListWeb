
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


@WebServlet(name = "SvXboxOne", urlPatterns = {"/SvXboxOne"})
public class SvXboxOne extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String consola = "Xbox One";
        
        List<Videojuego> listaVideojuegos = control.traerVideojuegos(consola);
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaVideojuegos", listaVideojuegos);
        
        response.sendRedirect("verVideojuegos.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
