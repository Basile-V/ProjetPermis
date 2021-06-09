package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.LearnerEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnerService implements ILearnerService {

    @Autowired
    private LearnerRepository unLearnerRepository;

    @Override
    public List<LearnerEntity> getTousLesLearners() {
        List<LearnerEntity> mesLearners;
        try {
            mesLearners = unLearnerRepository.findAll();
        } catch (Exception e) {
            throw new MonException("Get", "Sql", e.getMessage());
        }
        return mesLearners;
    }


    public LearnerEntity getUnLearnerID(int id) {
        return unLearnerRepository.findById(id).orElseThrow(
                () -> new MonException("Learner", "id", id)
        );
    }

    public void ajouterLearner(LearnerEntity unL) {
        try {
            unLearnerRepository.save(unL);
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
    }

    public void deleteLearner(LearnerEntity unL) {
        try {
            unLearnerRepository.delete(unL);
        } catch (Exception e) {
            throw new MonException("Delete", "Sql", e.getMessage());
        }
    }

    public void updateLearner(LearnerEntity unL) {
        try {
            unLearnerRepository.save(unL);
        } catch (Exception e) {
            throw new MonException("Update", "Sql", e.getMessage());
        }
    }
}
