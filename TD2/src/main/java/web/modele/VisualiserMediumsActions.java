/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import metier.modele.Medium;
import metier.service.Service;

/**
 *
 * @author jduprez
 */
public class VisualiserMediumsActions extends Action{

    @Override
    public void execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String type = (String)session.getAttribute("type");
        if ("employe".equals(type)){
            List<Medium> mediums = Service.recupererTop5Medium();
            request.setAttribute("mediums",mediums);
        }
        System.out.println("\n top 5 medium action " ); 
    }
    
}
