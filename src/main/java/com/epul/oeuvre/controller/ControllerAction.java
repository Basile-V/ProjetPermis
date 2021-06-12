package com.epul.oeuvre.controller;

import com.epul.oeuvre.domains.ActionEntity;
import com.epul.oeuvre.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping("/action")
@RestController
@CrossOrigin
public class ControllerAction {

    @Autowired
    private ActionService uneActionService;

    @RequestMapping(method = RequestMethod.GET, value = "/getActions")
    public ModelAndView getActions(HttpServletRequest request) {

        String destinationPage;
        List<ActionEntity> mesActions;
        try {
            mesActions = uneActionService.getTousLesActions();
            request.setAttribute("mesActions", mesActions);
            destinationPage = "vues/listerAction";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }


    @RequestMapping(value = "/getUneAction/{id}\"", method = RequestMethod.GET)
    public ActionEntity getActionById(@PathVariable(value = "id") int id) {
        return uneActionService.getUneActionID(id);
    }


}

