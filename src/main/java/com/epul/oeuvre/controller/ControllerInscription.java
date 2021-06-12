package com.epul.oeuvre.controller;

import com.epul.oeuvre.domains.InscriptionEntity;
import com.epul.oeuvre.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping("/inscription")
@RestController
@CrossOrigin
public class ControllerInscription {

    @Autowired
    private InscriptionService uneInscriptionService;

    @RequestMapping(method = RequestMethod.GET, value = "/getInscriptions")
    public ModelAndView getInscriptions(HttpServletRequest request) {

        String destinationPage;
        List<InscriptionEntity> mesInscriptions;
        try {
            mesInscriptions = uneInscriptionService.getTousLesInscriptions();
            request.setAttribute("mesInscriptions", mesInscriptions);
            destinationPage = "vues/listerInscription";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }


    @RequestMapping(value = "/getUneInscription/{id}\"", method = RequestMethod.GET)
    public InscriptionEntity getInscriptionById(@PathVariable(value = "id") int id) {
        return uneInscriptionService.getUneInscriptionID(id);

    }




}

