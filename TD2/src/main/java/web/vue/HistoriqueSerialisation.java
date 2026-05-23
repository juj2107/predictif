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
import java.time.format.DateTimeFormatter;
import java.util.List;
import metier.modele.Consultation;

/**
 *
 * @author jduprez
 */
public class HistoriqueSerialisation extends Serialisation{

    public HistoriqueSerialisation() {
    }
    
    @Override
    public void appliquer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Consultation> historique = (List<Consultation>) request.getAttribute("historique");
        System.out.println("serialisation "+ historique);
        JsonObjectBuilder jsonContainer = Json.createObjectBuilder();
        
        JsonArrayBuilder jsonHistorique = Json.createArrayBuilder();

        for (Consultation consultation : historique) {
            JsonObjectBuilder jsonConsultation = Json.createObjectBuilder();
            jsonConsultation.add("medium", consultation.getMedium().getDenomination());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            jsonConsultation.add("date", consultation.getDateDebut().format(formatter));
            String commentaire = consultation.getCommentaire();
            if(commentaire != null){
                jsonConsultation.add("commentaire", commentaire);
            }
            else{
                jsonConsultation.add("commentaire", "en cours");
            }

            jsonHistorique.add(jsonConsultation);
        }

        jsonContainer.add("historique", jsonHistorique);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonContainer.build().toString());
        out.close();
    }
}
