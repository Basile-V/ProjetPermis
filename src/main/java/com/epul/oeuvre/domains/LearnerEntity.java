package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "learner", schema = "projetpermis", catalog = "")
public class LearnerEntity {
    private int id;
    private String surname;
    private String forname;
    private String salt;
    private String email;
    private String mdp;
    private String role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getIdLearner() {
        return id;
    }

    public void setIdLearner(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "forname")
    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String surname) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Basic
    @Column(name = "mdp")
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LearnerEntity that = (LearnerEntity) o;
        return id == that.id && Objects.equals(surname, that.surname) && Objects.equals(forname, that.forname) && Objects.equals(salt, that.salt) && Objects.equals(email, that.email) && Objects.equals(mdp, that.mdp) && Objects.equals(role, that.forname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, forname, salt, email, mdp, forname);
    }

}
