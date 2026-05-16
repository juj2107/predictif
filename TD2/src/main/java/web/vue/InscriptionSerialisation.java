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
        String inscription = (String) request.getAttribute("inscription").toString();
        String id = (String) request.getAttribute("id").toString();
        String message = (String) request.getAttribute("message");
        System.out.println("serialisation inscription : "+ inscription);
        JsonObjectBuilder jsonContainer = Json.createObjectBuilder();
        
        jsonContainer.add("id",id);
        jsonContainer.add("inscription",inscription);
        jsonContainer.add("message",message);


        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonContainer.build().toString());
        out.close();
    }

    public InscriptionSerialisation() {
    }
    
    
}
