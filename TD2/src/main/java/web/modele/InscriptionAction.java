/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import metier.modele.Client;
import metier.service.Service;

/**
 *
 * @author jduprez
 */
public class InscriptionAction extends Action {
    @Override
    public void execute(HttpServletRequest request) {
        String dateString = request.getParameter("date");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateString,formatter);
        String mdp = request.getParameter("mdp");
        String cmdp = request.getParameter("cmdp");
        Client client = new Client(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("adresse"), request.getParameter("mail"), mdp, request.getParameter("tel"), date);
        Boolean inscription = Service.inscrireClient(client);
        
        String message="";
        if (!mdp.equals(cmdp)) {
            inscription = false;
            message = "Les mots de passe ne se correspondent pas. Veuillez réessayer.";
        }
        else if (inscription == false) {
            message = "L'inscription a échoué. Veuillez réessayer ultérieurement.";
        }
        
        System.out.println("client " +client );
        
        request.setAttribute("inscription",inscription);
        request.setAttribute("id",client.getId());
        request.setAttribute("message",message);
       
        System.out.println("\n action inscription : " );
    }

    public InscriptionAction() {
    }
    
}
