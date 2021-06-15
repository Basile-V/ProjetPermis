package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "action__mission", schema = "projetpermis")
public class ActionMissionEntity {
    private int fk_action;
    private int fk_mission;
    private int id;
    private ActionEntity actionEntity;
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
    @Column(name = "fk_action")
    public Integer getIdAction() {
        return fk_action;
    }

    public void setIdAction(Integer fk_action) {
        this.fk_action = fk_action;
    }

    @Basic
    @Column(name = "fk_mission")
    public Integer getIdMission() {
        return fk_mission;
    }

    public void setIdMission(Integer fk_mission) {
        this.fk_mission = fk_mission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionMissionEntity that = (ActionMissionEntity) o;
        return Objects.equals(fk_action, that.fk_action) && Objects.equals(fk_mission, that.fk_mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fk_action, fk_mission);
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
