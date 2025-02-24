package gm.controlador;

import gm.entidad.Alumno;
import gm.entidad.Contacto;
import gm.entidad.Domicilio;
import gm.servicio.ServicioAlumno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/ServletAgregar")
public class ServletAgregar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String calle = request.getParameter("calle");
        String numCalle = request.getParameter("numcalle");
        String pais = request.getParameter("pais");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");

        // Construimos los objetos:
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(calle);
        domicilio.setNumCalle(numCalle);
        domicilio.setPais(pais);

        Contacto contacto = new Contacto();
        contacto.setEmail(email);
        contacto.setTelefono(telefono);

        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);

        // Guardamos el usuario:
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        servicioAlumno.guardarAlumno(alumno);

        // Redireccionamos a inicio:
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}




