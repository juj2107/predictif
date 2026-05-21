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
import java.util.List;
import metier.modele.Astrologue;
import metier.modele.Cartomancier;
import metier.modele.Client;
import metier.modele.Medium;

/**
 *
 * @author jduprez
 */
public class ListeClientSerialisation extends Serialisation {

    @Override
    public void appliquer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Client> clients = (List<Client>) request.getAttribute("clients");
        JsonObjectBuilder jsonContainer = Json.createObjectBuilder();
        
        JsonArrayBuilder jsonListeClients = Json.createArrayBuilder();

        for (Client client : clients) {
            JsonObjectBuilder jsonMedium = Json.createObjectBuilder();
            //jsonMedium.add("id", medium.getId());
            jsonMedium.add("nom", client.getNom());
            jsonMedium.add("prenom", client.getPrenom());
            jsonMedium.add("adresse", client.getAdresse());
            List<String> gps = client.getGps();
            jsonMedium.add("coordonnees", gps);

            jsonListeClients.add(jsonMedium);
        }

        jsonContainer.add("clients", jsonListeClients);
        
    }
    
}
