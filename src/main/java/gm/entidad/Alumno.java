package gm.entidad;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Alumno implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Integer idAlumno;

    private String nombre;

    private String apellido;

    // Esta clase ya pertenece a una tabla que está relacionada con otras mediante FK en la
    // BD. Implementamos las relaciones específicas que tiene cada valor en la BD. También
    // es buena práctica añadir las columnas relacionadas entre sí:
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id_domicilio")
    // Con esta notación conseguimos que, cuando se modifiquen los datos de Alumno, también se modifiquen los de
    // Domicilio y las demás clases relacionadas:
    @ManyToOne(cascade = CascadeType.ALL)
    // Con esto ya recuperamos objetos completos:
    private Domicilio domicilio;

    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto")
    @ManyToOne(cascade = CascadeType.ALL)
    private Contacto contacto;

    // Con esto conformamos una relación bidireccional, ya que podemos recuperar la info relacionada en
    // entre las diferentes tablas desde ambas entidades:
    @OneToMany(mappedBy = "alumno")
    // Como esto es una lista, se recomienda que esta variable no esté en el método toString():
    private List<Asignacion> asignaciones;

    public Alumno(){}

    public Alumno(Integer idAlumno){
        this.idAlumno = idAlumno;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "idAlumno=" + idAlumno +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", domicilio=" + domicilio +
                ", contacto=" + contacto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(idAlumno, alumno.idAlumno);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idAlumno);
    }
}
