package com.epul.oeuvre.repositories;

import com.epul.oeuvre.domains.InscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends JpaRepository<InscriptionEntity, Integer> {

}

