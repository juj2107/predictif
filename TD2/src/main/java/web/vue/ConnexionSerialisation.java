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
public class ConnexionSerialisation extends Serialisation {

    @Override
    public void appliquer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = (String) request.getAttribute("type");
        String id = (String) request.getAttribute("id").toString();
        System.out.println("serialisation "+ type);
        JsonObjectBuilder jsonContainer = Json.createObjectBuilder();
        if(!"null".equals(type)){
            jsonContainer.add("type",type);
            jsonContainer.add("connexion",true);
            jsonContainer.add("id",id);
        }else{
            jsonContainer.add("type",type);
            jsonContainer.add("connexion",false);
        }


        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonContainer.build().toString());
        out.close();
    }

    public ConnexionSerialisation() {
    }
    
    

}
