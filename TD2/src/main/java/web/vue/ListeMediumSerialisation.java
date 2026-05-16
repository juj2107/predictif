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
import metier.modele.Astrologue;
import metier.modele.Cartomancier;
import metier.modele.Medium;

/**
 *
 * @author jduprez
 */
public class ListeMediumSerialisation extends Serialisation {

    @Override
    public void appliquer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Medium> mediums = (List<Medium>) request.getAttribute("listeMedium");
        Boolean connecte = (Boolean) request.getAttribute("connecte");
        System.out.println("serialisation "+ mediums);
        JsonObjectBuilder jsonContainer = Json.createObjectBuilder();
        
        JsonArrayBuilder jsonListeMediums = Json.createArrayBuilder();

        for (Medium medium : mediums) {
            JsonObjectBuilder jsonMedium = Json.createObjectBuilder();
            //jsonMedium.add("id", medium.getId());
            jsonMedium.add("denomination", medium.getDenomination());
            jsonMedium.add("genre", medium.getGenre());
            jsonMedium.add("presentation", medium.getPresentation());
            jsonMedium.add("id", medium.getId().toString());
            String profession;

            if (medium instanceof Astrologue) {
                profession = "Astrologue";
            }
            else if (medium instanceof Cartomancier) {
                profession = "Cartomancien";
            }
            else {
                profession = "Spirite";
            }
            
            jsonMedium.add("profession", profession);

            jsonListeMediums.add(jsonMedium);
        }

        jsonContainer.add("mediums", jsonListeMediums);
        if (connecte) {
            jsonContainer.add("connecte",true);
        }else {
            jsonContainer.add("connecte",false);
        }
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonContainer.build().toString());
        out.close();
    }

    public ListeMediumSerialisation() {
    }
    
    

}
