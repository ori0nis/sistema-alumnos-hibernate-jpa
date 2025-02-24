<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Listado de Alumnos</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/ServletRedireccionar">Agregar</a>
  <table border="1">
    <caption>Listado de Alumnos</caption>
    <tr>
      <th>Alumno ID</th>
      <th>Nombre y apellido</th>
      <th>Domicilio</th>
      <th>Email</th>
      <th>Teléfono</th>
    </tr>
    <c:forEach var="alumno" items="${alumnos}">
      <tr>
        <td>
          <a href="${pageContext.request.contextPath}/ServletModificar?idAlumno=${alumno.idAlumno}">${alumno.idAlumno}</a>
        </td>
        <td>${alumno.nombre} ${alumno.apellido}</td>
        <td>${alumno.domicilio.calle} ${alumno.domicilio.numCalle} ${alumno.domicilio.pais}</td>
        <td>${alumno.contacto.email}</td>
        <td>${alumno.contacto.telefono}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>