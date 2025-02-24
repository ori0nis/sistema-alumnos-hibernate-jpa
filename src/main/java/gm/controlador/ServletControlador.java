package gm.controlador;

import gm.entidad.Alumno;
import gm.servicio.ServicioAlumno;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        List<Alumno> alumnos = servicioAlumno.listarAlumnos();

        try{
            // Compartimos la info con el JSP:
            request.setAttribute("alumnos", alumnos);
            // Redirigimos a la vista:
            request.getRequestDispatcher("/WEB-INF/listadoAlumnos.jsp").forward(request, response);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
