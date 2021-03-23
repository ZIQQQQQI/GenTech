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
public class Client implements Serializable {
    @Id
    private String emailClient;
    private String nomClient;
    private String prenomClient;
    private String mdpClient;
    private String telClient;

    @Basic
    @Column(name = "emailClient", nullable = true, length = -1)
    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    @Basic
    @Column(name = "nomClient", nullable = true, length = -1)
    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    @Basic
    @Column(name = "prenomClient", nullable = true, length = -1)
    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    @Basic
    @Column(name = "mdpClient", nullable = true, length = -1)
    public String getMdpClient() {
        return mdpClient;
    }

    public void setMdpClient(String mdpClient) {
        this.mdpClient = mdpClient;
    }

    @Basic
    @Column(name = "telClient", nullable = true, length = -1)
    public String getTelClient() {
        return telClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(emailClient, client.emailClient) &&
                Objects.equals(nomClient, client.nomClient) &&
                Objects.equals(prenomClient, client.prenomClient) &&
                Objects.equals(mdpClient, client.mdpClient) &&
                Objects.equals(telClient, client.telClient);
    }

    @Override
    public String toString() {
        return "Client{" +
                "emailClient='" + emailClient + '\'' +
                ", nomClient='" + nomClient + '\'' +
                ", prenomClient='" + prenomClient + '\'' +
                ", mdpClient='" + mdpClient + '\'' +
                ", telClient='" + telClient + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailClient, nomClient, prenomClient, mdpClient, telClient);
    }
}
