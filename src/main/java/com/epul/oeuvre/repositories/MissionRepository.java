package com.epul.oeuvre.repositories;

import com.epul.oeuvre.domains.MissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<MissionEntity, Integer> {
}

