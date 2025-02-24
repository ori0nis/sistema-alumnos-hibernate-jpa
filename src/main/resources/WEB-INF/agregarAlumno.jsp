<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Agregar alumno</title>
</head>
<body>
<h1>Agregar alumno</h1>
<form action="${pageContext.request.contextPath}/ServletAgregar" method="post" name="form">
    <label for="nombre">Nombre: </label>
    <input type="text" name="nombre" id="nombre">
    <label for="apellido">Apellido: </label>
    <input type="text" name="apellido" id="apellido">
    <p>Domicilio:</p>
    <label for="calle">Calle: </label>
    <input type="text" name="calle" id="calle">
    <label for="numcalle">Número: </label>
    <input type="text" name="numcalle" id="numcalle">
    <label for="pais">País: </label>
    <input type="text" name="pais" id="pais">
    <p>Datos de contacto:</p>
    <label for="email">Email: </label>
    <input type="email" name="email" id="email">
    <label for="telefono">Teléfono: </label>
    <input type="number" name="telefono" id="telefono">
    <button type="submit" name="agregar">Agregar</button>
</form>
</body>
</html>