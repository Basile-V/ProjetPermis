package com.epul.oeuvre.service;
import com.epul.oeuvre.domains.IndicatorEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.IndicatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndicatorService implements IIndicatorService {

    @Autowired
    private IndicatorRepository unIndicatorRepository;

    @Override
    public List<IndicatorEntity> getTousLesIndicators() {
        List<IndicatorEntity> mesIndicators;
        try {
            mesIndicators = unIndicatorRepository.findAll();
        } catch (Exception e) {
            throw new MonException("Get", "Sql", e.getMessage());
        }
        return mesIndicators;
    }


    public IndicatorEntity getUnIndicatorID(int id) {
        return unIndicatorRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

}
