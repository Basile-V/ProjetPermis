package com.epul.oeuvre.controller;

import com.epul.oeuvre.domains.*;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.service.ActionService;
import com.epul.oeuvre.service.InscriptionActionService;
import com.epul.oeuvre.service.InscriptionService;
import com.epul.oeuvre.service.LearnerService;
import com.epul.oeuvre.utilitaires.MonMotPassHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/learner")
@RestController
@CrossOrigin
public class ControllerLearner {

    @Autowired
    private InscriptionService inscriptionService;
    @Autowired
    private ActionService actionService;
    @Autowired
    private LearnerService unLearnerService;
    @Autowired
    private InscriptionActionService inscriptionActionService;

    @RequestMapping(method = RequestMethod.GET, value = "/getLearners")
    public ModelAndView getLearners(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        System.out.println(response);
        String destinationPage = "";
        List<LearnerEntity> mesLearners = null;
        try {
            mesLearners = unLearnerService.getTousLesLearners();
            request.setAttribute("mesLearners", mesLearners);
            System.out.println(mesLearners);
            destinationPage = "vues/listerLearner";
        }  catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }
        catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }


    @GetMapping("/getLearner/{id}")
    public LearnerEntity getLearnerById(@PathVariable(value = "id") int id) {
        LearnerEntity unL = null;
        try {
            unL = unLearnerService.getUnLearnerID(id);
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return unL;
    }

    @RequestMapping(value = "/insererLearner")
    public ModelAndView insererLearner(HttpServletRequest request) {
        String destinationPage = "";
        try {
            LearnerEntity unLearner = new LearnerEntity();
            unLearner.setSurname(request.getParameter("txtnom"));
            unLearner.setForname(request.getParameter("txtprenom"));
            unLearner.setEmail(request.getParameter("email"));
            unLearner.setRole(request.getParameter("txtrole"));
            unLearner.setSalt("144be33f");
            String pwd = request.getParameter("mdp");
            byte[] salt = MonMotPassHash.transformeEnBytes(unLearner.getSalt());
            char[] pwd_char = MonMotPassHash.converttoCharArray(pwd);
            byte[] monpwdCo = MonMotPassHash.generatePasswordHash(pwd_char, salt);
            unLearner.setMdp(MonMotPassHash.bytesToString(monpwdCo));

            unLearnerService.ajouterLearner(unLearner);
            destinationPage = "/index";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }


    @RequestMapping(value = "/ajoutLearner")
    public ModelAndView ajouterLearner(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            destinationPage = "vues/ajouterLearner";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/supprimerLearner/{id}")
    public ModelAndView supprimerLearner(HttpServletRequest request, @PathVariable("id") int id) {
        String destinationPage = "";
        try {
            LearnerEntity unLearner = getLearnerById(id);
            unLearnerService.deleteLearner(unLearner);
            destinationPage = "/index";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/modifier/{id}")
    public ModelAndView modifierLearner(HttpServletRequest request, @PathVariable("id") int id) {
        String destinationPage = "";
        LearnerEntity unLearner = getLearnerById(id);
        try {
            destinationPage = "vues/modifierLearner";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        ModelAndView modelAndView = new ModelAndView(destinationPage);
        modelAndView.addObject("learner", unLearner);
        return modelAndView;
    }

    @RequestMapping(value = "/updateLearner/{id}")
    public ModelAndView updateLearner(HttpServletRequest request, @PathVariable("id") int id) {
        String destinationPage = "";
        try {
            LearnerEntity unLearner = getLearnerById(id);
            unLearner.setSurname(request.getParameter("txtsurname"));
            unLearner.setForname(request.getParameter("txtforname"));
            unLearner.setEmail(request.getParameter("txtemail"));
            unLearner.setRole(request.getParameter("txtrole"));
            String pwd = request.getParameter("txtoldmdp");
            byte[] salt = MonMotPassHash.transformeEnBytes(unLearner.getSalt());
            char[] pwd_char = MonMotPassHash.converttoCharArray(pwd);
            byte[] monpwdCo = MonMotPassHash.generatePasswordHash(pwd_char, salt);
            byte[] mdp_byte = MonMotPassHash.transformeEnBytes(unLearner.getMdp());
            if (!MonMotPassHash.verifyPassword(monpwdCo, mdp_byte)) {
                String message = "mot de passe erron??";
                request.setAttribute("message", message);
                destinationPage = "/index";
            }
            else {
                pwd = request.getParameter("txtnewmdp");
                salt = MonMotPassHash.transformeEnBytes(unLearner.getSalt());
                pwd_char = MonMotPassHash.converttoCharArray(pwd);
                monpwdCo = MonMotPassHash.generatePasswordHash(pwd_char, salt);
                unLearner.setMdp(MonMotPassHash.bytesToString(monpwdCo));
                unLearnerService.updateLearner(unLearner);
                destinationPage = "/index";
            }
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/listerMissions/{id}")
    public ModelAndView getMissions(HttpServletRequest request,  @PathVariable("id") int id) {
        LearnerEntity learner = getLearnerById(id);
        String destinationPage;
        List<InscriptionEntity> inscriptions;
        ArrayList<MissionEntity> missions = new ArrayList<MissionEntity>();
        try {
            inscriptions = inscriptionService.getInscriptionByLearnerId(id);
            for (InscriptionEntity inscriptionEntity : inscriptions) {
                MissionEntity missionEntity = inscriptionEntity.getMissionEntity();
                missions.add(missionEntity);
            }
            request.setAttribute("missions", missions);
            destinationPage = "vues/getMissionsLeaner";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        ModelAndView modelAndView = new ModelAndView(destinationPage);
        modelAndView.addObject("learner", learner);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listerActions/{learnerId}")
    public ModelAndView getActions(HttpServletRequest request,  @PathVariable("learnerId") int learnerId) {
        LearnerEntity learner = getLearnerById(learnerId);
        String destinationPage;
        List<InscriptionEntity> inscriptions;
            inscriptions = inscriptionService.getInscriptionByLearnerId(learnerId);
        ArrayList<InscriptionActionEntity> inscriptionActions = new ArrayList<>();
        ArrayList<ActionEntity> actions = new ArrayList<>();
        try {
            // Actions li??es aux inscriptions -> InscriptionAction
            for (InscriptionEntity inscription : inscriptions) {
                int inscriptionId = inscription.getId();
                List<InscriptionActionEntity> uneInscriptionActionList = inscriptionActionService.getInscriptionActionsByInscriptionId(inscriptionId);
                for (InscriptionActionEntity inscriptionActionEntity : uneInscriptionActionList) {
                    inscriptionActions.add(inscriptionActionEntity);
                }
            }

            // Seulement les Actions
            for (InscriptionActionEntity inscriptionAction : inscriptionActions) {
                int actionId = inscriptionAction.getFkAction();
                List<ActionEntity> actionEntityList = actionService.getActionsByActionId(actionId);
                for (ActionEntity actionEntity : actionEntityList) {
                    actions.add(actionEntity);
                }
            }
            request.setAttribute("actions", actions);
            destinationPage = "vues/getActionsLeaner";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        ModelAndView modelAndView = new ModelAndView(destinationPage);
        modelAndView.addObject("learner", learner);
        return modelAndView;
    }
}
