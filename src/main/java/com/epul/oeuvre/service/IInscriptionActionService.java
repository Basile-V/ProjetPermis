package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.InscriptionActionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface IInscriptionActionService {

    List<InscriptionActionEntity> getTousLesInscriptionActions();

    InscriptionActionEntity getUneInscriptionActionID(int id);

}