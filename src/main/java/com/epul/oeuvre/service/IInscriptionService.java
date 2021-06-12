package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.ActionEntity;
import com.epul.oeuvre.domains.InscriptionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface IInscriptionService {

    List<InscriptionEntity> getTousLesInscriptions();

    InscriptionEntity getUneInscriptionID(int id);

}