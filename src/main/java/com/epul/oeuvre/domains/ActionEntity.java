package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "action", schema = "projetpermis", catalog = "")
public class ActionEntity {
    private int id;
    private Integer fk_action;
    private String wording;
    private Integer scoreMinimum;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    public int getIdAction() {
        return id;
    }

    public void setIdAction(int id) {
        this.id = id;
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
    @Column(name = "wording")
    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    @Basic
    @Column(name = "scoreMinimum")
    public Integer getScoreMinimum() {
        return scoreMinimum;
    }

    public void setScoreMinimum(Integer scoreMinimum) {
        this.scoreMinimum = scoreMinimum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionEntity that = (ActionEntity) o;
        return (id == that.id) && Objects.equals(fk_action, that.fk_action) && Objects.equals(wording, that.wording) && Objects.equals(scoreMinimum, that.scoreMinimum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fk_action, wording, scoreMinimum);
    }

}
