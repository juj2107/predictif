/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import metier.modele.Client;
import metier.modele.Employe;
import metier.service.Service;

/**
 *
 * @author jduprez
 */
public class ConnexionAction extends Action {

    @Override
    public void execute(HttpServletRequest request) {
        Client client = Service.authentifierClient(request.getParameter("login"),request.getParameter("password"));
        System.out.println("client " +client );
        if (client != null){
            request.setAttribute("type","client");
            request.setAttribute("id",client.getId());
            HttpSession session = request.getSession();
            session.setAttribute("type","client");
            session.setAttribute("userId",client.getId());
        }
        else{
            Employe employe = Service.authentifierEmploye(request.getParameter("login"),request.getParameter("password"));
            System.out.println("employe " +employe );
            if(employe != null){
                request.setAttribute("type","employe");
                request.setAttribute("id",employe.getId());
                HttpSession session = request.getSession();
                session.setAttribute("type","employe");
                session.setAttribute("userId",employe.getId());
            }else{
                request.setAttribute("type","null");
                request.setAttribute("id","null");
            }
        }
        
        System.out.println("\n action connexion : " );
    }

    public ConnexionAction() {
    }
    
}