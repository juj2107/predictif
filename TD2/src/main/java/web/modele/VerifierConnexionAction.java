/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import metier.modele.Client;
import metier.modele.Consultation;
import metier.modele.Employe;
import metier.service.Service;

/**
 *
 * @author jduprez
 */
public class VerifierConnexionAction extends Action {

    @Override
    public void execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String type = (String)session.getAttribute("type");
        Integer userId = (Integer)session.getAttribute("userId");
        if ("client".equals(type)){
            request.setAttribute("type","client");
            request.setAttribute("id",userId);
        }
        else if ("employe".equals(type)){
            request.setAttribute("type","employe");
            request.setAttribute("id",userId);
        }
        else{
            request.setAttribute("type","null");
            request.setAttribute("id","null");
        }
        
        System.out.println("\n action démarrer consultation côté employé : " );
    }
    
}
