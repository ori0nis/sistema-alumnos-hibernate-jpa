<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Modificar alumno</title>
</head>
<body>
<h1>Modificar alumno</h1>
<form action="${pageContext.request.contextPath}/ServletModificar" method="post" name="form2">
    <input type="hidden" name="idAlumno" value="${alumno.idAlumno}">
    <label for="nombre">Nombre: </label>
    <input type="text" name="nombre" id="nombre" value="${alumno.nombre}">
    <label for="apellido">Apellido: </label>
    <input type="text" name="apellido" id="apellido" value="${alumno.apellido}">
    <p>Domicilio:</p>
    <label for="calle">Calle: </label>
    <input type="text" name="calle" id="calle" value="${alumno.domicilio.calle}">
    <label for="numcalle">Número: </label>
    <input type="text" name="numcalle" id="numcalle" value="${alumno.domicilio.numcalle}">
    <label for="pais">País: </label>
    <input type="text" name="pais" id="pais" value="${alumno.domicilio.pais}">
    <p>Datos de contacto:</p>
    <label for="email">Email: </label>
    <input type="email" name="email" id="email" value="${alumno.contacto.email}">
    <label for="telefono">Teléfono: </label>
    <input type="number" name="telefono" id="telefono" value="${alumno.domicilio.telefono}">
    <button type="submit" name="modificar">Modificar</button>
    <button type="submit" name="eliminar">Eliminar</button>
</form>
</body>
</html>