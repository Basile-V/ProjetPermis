package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.ActionEntity;
import com.epul.oeuvre.domains.ActionMissionEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.ActionMissionRepository;
import com.epul.oeuvre.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActionMissionService implements IActionMissionService {

    @Autowired
    private ActionMissionRepository uneActionMissionRepository;

    @Override
    public List<ActionMissionEntity> getTousLesActionMissions() {
        List<ActionMissionEntity> mesActionMissions;
        try {
            mesActionMissions = uneActionMissionRepository.findAll();
        } catch (Exception e) {
            throw new MonException("Get", "Sql", e.getMessage());
        }
        return mesActionMissions;
    }


    public ActionMissionEntity getUneActionMissionID(int id) {
        return uneActionMissionRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }
}
