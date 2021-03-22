package metier;/*
 *@program GenTech
 *@author ziqi tang
 *@date 2021/3/22
 */

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Rayon {
    @Id
    private Integer numCate;
    private String nomCate;
    private Integer idParant;
    private Integer degre;

    @Basic
    @Column(name = "numCate", nullable = true)
    public Integer getNumCate() {
        return numCate;
    }

    public void setNumCate(Integer numCate) {
        this.numCate = numCate;
    }

    @Basic
    @Column(name = "nomCate", nullable = true, length = -1)
    public String getNomCate() {
        return nomCate;
    }

    public void setNomCate(String nomCate) {
        this.nomCate = nomCate;
    }

    @Basic
    @Column(name = "idParant", nullable = true)
    public Integer getIdParant() {
        return idParant;
    }

    public void setIdParant(Integer idParant) {
        this.idParant = idParant;
    }

    @Basic
    @Column(name = "degre", nullable = true)
    public Integer getDegre() {
        return degre;
    }

    public void setDegre(Integer degre) {
        this.degre = degre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rayon rayon = (Rayon) o;
        return Objects.equals(numCate, rayon.numCate) &&
                Objects.equals(nomCate, rayon.nomCate) &&
                Objects.equals(idParant, rayon.idParant) &&
                Objects.equals(degre, rayon.degre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numCate, nomCate, idParant, degre);
    }
}
