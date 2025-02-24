package gm.servicio;

import gm.DAO.AlumnoDAO;
import gm.entidad.Alumno;
import java.util.List;

public class ServicioAlumno {

    private AlumnoDAO alumnoDAO = new AlumnoDAO();

    public List<Alumno> listarAlumnos(){
        return alumnoDAO.listar();
    }

    public void guardarAlumno(Alumno alumno){
        // Este método también inserta y modifica igual que en Spring, pero para conseguir ese comportamiento tenemos
        // que hacer una validación:
        if(alumno != null && alumno.getIdAlumno() == null){
            alumnoDAO.insertar(alumno);
        } else {
            alumnoDAO.actualizar(alumno);
        }
    }

    public void eliminarAlumno(Alumno alumno){
        alumnoDAO.eliminar(alumno);
    }

    public Alumno encontrarAlumno(Alumno alumno){
        return alumnoDAO.buscarPorId(alumno);
    }
}
