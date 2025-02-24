package gm.controlador;

import gm.entidad.Alumno;
import gm.servicio.ServicioAlumno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet
public class ServletModificar extends HttpServlet {

    // Primero cargamos la info del alumno:
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // Recuperamos la info del alumno desde el JSP:
        String idAlumnoString = request.getParameter("idAlumno");
        Integer idAlumno = Integer.parseInt(idAlumnoString);

        // Creamos el objeto de tipo Alumno:
        Alumno alumno = new Alumno();
        alumno.setIdAlumno(idAlumno);

        // Lo buscamos:
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        alumno = servicioAlumno.encontrarAlumno(alumno);

        // Esta vez, guardamos el alumno en una sesión para que cuando se cargue el formulario, sus datos puedan
        // aparecer en los campos. Si no lo guardásemos, no podríamos cargarlos:
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("alumno", alumno);

        // Redireccionamos:
        request.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException{

        ServicioAlumno servicioAlumno = new ServicioAlumno();

        // Revisamos qué botón se ha presionado (Modificar/Eliminar):
        String modificar = request.getParameter("modificar");
        if(modificar != null){ // Si se presiona el botón de modificar, el request adopta ese nombre. Si no, daría null
            // Recuperamos valores del form:
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String calle = request.getParameter("calle");
            String numCalle = request.getParameter("numcalle");
            String pais = request.getParameter("pais");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");

            // Ahora recuperamos el objeto de la sesión, no lo creamos como nuevo:
            HttpSession httpSession = request.getSession();
            Alumno alumno = (Alumno) httpSession.getAttribute("alumno");

            // Colocamos los valores y seteamos aquellos valores que estamos recibiendo del form. Nombre y apellido son
            // atributos directos de Alumno, pero para modificar los objetos anidados primero tenemos que accederlos:
            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setNumCalle(numCalle);
            alumno.getDomicilio().setPais(pais);
            alumno.getContacto().setEmail(email);
            alumno.getContacto().setTelefono(telefono);

            // Guardamos el usuario:
            servicioAlumno.guardarAlumno(alumno);

            // Quitamos el objeto de Alumno para que no se siga propagando (para que no aparezca una vez termine este
            // request):
            request.removeAttribute("alumno");
        } else {
            // Caso de eliminar (para esto vamos a necesitar el idAlumno oculto en el JSP):
            String idAlumnoString = request.getParameter("idAlumno");
            Integer idAlumno = Integer.parseInt(idAlumnoString);
            // Utilizamos el constructor con id para crear un alumno con dicho id. Podemos hacer esto, ya que solo
            // necesitamos el id para poder eliminar un alumno:
            Alumno alumno = new Alumno(idAlumno);
            servicioAlumno.eliminarAlumno(alumno);
        }

        // Redireccionamos:
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
