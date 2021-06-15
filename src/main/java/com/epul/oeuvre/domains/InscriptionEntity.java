package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "inscription", schema = "projetpermis")
public class InscriptionEntity {
    private int id;
    private Integer fk_learner;
    private Integer fk_mission;
    private Date date;
    private LearnerEntity learnerEntity;
    private MissionEntity missionEntity;

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
    @Column(name = "fk_learner")
    public Integer getFkLearner() {
        return fk_learner;
    }

    public void setFkLearner(Integer fk_learner) {
        this.fk_learner = fk_learner;
    }

    @Basic
    @Column(name = "fk_mission")
    public Integer getFkMission() {
        return fk_mission;
    }

    public void setFkMission(Integer fk_mission) {
        this.fk_mission = fk_mission;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscriptionEntity that = (InscriptionEntity) o;
        return id == that.id && Objects.equals(fk_learner, that.fk_learner) && Objects.equals(fk_mission, that.fk_mission) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fk_learner, fk_mission, date);
    }

    @ManyToOne
    @JoinColumn(name = "fk_learner", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public LearnerEntity getLearnerEntity() {
        return learnerEntity;
    }

    public void setLearnerEntity(LearnerEntity learnerEntity) {
        this.learnerEntity = learnerEntity;
    }

    @ManyToOne
    @JoinColumn(name = "fk_mission", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public MissionEntity getMissionEntity() {
        return missionEntity;
    }

    public void setMissionEntity(MissionEntity missionEntity) {
        this.missionEntity = missionEntity;
    }
}
