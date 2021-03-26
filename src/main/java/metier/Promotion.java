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
public class Promotion implements Serializable {
    @Id
    private Integer idPromo;
    private String nomDiscount;
    private String dateDebut;
    private String dateFin;
    private Double reduction;

    @Basic
    @Column(name = "idPromo", nullable = true)
    public Integer getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(Integer idPromo) {
        this.idPromo = idPromo;
    }

    @Basic
    @Column(name = "nomDiscount", nullable = true, length = -1)
    public String getNomDiscount() {
        return nomDiscount;
    }

    public void setNomDiscount(String nomDiscount) {
        this.nomDiscount = nomDiscount;
    }

    @Basic
    @Column(name = "dateDebut", nullable = true, length = -1)
    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Basic
    @Column(name = "dateFin", nullable = true, length = -1)
    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    @Basic
    @Column(name = "reduction", nullable = true, precision = 0)
    public Double getReduction() {
        return reduction;
    }

    public void setReduction(Double reduction) {
        this.reduction = reduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promotion promotion = (Promotion) o;
        return Objects.equals(idPromo, promotion.idPromo) &&
                Objects.equals(nomDiscount, promotion.nomDiscount) &&
                Objects.equals(dateDebut, promotion.dateDebut) &&
                Objects.equals(dateFin, promotion.dateFin) &&
                Objects.equals(reduction, promotion.reduction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPromo, nomDiscount, dateDebut, dateFin, reduction);
    }
}
