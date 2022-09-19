package app.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_localite")
public class Localite {
    @Id
    @Column(name = "PK_LOC", nullable = false)
    private Integer id;

    @Column(name = "npa")
    private Integer npa;

    @Column(name = "localite", length = 50)
    private String localite;

    @Column(name = "canton", length = 25)
    private String canton;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNpa() {
        return npa;
    }

    public void setNpa(Integer npa) {
        this.npa = npa;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    @Override
    public String toString() {
        return npa + " " + localite;
    }
}