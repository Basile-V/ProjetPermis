package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "indicator", schema = "projetpermis")
public class IndicatorEntity {
    private int id;
    private Integer fk_action;
    private String wording;
    private Integer value_if_check;
    private Integer value_if_uncheck;
    private ActionEntity actionEntity;

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
    @Column(name = "value_if_check")
    public Integer getValueIfCheck() {
        return value_if_check;
    }

    public void setValueIfCheck(Integer value_if_check) {
        this.value_if_check = value_if_check;
    }

    @Basic
    @Column(name = "value_if_un_check")
    public Integer getValueIfUnCheck() {
        return value_if_uncheck;
    }

    public void setValueIfUnCheck(Integer value_if_uncheck) {
        this.value_if_uncheck = value_if_uncheck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndicatorEntity that = (IndicatorEntity) o;
        return (id == that.id) && Objects.equals(fk_action, that.fk_action) && Objects.equals(wording, that.wording) && Objects.equals(value_if_check, that.value_if_check) && Objects.equals(value_if_uncheck, that.value_if_uncheck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fk_action, wording, value_if_check, value_if_uncheck);
    }
}
