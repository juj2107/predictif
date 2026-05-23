/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import metier.modele.Client;
import metier.service.Service;

/**
 *
 * @author jduprez
 */
public class InscriptionAction extends Action {
    @Override
    public void execute(HttpServletRequest request) {
        String dateString = request.getParameter("dateNaissance");
        if (dateString == null || dateString.isBlank()) {
            request.setAttribute("inscription", "date");
            return;
        }
        LocalDate date = LocalDate.parse(dateString);
        String mdp = request.getParameter("mdp");
        String cmdp = request.getParameter("cmdp");
        Client client = new Client(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("adresse"), request.getParameter("mail"), mdp, request.getParameter("tel"), date);
        String resultat = Service.inscrireClient(client); //si adresse pas format adresse marche pas
        System.out.println("inscription " +resultat );
        String message="";
        
//        if (inscription == false) {
//            message = "L'inscription a échoué. Veuillez réessayer ultérieurement. Êtes-vous sûr de ne pas avoir de compte ? L'adresse mail est peut-être déjà utilisée.";
//        }
        if (!mdp.equals(cmdp)) {
            resultat = "mdp";
//            message = "Les mots de passe ne se correspondent pas. Veuillez réessayer.";
        }
        
        
        System.out.println("client " +client );
        
        request.setAttribute("inscription",resultat);
        request.setAttribute("id",client.getId());
        request.setAttribute("message",message);
       
        System.out.println("\n action inscription : " );
    }

    public InscriptionAction() {
    }
    
}
