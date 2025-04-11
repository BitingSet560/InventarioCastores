<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <h2 >Historial de Movimientos</h2>

    <table class="table table-striped table-bordered mb-1">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Usuario</th>
                <th>Producto</th>
                <th>Movimiento</th>
                <th>Cantidad</th>
                <th>Fecha y hora</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="h" items="${historico}">
            <tr>
                <td>${h.idHistorico}</td>
                <td>${h.usuario}</td>
                <td>${h.producto}</td>
                <td>${h.movimiento}</td>
                <td>${h.cantidad}</td>
                <td>${h.fechaFormateada}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
