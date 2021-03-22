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
public class Entrepot implements Serializable {
    @Id
    private String idCdeAchat;
    private String dateCdeAchat;
    private String dateCdeArrive;
    private String etatCdeAchat;
    private String idMagasin;

    @Basic
    @Column(name = "idCdeAchat", nullable = true, length = -1)
    public String getIdCdeAchat() {
        return idCdeAchat;
    }

    public void setIdCdeAchat(String idCdeAchat) {
        this.idCdeAchat = idCdeAchat;
    }

    @Basic
    @Column(name = "dateCdeAchat", nullable = true, length = -1)
    public String getDateCdeAchat() {
        return dateCdeAchat;
    }

    public void setDateCdeAchat(String dateCdeAchat) {
        this.dateCdeAchat = dateCdeAchat;
    }

    @Basic
    @Column(name = "dateCdeArrive", nullable = true, length = -1)
    public String getDateCdeArrive() {
        return dateCdeArrive;
    }

    public void setDateCdeArrive(String dateCdeArrive) {
        this.dateCdeArrive = dateCdeArrive;
    }

    @Basic
    @Column(name = "etatCdeAchat", nullable = true, length = -1)
    public String getEtatCdeAchat() {
        return etatCdeAchat;
    }

    public void setEtatCdeAchat(String etatCdeAchat) {
        this.etatCdeAchat = etatCdeAchat;
    }

    @Basic
    @Column(name = "idMagasin", nullable = true, length = -1)
    public String getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(String idMagasin) {
        this.idMagasin = idMagasin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrepot entrepot = (Entrepot) o;
        return Objects.equals(idCdeAchat, entrepot.idCdeAchat) &&
                Objects.equals(dateCdeAchat, entrepot.dateCdeAchat) &&
                Objects.equals(dateCdeArrive, entrepot.dateCdeArrive) &&
                Objects.equals(etatCdeAchat, entrepot.etatCdeAchat) &&
                Objects.equals(idMagasin, entrepot.idMagasin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCdeAchat, dateCdeAchat, dateCdeArrive, etatCdeAchat, idMagasin);
    }
}
