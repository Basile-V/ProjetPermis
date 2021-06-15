package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.ActionEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActionService implements IActionService {

    @Autowired
    private ActionRepository uneActionRepository;

    @Override
    public List<ActionEntity> getTousLesActions() {
        List<ActionEntity> mesActions;
        try {
            mesActions = uneActionRepository.findAll();
        } catch (Exception e) {
            throw new MonException("Get", "Sql", e.getMessage());
        }
        return mesActions;
    }

    @Override
    public List<ActionEntity> getActionsByActionId(int idAction) {
        List<ActionEntity> actions;
        ArrayList<ActionEntity> result = new ArrayList<>();
        try {
            actions = uneActionRepository.findAll();
        } catch (Exception e) {
            throw new MonException("Get", "Sql", e.getMessage());
        }
        for (ActionEntity action : actions) {
            if (action.getIdAction() == idAction) {
                result.add(action);
            }
        }
        return result;
    }


    public ActionEntity getUneActionID(int id) {
        return uneActionRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

}
