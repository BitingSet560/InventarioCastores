<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Iniciar sesión</h2>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<form method="post" action="/login">
    <label>Correo:</label>
    <input type="email" name="correo" required /><br/>
    <label>Contraseña:</label>
    <input type="password" name="contrasena" required /><br/>
    <input type="submit" value="Ingresar" />
</form>
