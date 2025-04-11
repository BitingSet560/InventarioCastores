<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="d-flex justify-content-between">
    <h2>Productos</h2>
    <c:if test="${usuario.idRol == 1}">
        <button class="btn btn-success mb-2" data-bs-toggle="modal" data-bs-target="#agregarProductoModal">Agregar Producto</button>
    </c:if>
</div>
<c:if test="${not empty mensaje}">
    <p style="color: green;">${mensaje}</p>
</c:if>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<div class="modal fade" id="agregarProductoModal" tabindex="-1" aria-labelledby="agregarProductoModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="agregarProductoModalLabel">Agregar Nuevo Producto</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form method="post" action="/agregarProducto">
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre del Producto</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre del Producto" required>
                    </div>
                    <div class="mb-3">
                        <label for="cantidad" class="form-label">Cantidad</label>
                        <input type="number" class="form-control" id="cantidad" name="cantidad" placeholder="Cantidad del Producto" required>
                    </div>
                    <button type="submit" class="btn btn-success">Agregar Producto</button>
                </form>
            </div>
        </div>
    </div>
</div>

<table class="table table-striped table-bordered mb-1 mt-2">
    <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Cantidad</th>
            <th>Estatus</th>
            <c:if test="${usuario.idRol == 1}">
                <th>Acciones</th>
            </c:if>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="p" items="${productos}">
            <tr>
                <td>${p.id}</td>
                <td>${p.nombre}</td>
                <td>${p.cantidad}</td>
                <td>
                    <c:choose>
                        <c:when test="${p.estatus}">Activo</c:when>
                        <c:otherwise>Inactivo</c:otherwise>
                    </c:choose>
                </td>
                <c:if test="${usuario.idRol == 1}">
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
                </c:if>
            </tr>
        </c:forEach>
    </tbody>
</table>

