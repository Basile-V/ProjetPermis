package com.epul.oeuvre.repositories;

import com.epul.oeuvre.domains.ActionMissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionMissionRepository extends JpaRepository<ActionMissionEntity, Integer> {

}

