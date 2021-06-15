package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.ActionMissionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface IActionMissionService {


    List<ActionMissionEntity> getTousLesActionMissions();

    ActionMissionEntity getUneActionMissionID(int id);
}