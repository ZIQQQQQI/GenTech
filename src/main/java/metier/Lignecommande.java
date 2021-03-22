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
public class Lignecommande {
    @Id
    private String idCdeCli;
    private Integer codeProduit;
    private Integer quantite;

    @Basic
    @Column(name = "idCdeCli", nullable = true, length = -1)
    public String getIdCdeCli() {
        return idCdeCli;
    }

    public void setIdCdeCli(String idCdeCli) {
        this.idCdeCli = idCdeCli;
    }

    @Basic
    @Column(name = "codeProduit", nullable = true)
    public Integer getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(Integer codeProduit) {
        this.codeProduit = codeProduit;
    }

    @Basic
    @Column(name = "quantite", nullable = true)
    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lignecommande that = (Lignecommande) o;
        return Objects.equals(idCdeCli, that.idCdeCli) &&
                Objects.equals(codeProduit, that.codeProduit) &&
                Objects.equals(quantite, that.quantite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCdeCli, codeProduit, quantite);
    }
}
