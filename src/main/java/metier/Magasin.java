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
public class Magasin {
    @Id
    private String idMagasin;
    private String libelleMagasin;
    private String adresseMagasin;
    private String cpMagasin;
    private String villeMagasin;

    @Basic
    @Column(name = "idMagasin", nullable = true, length = -1)
    public String getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(String idMagasin) {
        this.idMagasin = idMagasin;
    }

    @Basic
    @Column(name = "libelleMagasin", nullable = true, length = -1)
    public String getLibelleMagasin() {
        return libelleMagasin;
    }

    public void setLibelleMagasin(String libelleMagasin) {
        this.libelleMagasin = libelleMagasin;
    }

    @Basic
    @Column(name = "adresseMagasin", nullable = true, length = -1)
    public String getAdresseMagasin() {
        return adresseMagasin;
    }

    public void setAdresseMagasin(String adresseMagasin) {
        this.adresseMagasin = adresseMagasin;
    }

    @Basic
    @Column(name = "cpMagasin", nullable = true, length = -1)
    public String getCpMagasin() {
        return cpMagasin;
    }

    public void setCpMagasin(String cpMagasin) {
        this.cpMagasin = cpMagasin;
    }

    @Basic
    @Column(name = "villeMagasin", nullable = true, length = -1)
    public String getVilleMagasin() {
        return villeMagasin;
    }

    public void setVilleMagasin(String villeMagasin) {
        this.villeMagasin = villeMagasin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magasin magasin = (Magasin) o;
        return Objects.equals(idMagasin, magasin.idMagasin) &&
                Objects.equals(libelleMagasin, magasin.libelleMagasin) &&
                Objects.equals(adresseMagasin, magasin.adresseMagasin) &&
                Objects.equals(cpMagasin, magasin.cpMagasin) &&
                Objects.equals(villeMagasin, magasin.villeMagasin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMagasin, libelleMagasin, adresseMagasin, cpMagasin, villeMagasin);
    }
}
