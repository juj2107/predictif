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
import metier.modele.ProfilAstral;

/**
 *
 * @author jduprez
 */
public class ProfilAstralSerialisation extends Serialisation {

    @Override
    public void appliquer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProfilAstral profil = (ProfilAstral) request.getAttribute("profil");
        String prenom = (String) request.getAttribute("prenom");
        System.out.println("serialisation "+ profil);
        JsonObjectBuilder jsonContainer = Json.createObjectBuilder();
        jsonContainer.add("signeZ", profil.getSigneZodiaque());
        jsonContainer.add("signeC", profil.getSigneChinois());
        jsonContainer.add("couleur", profil.getCouleur());
        jsonContainer.add("animal", profil.getAnimalTotem());
        jsonContainer.add("prenom", prenom);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonContainer.build().toString());
        out.close();
    }

    public ProfilAstralSerialisation() {
    }
    
    
    
}
