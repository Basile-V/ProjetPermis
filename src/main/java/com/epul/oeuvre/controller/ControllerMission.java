package com.epul.oeuvre.controller;


import com.epul.oeuvre.domains.MissionEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping("/mission")
@RestController
@CrossOrigin
public class ControllerMission {

    @Autowired
    private MissionService uneMissionService;

    @RequestMapping(method = RequestMethod.GET, value = "/getMissions")
    public ModelAndView getMissions(HttpServletRequest request) {

        String destinationPage;
        List<MissionEntity> mesMissions;
        try {
            mesMissions = uneMissionService.getTousLesMissions();
            request.setAttribute("mesMissions", mesMissions);
            destinationPage = "vues/listerMission";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }
        catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }


    @RequestMapping(value = "/getUneMission/{id}\"", method = RequestMethod.GET)
    public MissionEntity getMissionById(@PathVariable(value = "id") int id) {
        return uneMissionService.getUneMissionID(id);
    }


}

