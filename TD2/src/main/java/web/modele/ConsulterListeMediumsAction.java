/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
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
        List<Medium> listeMedium = Service.recupererListeMediums();
        request.setAttribute("listeMedium",listeMedium);
        System.out.println("\n action liste ddes : " + listeMedium);
    }

    public ConsulterListeMediumsAction() {
    }
    
}
