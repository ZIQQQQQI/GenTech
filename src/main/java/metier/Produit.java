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
public class Produit implements Serializable {
    @Id
    private Integer codeProduit;
    private String libelleProduit;
    private Double prix;
    private Double prixVente;
    private Integer bio;
    private String nutriScore;
    private Integer categorie;
    private String marque;
    private Integer nbVente;
    private String description;

    @Override
    public String toString() {
        return "Produit{" +
                "codeProduit=" + codeProduit +
                ", libelleProduit='" + libelleProduit + '\'' +
                ", prix=" + prix +
                ", prixVente=" + prixVente +
                ", bio=" + bio +
                ", nutriScore='" + nutriScore + '\'' +
                ", categorie=" + categorie +
                ", marque='" + marque + '\'' +
                ", nbVente=" + nbVente +
                '}';
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
    @Column(name = "libelleProduit", nullable = true, length = -1)
    public String getLibelleProduit() {
        return libelleProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    @Basic
    @Column(name = "prix", nullable = true, precision = 0)
    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }


    @Basic
    @Column(name = "description", nullable = true, precision = 0)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "prixVente", nullable = true, precision = 0)
    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }

    @Basic
    @Column(name = "bio", nullable = true)
    public Integer getBio() {
        return bio;
    }

    public void setBio(Integer bio) {
        this.bio = bio;
    }

    @Basic
    @Column(name = "nutriScore", nullable = true, length = -1)
    public String getNutriScore() {
        return nutriScore;
    }

    public void setNutriScore(String nutriScore) {
        this.nutriScore = nutriScore;
    }

    @Basic
    @Column(name = "categorie", nullable = true)
    public Integer getCategorie() {
        return categorie;
    }

    public void setCategorie(Integer categorie) {
        this.categorie = categorie;
    }

    @Basic
    @Column(name = "marque", nullable = true, length = -1)
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Basic
    @Column(name = "nbVente", nullable = true)
    public Integer getNbVente() {
        return nbVente;
    }

    public void setNbVente(Integer nbVente) {
        this.nbVente = nbVente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return Objects.equals(codeProduit, produit.codeProduit) &&
                Objects.equals(libelleProduit, produit.libelleProduit) &&
                Objects.equals(prix, produit.prix) &&
                Objects.equals(prixVente, produit.prixVente) &&
                Objects.equals(bio, produit.bio) &&
                Objects.equals(nutriScore, produit.nutriScore) &&
                Objects.equals(categorie, produit.categorie) &&
                Objects.equals(marque, produit.marque) &&
                Objects.equals(nbVente, produit.nbVente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeProduit, libelleProduit, prix, prixVente, bio, nutriScore, categorie, marque, nbVente);
    }
}
