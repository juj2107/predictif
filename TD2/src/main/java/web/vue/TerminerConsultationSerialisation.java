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
import metier.modele.Consultation;

/**
 *
 * @author jduprez
 */
public class TerminerConsultationSerialisation extends Serialisation{

    @Override
    public void appliquer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Consultation consultation = (Consultation) request.getAttribute("consultation");
        Boolean fini = (Boolean) request.getAttribute("fini");
        System.out.println("serialisation "+ consultation);
        JsonObjectBuilder jsonContainer = Json.createObjectBuilder();
        if (fini == true) {
            jsonContainer.add("fini",true);
        } else {
            jsonContainer.add("fini",false);
        }
        

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonContainer.build().toString());
        out.close();
    }
    
}
