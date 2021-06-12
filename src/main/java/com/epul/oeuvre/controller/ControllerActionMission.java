package com.epul.oeuvre.controller;

import com.epul.oeuvre.domains.ActionEntity;
import com.epul.oeuvre.domains.ActionMissionEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.service.ActionMissionService;
import com.epul.oeuvre.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RequestMapping("/action_mission")
@RestController
@CrossOrigin
public class ControllerActionMission {

    @Autowired
    private ActionMissionService uneActionMissionService;

    @RequestMapping(method = RequestMethod.GET, value = "/getActionMissions")
    public ModelAndView getActionMissions(HttpServletRequest request) {
        String destinationPage;
        List<ActionMissionEntity> mesActionMissions;
        try {
            mesActionMissions = uneActionMissionService.getTousLesActionMissions();
            request.setAttribute("mesActionMissions", mesActionMissions);
            destinationPage = "vues/listerActionMission";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }


    @RequestMapping(value = "/getUneActionMission/{id}\"", method = RequestMethod.GET)
    public ActionMissionEntity getActionMissionById(@PathVariable(value = "id") int id) {
        return uneActionMissionService.getUneActionMissionID(id);
    }


}

