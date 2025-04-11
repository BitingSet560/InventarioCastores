<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Productos</h2>
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
            <th>Estatus</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>
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
                        <input type="number" name="cantidad" placeholder="Cantidad a ingresar" required />
                        <button type="submit" class="btn btn-primary mb-2">Ingresar Stock</button>
                    </form>
                    <form method="post" action="/activarDesactivarProducto">
                        <input type="hidden" name="idProducto" value="${p.id}" />
                        <c:choose>
                            <c:when test="${p.estatus}">
                                <button name="estatus" type="submit" class="btn btn-danger mb-2">Desactivar Producto</button>
                            </c:when>
                            <c:otherwise>
                                <button name="estatus" type="submit" class="btn btn-success mb-2">Activar Producto</button>
                            </c:otherwise>
                        </c:choose>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

