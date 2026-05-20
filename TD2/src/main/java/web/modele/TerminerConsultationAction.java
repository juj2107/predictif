/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import metier.modele.Consultation;
import metier.modele.Employe;
import metier.service.Service;

/**
 *
 * @author jduprez
 */
public class TerminerConsultationAction extends Action {
    @Override
    public void execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String commentaire = request.getParameter("commentaire");
        String type = (String)session.getAttribute("type");
        if ("employe".equals(type)) {
            Integer id = (Integer)session.getAttribute("userId");
            Employe employe = Service.recupererEmployeParId(id);
            Consultation consultation = Service.recupererConsultationActuelleEmploye(employe);
            boolean fini = Service.terminerConsultation(consultation,commentaire);         
            request.setAttribute("consultation",consultation);
            request.setAttribute("fini",fini);
        }
        
        System.out.println("\n action terminer consultation " );
    }
    
}
