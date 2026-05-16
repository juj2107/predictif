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
public class ConsulterListeMediumsAction extends Action {

    @Override
    public void execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String type = (String)session.getAttribute("type");
        Boolean connecte;
        connecte = type != null;
        
        List<Medium> listeMedium = Service.recupererListeMediums();
        request.setAttribute("listeMedium",listeMedium);
        System.out.println("\n action liste mediums : " + listeMedium);
        
        if (connecte) {
            request.setAttribute("connecte",true);
        }
        else {
            request.setAttribute("connecte",false);
        }
    }

    public ConsulterListeMediumsAction() {
    }
    
}
