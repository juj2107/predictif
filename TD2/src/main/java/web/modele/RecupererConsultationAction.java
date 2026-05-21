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
public class RecupererConsultationAction extends Action {

    @Override
    public void execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String type = (String)session.getAttribute("type");
        if ("employe".equals(type)) {
            Integer id = (Integer)session.getAttribute("userId");
            Employe employe = Service.recupererEmployeParId(id);
            Consultation consultation = Service.recupererConsultationActuelleEmploye(employe);
            request.setAttribute("client", consultation.getClient());
            request.setAttribute("consultation",consultation);
            request.setAttribute("estPret",false);
        }
        
        System.out.println("\n action récupérer consultation de l'employé connecté : " );
    }
    
}
