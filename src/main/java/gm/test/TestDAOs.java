package gm.test;

import gm.DAO.*;
import gm.entidad.Curso;

import java.util.List;

public class TestDAOs {

    public static void main(String[] args) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        System.out.println("Alumnos: ");
        // Al mandar esto por consola, vemos que nuestra configuración de todas las clases de
        // entidad permite que nos salga no solo la info de la tabla de alumno, sino también los
        // demás valores asociados al registro Alumno en otras tablas, como por ejemplo, su Domicilio.
        imprimir(alumnoDAO.listar());

        DomicilioDAO domicilioDAO = new DomicilioDAO();
        System.out.println("Domicilio: ");
        imprimir(domicilioDAO.listar());

        ContactoDAO contactoDAO = new ContactoDAO();
        System.out.println("Contacto: ");
        imprimir(contactoDAO.listar());

        CursoDAO cursoDAO = new CursoDAO();
        System.out.println("Curso: ");
        imprimir(cursoDAO.listar());

        AsignacionDAO asignacionDAO = new AsignacionDAO();
        System.out.println("Asignación: ");
        imprimir(asignacionDAO.listar());
    }

    private static void imprimir(List coleccion){
        for(Object o : coleccion){
            System.out.println("Valor: " + o);
        }
    }
}
