<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Salida de productos</h2>
<c:if test="${not empty mensaje}">
    <p style="color: green;">${mensaje}</p>
</c:if>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<table class="table table-striped table-bordered mb-1">
    <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Cantidad</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${productos}">
        <tr>
            <td>${p.id}</td>
            <td>${p.nombre}</td>
            <td>${p.cantidad}</td>
            <td>
                <form method="post" action="/restarStock">
                    <input type="hidden" name="idProducto" value="${p.id}" />
                    Cantidad a sacar: <input type="number" name="cantidad" required />
                    <button type="submit" class="btn btn-primary mb-2">Sacar Stock</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
