/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import metier.modele.Client;
import metier.service.Service;

/**
 *
 * @author jduprez
 */
public class RecupererClientsAction extends Action {

    @Override
    public void execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String type = (String)session.getAttribute("type");
        if ("employe".equals(type)) {
            List<Client> clients = Service.recupererListeClients();
            request.setAttribute("clients", clients);
        }
        
        System.out.println("\n action récupérer clients : " );
    }
    
}
