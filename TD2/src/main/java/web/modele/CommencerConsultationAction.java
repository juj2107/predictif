/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import metier.modele.Consultation;
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
        Consultation consultation = Service.demanderConsultation(client, medium);
    }
    
    
    
}
