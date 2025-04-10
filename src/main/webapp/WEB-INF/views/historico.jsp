<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Historial de Movimientos</title>
</head>
<body>
<h2>Historial de Movimientos</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Usuario</th>
        <th>Producto</th>
        <th>Movimiento</th>
        <th>Cantidad</th>
        <th>Fecha</th>
    </tr>
    <c:forEach var="h" items="${historico}">
        <tr>
            <td>${h.idHistorico}</td>
            <td>${h.usuario.nombre}</td>
            <td>${h.producto.nombre}</td>
            <td>${h.movimiento.nombre}</td>
            <td>${h.cantidad}</td>
            <td>${h.fecha}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
