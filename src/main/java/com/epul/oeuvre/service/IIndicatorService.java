package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.IndicatorEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface IIndicatorService {


    List<IndicatorEntity> getTousLesIndicators();

    IndicatorEntity getUnIndicatorID(int id);

}