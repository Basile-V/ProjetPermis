package com.epul.oeuvre.repositories;

import com.epul.oeuvre.domains.IndicatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicatorRepository extends JpaRepository<IndicatorEntity, Integer> {

}

