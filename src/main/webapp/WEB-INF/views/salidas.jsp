<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Salida de Productos</title>
</head>
<body>
    <h2>Productos</h2>
<c:if test="${not empty mensaje}">
    <p style="color: green;">${mensaje}</p>
</c:if>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Cantidad</th>
        <th>Estatus</th>
        <th>Acciones</th>
    </tr>
    <c:forEach var="p" items="${productos}">
        <tr>
            <td>${p.id}</td>
            <td>${p.nombre}</td>
            <td>${p.cantidad}</td>
            <td><c:choose>
                    <c:when test="${p.estatus}">Activo</c:when>
                    <c:otherwise>Inactivo</c:otherwise>
                </c:choose>
            </td>
            <td>
                <form method="post" action="/agregarStock">
                    <input type="hidden" name="idProducto" value="${p.id}" />
                    Cantidad a agregar: <input type="number" name="cantidad" required /><br/>
                    <button type="submit">Agregar Stock</button>
                </form>
                <form method="post" action="/activarDesactivarProducto">
                    <input type="hidden" name="idProducto" value="${p.id}" />
                    <c:choose>
                        <c:when test="${p.estatus}">
                            <button name="estatus" type="submit">Desactivar Producto</button>
                        </c:when>
                        <c:otherwise>
                            <button name="estatus" type="submit">Activar Producto</button>
                        </c:otherwise>
                    </c:choose>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>