/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.vue;

import jakarta.json.Json;
import jakarta.json.JsonObjectBuilder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import metier.modele.Client;
import metier.modele.Consultation;

/**
 *
 * @author jduprez
 */
public class ConsultationSerialisation extends Serialisation {

    @Override
    public void appliquer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String enCours = (String) request.getAttribute("consultation en cours");
        JsonObjectBuilder jsonContainer = Json.createObjectBuilder();
        if (enCours.equals("aucune")) {
            System.out.println("serialisation : aucune consultation en cours");
            jsonContainer.add("enCours", "aucune");
        } else {
            Consultation consultation = (Consultation) request.getAttribute("consultation");
            Boolean estPret = (Boolean) request.getAttribute("estPret");
            Client client = (Client) request.getAttribute("client");

            System.out.println("serialisation "+ consultation);

            jsonContainer.add("enCours", "ok");
            jsonContainer.add("medium", consultation.getMedium().getDenomination());
            jsonContainer.add("estPret", estPret);
            jsonContainer.add("nomClient",client.getNom());
            jsonContainer.add("prenomClient",client.getPrenom());
        }
        
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonContainer.build().toString());
        out.close();
    }
    
}
