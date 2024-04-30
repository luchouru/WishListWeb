<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyInicio.jsp"%>
<form class="console" action="SvConsola" method="POST" >
    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div><img src="img/nintendoDs.jpg" alt="alt" width="420" height="250"/></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Registrar Consola</h1>
                            </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="nombre"
                                        name="nombre" placeholder="Nombre">
                                </div>
                                <button class="btn btn-primary btn-user btn-block" type="submit"> Guardar </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</form>
<%@include file="components/bodyFinal.jsp"%>
</html>
