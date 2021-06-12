package com.epul.oeuvre.repositories;

import com.epul.oeuvre.domains.InscriptionActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionActionRepository extends JpaRepository<InscriptionActionEntity, Integer> {

}

