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
public class Panier implements Serializable {
    @Id
    private String emailClient;
    @Id
    private Integer codeProduit;
    private Long quantite;

    @Basic
    @Column(name = "emailClient", nullable = true, length = -1)
    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
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
    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Panier panier = (Panier) o;
        return Objects.equals(emailClient, panier.emailClient) &&
                Objects.equals(codeProduit, panier.codeProduit) &&
                Objects.equals(quantite, panier.quantite);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailClient, codeProduit, quantite);
    }
}
