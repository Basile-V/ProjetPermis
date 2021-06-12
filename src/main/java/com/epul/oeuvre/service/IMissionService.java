package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.MissionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface IMissionService {
    List<MissionEntity> getTousLesMissions();

    MissionEntity getUneMissionID(int id);
}