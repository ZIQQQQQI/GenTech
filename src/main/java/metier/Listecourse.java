package metier;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/30
 */

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "listecourse", schema = "gentech", catalog = "")
public class Listecourse {
    @Id
    private String idListe;
    private String libelleListe;
    private String emailClient;
    private String datecree;

    @Basic
    @Column(name = "idListe", nullable = true, length = -1)
    public String getIdListe() {
        return idListe;
    }

    public void setIdListe(String idListe) {
        this.idListe = idListe;
    }

    @Basic
    @Column(name = "libelleListe", nullable = true, length = -1)
    public String getLibelleListe() {
        return libelleListe;
    }

    public void setLibelleListe(String libelleListe) {
        this.libelleListe = libelleListe;
    }

    @Basic
    @Column(name = "emailClient", nullable = true, length = -1)
    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    @Basic
    @Column(name = "datecree", nullable = true, length = -1)
    public String getDatecree() {
        return datecree;
    }

    public void setDatecree(String datecree) {
        this.datecree = datecree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Listecourse that = (Listecourse) o;
        return Objects.equals(idListe, that.idListe) &&
                Objects.equals(libelleListe, that.libelleListe) &&
                Objects.equals(emailClient, that.emailClient) &&
                Objects.equals(datecree, that.datecree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idListe, libelleListe, emailClient, datecree);
    }
}
