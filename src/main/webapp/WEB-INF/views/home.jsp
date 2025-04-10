<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Inicio</title>
</head>
<body>
    <h2>Bienvenido, ${usuario.nombre}</h2>
    <form action="/productos" method="get">
        <button type="submit">Entradas</button>
    </form>

    <c:if test="${usuario.idRol == 2}">
        <form action="/salidas" method="get">
            <button type="submit">Salidas</button>
        </form>
    </c:if>

    <c:if test="${usuario.idRol == 1}">
        <form action="/historico" method="get">
            <button type="submit">Historial</button>
        </form>
    </c:if>
</body>
</html>