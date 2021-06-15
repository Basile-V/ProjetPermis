package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "inscription__action", schema = "projetpermis")
public class InscriptionActionEntity {
    private int id;
    private Integer fk_inscription;
    private Integer fk_action;
    private Integer sort;
    private Integer score;
    private ActionEntity actionEntity;
    private InscriptionEntity inscriptionEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "fk_inscription")
    public Integer getFkInscription() {
        return fk_inscription;
    }

    public void setFkInscription(Integer fk_inscription) {
        this.fk_inscription = fk_inscription;
    }

    @Basic
    @Column(name = "fk_action")
    public Integer getFkAction() {
        return fk_action;
    }

    public void setFkAction(Integer fk_action) {
        this.fk_action = fk_action;
    }

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscriptionActionEntity that = (InscriptionActionEntity) o;
        return (id == that.id) && Objects.equals(fk_inscription, that.fk_inscription) && Objects.equals(fk_action, that.fk_action) && Objects.equals(sort, that.sort) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fk_inscription, fk_action, sort, score);
    }


    @ManyToOne
    @JoinColumn(name = "fk_inscription", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public InscriptionEntity getInscriptionEntity() {
        return inscriptionEntity;
    }

    public void setInscriptionEntity(InscriptionEntity inscriptionEntity) {
        this.inscriptionEntity = inscriptionEntity;
    }
}
