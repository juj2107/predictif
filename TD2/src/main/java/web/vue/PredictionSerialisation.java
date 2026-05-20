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
import java.math.BigDecimal;
import java.util.List;
import metier.modele.Astrologue;
import metier.modele.Cartomancier;
import metier.modele.Client;
import metier.modele.Consultation;
import metier.modele.Medium;

/**
 *
 * @author jduprez
 */
public class PredictionSerialisation extends Serialisation{

    @Override
    public void appliquer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Client client = (Client) request.getAttribute("client");
        List<String> predictions = (List<String>) request.getAttribute("predictions");
        System.out.println("serialisation "+ client);
        JsonObjectBuilder jsonContainer = Json.createObjectBuilder();
        JsonArrayBuilder jsonListePredictions = Json.createArrayBuilder();

        for (String prediction : predictions) {
            JsonObjectBuilder jsonPrediction = Json.createObjectBuilder();
            jsonPrediction.add("prediction", prediction);

            jsonListePredictions.add(jsonPrediction);
        }
        jsonContainer.add("predictions", jsonListePredictions);
        jsonContainer.add("nomClient", client.getNom());
        jsonContainer.add("prenomClient", client.getPrenom());
        
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonContainer.build().toString());
        out.close();
    }
    
}
