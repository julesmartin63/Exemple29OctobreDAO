package entity;

import java.util.Objects;

//classe autheur qui va contenir id,
public class Auteur {
    private Integer id;
    private String preNom;
    private String nom;


    public Auteur() {
    }

    public Auteur(String preNom, String nom) {
        this.preNom = preNom;
        this.nom = nom;
    }

    public Auteur(Integer id, String preNom, String nom) {
        this.id = id;
        this.preNom = preNom;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPreNom() {
        return preNom;
    }

    public void setPreNom(String preNom) {
        this.preNom = preNom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "id=" + id +
                ", preNom='" + preNom + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auteur auteur = (Auteur) o;
        return id.equals(auteur.id) && preNom.equals(auteur.preNom) && nom.equals(auteur.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, preNom, nom);
    }

}
