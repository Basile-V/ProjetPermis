package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "indicator", schema = "projetpermis", catalog = "")
public class IndicatorEntity {
    private int id;
    private Integer fk_action;
    private String wording;
    private Integer valueIfCheck;
    private Integer valueIfUnCheck;

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
    @Column(name = "valueIfCheck")
    public Integer getValueIfCheck() {
        return valueIfCheck;
    }

    public void setValueIfCheck(Integer valueIfCheck) {
        this.valueIfCheck = valueIfCheck;
    }

    @Basic
    @Column(name = "valueIfUnCheck")
    public Integer getValueIfUnCheck() {
        return valueIfUnCheck;
    }

    public void setValueIfUnCheck(Integer valueIfUnCheck) {
        this.valueIfUnCheck = valueIfUnCheck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndicatorEntity that = (IndicatorEntity) o;
        return (id == that.id) && Objects.equals(fk_action, that.fk_action) && Objects.equals(wording, that.wording) && Objects.equals(valueIfCheck, that.valueIfCheck) && Objects.equals(valueIfUnCheck, that.valueIfUnCheck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fk_action, wording, valueIfCheck, valueIfUnCheck);
    }
}
