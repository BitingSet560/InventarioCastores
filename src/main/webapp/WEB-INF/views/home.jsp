<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Bienvenido, ${usuario.nombre}</h2>

<form action="/productos" method="get">
    <button class="btn btn-primary mb-2" type="submit">Entradas</button>
</form>

<c:if test="${usuario.idRol == 2}">
    <form action="/salidas" method="get">
        <button class="btn btn-warning mb-2" type="submit">Salidas</button>
    </form>
</c:if>

<c:if test="${usuario.idRol == 1}">
    <form action="/historico" method="get">
        <button class="btn btn-success mb-2" type="submit">Historial</button>
    </form>
</c:if>