package metier;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/30
 */

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "postit", schema = "gentech", catalog = "")
public class Postit {
    @Id
    private int idPost;
    private String libellePost;
    private Integer idProduit;
    private String idListe;
    private Integer quantite;

    @Basic
    @Column(name = "idPost", nullable = false)
    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    @Basic
    @Column(name = "libellePost", nullable = true, length = -1)
    public String getLibellePost() {
        return libellePost;
    }

    public void setLibellePost(String libellePost) {
        this.libellePost = libellePost;
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
    @Column(name = "idListe", nullable = true)
    public String getIdListe() {
        return idListe;
    }

    public void setIdListe(String idListe) {
        this.idListe = idListe;
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
        Postit that = (Postit) o;
        return idPost == that.idPost &&
                Objects.equals(libellePost, that.libellePost) &&
                Objects.equals(idProduit, that.idProduit) &&
                Objects.equals(idListe, that.idListe) &&
                Objects.equals(quantite, that.quantite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPost, libellePost, idProduit, idListe, quantite);
    }
}
