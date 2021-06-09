package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.LearnerEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface ILearnerService {
    List<LearnerEntity> getTousLesLearners();

    LearnerEntity getUnLearnerID(int id);
}