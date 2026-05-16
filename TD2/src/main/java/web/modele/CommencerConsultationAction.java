/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import metier.modele.Client;
import metier.modele.Consultation;
import metier.modele.Medium;
import metier.service.Service;

/**
 *
 * @author jduprez
 */
public class CommencerConsultationAction extends Action {

    public CommencerConsultationAction() {
    }

    @Override
    public void execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String type = (String)session.getAttribute("type");
        if (type.equals("client")) {
            Integer id = (Integer)session.getAttribute("userId");
            Client client = Service.recupererClientParId(id);
            String idMedium = request.getParameter("medium");
            Medium medium = Service.recupererMediumParId(Integer.valueOf(idMedium));
            Consultation consultation = Service.demanderConsultation(client, medium);
            request.setAttribute("consultation", consultation);
            request.setAttribute("connecte", true);
        } else {
            request.setAttribute("connecte", false);
        }
        
    }
    
    
    
}
