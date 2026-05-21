/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.vue;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import metier.modele.Client;
import metier.modele.Employe;
import metier.modele.Medium;

/**
 *
 * @author jduprez
 */
public class StatistiquesSerialisation extends Serialisation {

    @Override
    public void appliquer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Medium> mediums = (List<Medium>) request.getAttribute("mediums");
        List<Client> clients = (List<Client>) request.getAttribute("clients");
        List<Object[]> stats = (List<Object[]>) request.getAttribute("statsEmployes");

        System.out.println("serialisation statistiques");
        JsonObjectBuilder jsonContainer = Json.createObjectBuilder();

        // Top 5 Mediums
        JsonArrayBuilder jsonMediums = Json.createArrayBuilder();
        if (mediums != null) {
            for (Medium medium : mediums) {
                JsonObjectBuilder jsonMedium = Json.createObjectBuilder();
                jsonMedium.add("denomination", medium.getDenomination());
                jsonMedium.add("nbConsultations", medium.getNbConsultations());
                jsonMediums.add(jsonMedium);
            }
        }
        jsonContainer.add("mediums", jsonMediums);

        // Top 5 Clients
        JsonArrayBuilder jsonClients = Json.createArrayBuilder();
        if (clients != null) {
            for (Client client : clients) {
                JsonObjectBuilder jsonClient = Json.createObjectBuilder();
                jsonClient.add("prenom", client.getPrenom());
                jsonClient.add("nom", client.getNom());
                jsonClient.add("nbConsultations", client.getNbConsultations());
                jsonClients.add(jsonClient);
            }
        }
        jsonContainer.add("clients", jsonClients);

        // Repartition clients par employes
        JsonArrayBuilder jsonEmployes = Json.createArrayBuilder();
        for (Object[] ligne : stats) {

            Employe e = (Employe) ligne[0];
            Integer nbClients = (Integer) ligne[1];

            JsonObjectBuilder jsonEmploye =
                Json.createObjectBuilder();

            jsonEmploye.add("prenom", e.getPrenom());
            jsonEmploye.add("nom", e.getNom());
            jsonEmploye.add("nbClients", nbClients);

            jsonEmployes.add(jsonEmploye);
        }
        jsonContainer.add("stats", jsonEmployes);

        // Nombre moyen consultations
        Integer totalConsultations = 0;
        Integer nbMediums = 0;
        if (mediums != null) {
            for (Medium medium : mediums) {
                nbMediums += 1;
                totalConsultations += medium.getNbConsultations();
            }
        }
        Integer moyenne = totalConsultations/nbMediums;
        jsonContainer.add("moyenneConsMedium", moyenne);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonContainer.build().toString());
        out.close();
    }

}
