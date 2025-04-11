<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${titulo}" /></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container-fluid">

    <header class="bg-dark text-white p-3 mb-4 justify-content-between d-flex align-items-center">
        <div>
            <h3>
                <a href="/home" class="text-white text-decoration-none">SISTEMA DE INVENTARIO</a>
            </h3>
            <span>Bienvenido, ${usuario.nombre}</span>
        </div>
        <form action="/logout" method="post">
            <button type="submit" class="btn btn-danger">
                Cerrar Sesión
            </button>
        </form>
    </header>

    <jsp:include page="${contenido}" />
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
