<%-- 
    Document   : altaVideojuegoError
    Created on : 27 ene. 2024, 16:31:59
    Author     : merli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyInicio.jsp"%>

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <img src="marioBros.jpg" alt="alt" width="300"/>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Agregar Videojuego</h1>
                                <p>Nombre, año o género están en blanco</p>
                            </div>
                            <form clas="videogame" action="SvVideojuego" method="POST">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="nombre"
                                            name="nombre" placeholder="Nombre">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="anio"
                                             name="anio" placeholder="Año">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <select type="text" name="consola" id="consola">
                                            <option value="Xbox One">Xbox One</option>
                                            <option value="Nintendo Switch">Nintendo Switch</option>
                                        </select>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user"
                                            id="genero" name="genero" placeholder="Genero">
                                    </div>
                                </div>                                
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="trailer"
                                        name="trailer" placeholder="Link Trailer">
                                </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit"> Guardar </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

<%@include file="components/bodyFinal.jsp"%>
</html>
