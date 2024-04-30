<%@page import="java.util.List"%>
<%@page import="logica.Videojuego"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyInicio.jsp"%>

    <% List<Videojuego> listaVideojuegos = (List) request.getSession().getAttribute("listaVideojuegos"); %>
    <% for(Videojuego vg : listaVideojuegos){ %>
    <!-- Basic Card Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary"><%= vg.getNombre() %></h6>
            </div>
            <div class="card-body">
                <p>Año: <%= vg.getAnio() %></p>
                <p>Genero: <%= vg.getGenero() %></p>
                <iframe width="560" height="315" src="<%= vg.getTrailer() %>" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>        
                <form name="elminar" action="SvEliminar" method="POST">
                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px;">
                        <i class="fas fa-trash-alt"></i> Eliminar
                    </button>
                    <input type="hidden" name="nombre" value="<%= vg.getNombre() %>">
                </form>
            </div>
        </div>
        <br>
    <% } %>
<%@include file="components/bodyFinal.jsp"%>
</html>

