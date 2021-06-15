package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "action", schema = "projetpermis")
public class ActionEntity {
    private int id;
    private Integer fk_action;
    private String wording;
    private Integer score_minimum;
    private ActionEntity actionEntity;

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
    @Column(name = "score_minimum")
    public Integer getScoreMinimum() {
        return score_minimum;
    }

    public void setScoreMinimum(Integer score_minimum) {
        this.score_minimum = score_minimum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionEntity that = (ActionEntity) o;
        return (id == that.id) && Objects.equals(fk_action, that.fk_action) && Objects.equals(wording, that.wording) && Objects.equals(score_minimum, that.score_minimum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fk_action, wording, score_minimum);
    }

    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public ActionEntity getActionEntity() {
        return actionEntity;
    }

    public void setActionEntity(ActionEntity actionEntity) {
        this.actionEntity = actionEntity;
    }
}
