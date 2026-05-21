/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import metier.modele.Client;
import metier.modele.Employe;
import metier.modele.Medium;
import metier.service.Service;

/**
 *
 * @author jduprez
 */
public class VisualiserStatistiquesAction extends Action {

    @Override
    public void execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String type = (String) session.getAttribute("type");
        if ("employe".equals(type)) {
            List<Medium> mediums = Service.recupererTop5Medium();
            List<Client> clients = Service.recupererTop5Client();
            List<Employe> employes = Service.recupererTopEmployes();
            
            request.setAttribute("mediums", mediums);
            request.setAttribute("clients", clients);
            request.setAttribute("employes", employes);
        }
        System.out.println("\n action visualiser statistiques");
    }

}
