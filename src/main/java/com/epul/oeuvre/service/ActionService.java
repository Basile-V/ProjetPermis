package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.ActionEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public ActionEntity getUneActionID(int id) {
        return uneActionRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

}
