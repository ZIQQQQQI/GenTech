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
public class Commande implements Serializable {
    @Id
    private String idCdeCli;
    private String dateCdeCli;
    private String dateRetrait;
    private String heureRetrait;
    private String etat;
    private String emailClient;

    @Basic
    @Column(name = "idCdeCli", nullable = true, length = -1)
    public String getIdCdeCli() {
        return idCdeCli;
    }

    public void setIdCdeCli(String idCdeCli) {
        this.idCdeCli = idCdeCli;
    }

    @Basic
    @Column(name = "dateCdeCli", nullable = true, length = -1)
    public String getDateCdeCli() {
        return dateCdeCli;
    }

    public void setDateCdeCli(String dateCdeCli) {
        this.dateCdeCli = dateCdeCli;
    }

    @Basic
    @Column(name = "dateRetrait", nullable = true, length = -1)
    public String getDateRetrait() {
        return dateRetrait;
    }

    public void setDateRetrait(String dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    @Basic
    @Column(name = "heureRetrait", nullable = true, length = -1)
    public String getHeureRetrait() {
        return heureRetrait;
    }

    public void setHeureRetrait(String heureRetrait) {
        this.heureRetrait = heureRetrait;
    }

    @Basic
    @Column(name = "etat", nullable = true, length = -1)
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Basic
    @Column(name = "emailClient", nullable = true, length = -1)
    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return Objects.equals(idCdeCli, commande.idCdeCli) &&
                Objects.equals(dateCdeCli, commande.dateCdeCli) &&
                Objects.equals(dateRetrait, commande.dateRetrait) &&
                Objects.equals(heureRetrait, commande.heureRetrait) &&
                Objects.equals(etat, commande.etat) &&
                Objects.equals(emailClient, commande.emailClient);
    }

    @Override
    public String toString() {
        return "Commande{" +
                "idCdeCli='" + idCdeCli + '\'' +
                ", dateCdeCli='" + dateCdeCli + '\'' +
                ", dateRetrait='" + dateRetrait + '\'' +
                ", heureRetrait='" + heureRetrait + '\'' +
                ", etat='" + etat + '\'' +
                ", emailClient='" + emailClient + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCdeCli, dateCdeCli, dateRetrait, heureRetrait, etat, emailClient);
    }
}
