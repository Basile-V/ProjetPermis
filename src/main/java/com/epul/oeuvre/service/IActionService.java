package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.ActionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface IActionService {
    List<ActionEntity> getTousLesActions();

    ActionEntity getUneActionID(int id);

    List<ActionEntity> getActionsByActionId(int idAction);
}