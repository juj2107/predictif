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
            JsonObjectBuilder jsonClient = Json.createObjectBuilder();
            //jsonMedium.add("id", medium.getId());
            jsonClient.add("nom", client.getNom());
            jsonClient.add("prenom", client.getPrenom());
            jsonClient.add("adresse", client.getAdresse());
            List<String> gps = client.getGps();
            jsonClient.add("longitude", Double.parseDouble(gps.get(0)));
            jsonClient.add("latitude", Double.parseDouble(gps.get(1)));

            jsonListeClients.add(jsonClient);
        }

        jsonContainer.add("clients", jsonListeClients);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.print(jsonContainer.build().toString());
        out.close();
    }
    
}
