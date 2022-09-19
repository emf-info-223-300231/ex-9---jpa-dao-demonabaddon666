package app.beans;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "t_personne")
public class Personne {
    @Id
    @Column(name = "PK_PERS", nullable = false)
    private Integer id;

    @Column(name = "Prenom", length = 100)
    private String prenom;

    @Column(name = "Nom", length = 100)
    private String nom;

    @Column(name = "Date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "No_rue")
    private Integer noRue;

    @Column(name = "Rue", length = 100)
    private String rue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_LOC")
    private Localite fkLoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_DEP")
    private Departement fkDep;

    @Column(name = "Actif")
    private Boolean actif;

    @Column(name = "Salaire", precision = 12, scale = 2)
    private BigDecimal salaire;

    @Column(name = "date_modif", nullable = false)
    @Version
    private Timestamp dateModif;

    @Column(name = "no_modif", nullable = false)
    private Integer noModif;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Integer getNoRue() {
        return noRue;
    }

    public void setNoRue(Integer noRue) {
        this.noRue = noRue;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Localite getFkLoc() {
        return fkLoc;
    }

    public void setFkLoc(Localite fkLoc) {
        this.fkLoc = fkLoc;
    }

    public Departement getFkDep() {
        return fkDep;
    }

    public void setFkDep(Departement fkDep) {
        this.fkDep = fkDep;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public BigDecimal getSalaire() {
        return salaire;
    }

    public void setSalaire(BigDecimal salaire) {
        this.salaire = salaire;
    }

    public Timestamp getDateModif() {
        return dateModif;
    }

    public void setDateModif(Timestamp dateModif) {
        this.dateModif = dateModif;
    }

    public Integer getNoModif() {
        return noModif;
    }

    public void setNoModif(Integer noModif) {
        this.noModif = noModif;
    }

}