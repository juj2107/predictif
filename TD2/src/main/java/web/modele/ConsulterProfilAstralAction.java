/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import metier.modele.Client;
import metier.service.Service;

/**
 *
 * @author jduprez
 */
public class ConsulterProfilAstralAction extends Action {

    public ConsulterProfilAstralAction() {
    }
    
    @Override
    public void execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String type = (String)session.getAttribute("type");
        if (type.equals("client")) {
            Integer id = (Integer)session.getAttribute("userId");
            Client client = Service.recupererClientParId(id);
            request.setAttribute("profil",client.getProfilAstral());
            request.setAttribute("prenom",client.getPrenom());
        }
        
        System.out.println("\n action afficher profil astral : " );
    }
}
