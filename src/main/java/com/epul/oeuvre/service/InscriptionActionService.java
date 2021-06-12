package com.epul.oeuvre.service;
import com.epul.oeuvre.domains.ActionMissionEntity;
import com.epul.oeuvre.domains.InscriptionActionEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.ActionMissionRepository;
import com.epul.oeuvre.repositories.InscriptionActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionActionService implements IInscriptionActionService {

    @Autowired
    private InscriptionActionRepository uneInscriptionActionRepository;

    @Override
    public List<InscriptionActionEntity> getTousLesInscriptionActions() {
        List<InscriptionActionEntity> mesInscriptionActions;
        try {
            mesInscriptionActions = uneInscriptionActionRepository.findAll();
        } catch (Exception e) {
            throw new MonException("Get", "Sql", e.getMessage());
        }
        return mesInscriptionActions;
    }


    public InscriptionActionEntity getUneInscriptionActionID(int id) {
        return uneInscriptionActionRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

}
