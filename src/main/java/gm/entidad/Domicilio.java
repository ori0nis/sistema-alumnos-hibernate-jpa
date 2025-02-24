package gm.entidad;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

    @Entity
    public class Domicilio implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_domicilio")
    private Integer idDomicilio;

    private String calle;

    @Column(name = "num_calle")
    private String numCalle;

    private String pais;

    public Domicilio(){}

    public Domicilio(Integer idDomicilio){
        this.idDomicilio = idDomicilio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumCalle() {
        return numCalle;
    }

    public void setNumCalle(String numCalle) {
        this.numCalle = numCalle;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "idDomicilio=" + idDomicilio +
                ", calle='" + calle + '\'' +
                ", numCalle='" + numCalle + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Domicilio domicilio = (Domicilio) o;
        return Objects.equals(idDomicilio, domicilio.idDomicilio);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idDomicilio);
    }
}
