package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.MissionEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService implements IMissionService {

    @Autowired
    private MissionRepository uneMissionRepository;

    @Override
    public List<MissionEntity> getTousLesMissions() {
        List<MissionEntity> mesMissions;
        try {
            mesMissions = uneMissionRepository.findAll();
        } catch (Exception e) {
            throw new MonException("get", "Sql", e.getMessage());
        }
        return mesMissions;
    }


    public MissionEntity getUneMissionID(int id) {
        return uneMissionRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

}
