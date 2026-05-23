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

/**
 *
 * @author jduprez
 */
public class InscriptionSerialisation extends Serialisation {
    
    @Override
    public void appliquer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String inscription = String.valueOf(request.getAttribute("inscription"));
        String id = String.valueOf(request.getAttribute("id"));
        System.out.println("serialisation inscription : "+ inscription);
        JsonObjectBuilder jsonContainer = Json.createObjectBuilder();
        
        jsonContainer.add("id",id);
        jsonContainer.add("inscription",inscription);


        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonContainer.build().toString());
        out.close();
    }

    public InscriptionSerialisation() {
    }
    
    
}
