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
public class Creneau implements Serializable {
    @Id
    private String heureRetrait;
    private String description;

    @Basic
    @Column(name = "heureRetrait", nullable = true, length = -1)
    public String getHeureRetrait() {
        return heureRetrait;
    }

    public void setHeureRetrait(String heureRetrait) {
        this.heureRetrait = heureRetrait;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creneau creneau = (Creneau) o;
        return Objects.equals(heureRetrait, creneau.heureRetrait) &&
                Objects.equals(description, creneau.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heureRetrait, description);
    }
}
