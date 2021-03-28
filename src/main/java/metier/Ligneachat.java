package metier;/*
 *@program GenTech
 *@author ziqi tang
 *@date 2021/3/22
 */

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Ligneachat implements Serializable {
    @Id
    private String idCdeAchat;
    @Id
    private Integer idProduit;
    private Long qteAchat;
    private Long qteReste;



    @Basic
    @Column(name = "idCdeAchat", nullable = true, length = -1)
    public String getIdCdeAchat() {
        return idCdeAchat;
    }

    public void setIdCdeAchat(String idCdeAchat) {
        this.idCdeAchat = idCdeAchat;
    }

    @Basic
    @Column(name = "idProduit", nullable = true)
    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    @Basic
    @Column(name = "qteAchat", nullable = true)
    public Long getQteAchat() {
        return qteAchat;
    }

    public void setQteAchat(Long qteAchat) {
        this.qteAchat = qteAchat;
    }

    @Basic
    @Column(name = "qteReste", nullable = true)
    public Long getQteReste() {
        return qteReste;
    }

    public void setQteReste(Long qteReste) {
        this.qteReste = qteReste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ligneachat that = (Ligneachat) o;
        return Objects.equals(idCdeAchat, that.idCdeAchat) &&
                Objects.equals(idProduit, that.idProduit) &&
                Objects.equals(qteAchat, that.qteAchat) &&
                Objects.equals(qteReste, that.qteReste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCdeAchat, idProduit, qteAchat, qteReste);
    }
}
