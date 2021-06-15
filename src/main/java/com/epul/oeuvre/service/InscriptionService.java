package com.epul.oeuvre.service;
import com.epul.oeuvre.domains.InscriptionEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InscriptionService implements IInscriptionService {

    @Autowired
    private InscriptionRepository uneInscriptionRepository;

    @Override
    public List<InscriptionEntity> getTousLesInscriptions() {
        List<InscriptionEntity> mesInscriptions;
        try {
            mesInscriptions = uneInscriptionRepository.findAll();
        } catch (Exception e) {
            throw new MonException("Get", "Sql", e.getMessage());
        }
        return mesInscriptions;
    }


    public InscriptionEntity getUneInscriptionID(int id) {
        return uneInscriptionRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

    public List<InscriptionEntity> getInscriptionByLearnerId(int learnerId) {
        List<InscriptionEntity> inscriptions;
        ArrayList<InscriptionEntity> result = new ArrayList<>();
        try {
            inscriptions = uneInscriptionRepository.findAll();
        } catch (Exception e) {
            throw new MonException("Get", "Sql", e.getMessage());
        }
        for (InscriptionEntity mesInscription : inscriptions) {
            if (mesInscription.getFkLearner() == learnerId) {
                result.add(mesInscription);
            }
        }
        return result;
    }

}
