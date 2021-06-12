package com.epul.oeuvre.controller;

import com.epul.oeuvre.domains.InscriptionActionEntity;
import com.epul.oeuvre.service.InscriptionActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping("/inscription_action")
@RestController
@CrossOrigin
public class ControllerInscriptionAction {

    @Autowired
    private InscriptionActionService uneInscriptionActionService;

    @RequestMapping(method = RequestMethod.GET, value = "/getInscriptionActions")
    public ModelAndView getInscriptionActions(HttpServletRequest request) {

        String destinationPage;
        List<InscriptionActionEntity> mesInscriptionActions;
        try {
            mesInscriptionActions = uneInscriptionActionService.getTousLesInscriptionActions();
            request.setAttribute("mesInscriptionActions", mesInscriptionActions);
            destinationPage = "vues/listerInscriptionAction";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }


    @RequestMapping(value = "/getUneInscriptionAction/{id}\"", method = RequestMethod.GET)
    public InscriptionActionEntity getInscriptionActionById(@PathVariable(value = "id") int id) {
        return uneInscriptionActionService.getUneInscriptionActionID(id);
    }




}

