package metier;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/25
 */

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Enpromo implements Serializable {
    @Id
    private Integer codeProduit;
    @Id
    private Integer idPromo;

    @Basic
    @Column(name = "CodeProduit", nullable = true)
    public Integer getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(Integer codeProduit) {
        this.codeProduit = codeProduit;
    }

    @Basic
    @Column(name = "idPromo", nullable = true)
    public Integer getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(Integer idPromo) {
        this.idPromo = idPromo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enpromo enpromo = (Enpromo) o;
        return Objects.equals(codeProduit, enpromo.codeProduit) &&
                Objects.equals(idPromo, enpromo.idPromo);
    }

    @Override
    public String toString() {
        return "Enpromo{" +
                "codeProduit=" + codeProduit +
                ", idPromo=" + idPromo +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeProduit, idPromo);
    }
}
