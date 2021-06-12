
package com.epul.oeuvre.controller;

import com.epul.oeuvre.domains.IndicatorEntity;
import com.epul.oeuvre.service.IndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping("/indicator")
@RestController
@CrossOrigin
public class ControllerIndicator {

    @Autowired
    private IndicatorService unIndicatorService;

    @RequestMapping(method = RequestMethod.GET, value = "/getIndicators")
    public ModelAndView getIndicators(HttpServletRequest request) {

        String destinationPage;
        List<IndicatorEntity> mesIndicators;
        try {
            mesIndicators = unIndicatorService.getTousLesIndicators();
            request.setAttribute("mesIndicators", mesIndicators);
            destinationPage = "vues/listerIndicator";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }


    @RequestMapping(value = "/getUnIndicator/{id}\"", method = RequestMethod.GET)
    public IndicatorEntity getIndicatorById(@PathVariable(value = "id") int id) {
        return unIndicatorService.getUnIndicatorID(id);
    }


}

