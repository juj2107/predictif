/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web.controleur;

import dao.JpaUtil;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.modele.Action;
import web.modele.AfficherHistoriquePourEmployeAction;
import web.modele.AfficherProfilAstralPourEmployeAction;
import web.modele.CommencerConsultationAction;
import web.modele.ConnexionAction;
import web.modele.ConsulterHistoriqueAction;
import web.modele.ConsulterListeMediumsAction;
import web.modele.ConsulterProfilAstralAction;
import web.modele.DeconnexionAction;
import web.modele.DemarrerConsultationAction;
import web.modele.FairePredictionAction;
import web.modele.InscriptionAction;
import web.modele.RecupererConsultationAction;
import web.modele.TerminerConsultationAction;
import web.modele.VerifierConnexionAction;
import web.modele.VisualiserMediumsAction;
import web.modele.VisualiserStatistiquesAction;
import web.vue.CommencerConsultationSerialisation;
import web.vue.ConnexionSerialisation;
import web.vue.ConsultationSerialisation;
import web.vue.DeconnexionSerialisation;
import web.vue.HistoriqueSerialisation;
import web.vue.InscriptionSerialisation;
import web.vue.ListeMediumSerialisation;
import web.vue.PredictionSerialisation;
import web.vue.ProfilAstralSerialisation;
import web.vue.Serialisation;
import web.vue.StatistiquesSerialisation;
import web.vue.TerminerConsultationSerialisation;
import web.vue.Top5MediumSerialisation;

/**
 *
 * @author jduprez
 */
@WebServlet(name = "ActionServlet", urlPatterns = {"/ActionServlet"})
public class ActionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String todo = request.getParameter("todo");
        System.out.println("Trace : todo = " + todo);
        if (todo.equals("consulter-liste-mediums")){
            Action action = new ConsulterListeMediumsAction();
            action.execute(request);
            Serialisation serialisation = new ListeMediumSerialisation();
            serialisation.appliquer(request, response);
        }
        if (todo.equals("connexion")) {
            Action action = new ConnexionAction();
            action.execute(request);
            Serialisation serialisation = new ConnexionSerialisation();
            serialisation.appliquer(request, response);
        }
        if (todo.equals("afficher-profil")) {
            Action action = new ConsulterProfilAstralAction();
            action.execute(request);
            Serialisation serialisation = new ProfilAstralSerialisation();
            serialisation.appliquer(request, response);
        }
        if (todo.equals("inscription")) {
            Action action = new InscriptionAction();
            action.execute(request);
            Serialisation serialisation = new InscriptionSerialisation();
            serialisation.appliquer(request, response);
        }
        if (todo.equals("consulter-historique")) {
            Action action = new ConsulterHistoriqueAction();
            action.execute(request);
            Serialisation serialisation = new HistoriqueSerialisation();
            serialisation.appliquer(request, response);
        }
        if (todo.equals("commencer-consultation")) {
            Action action = new CommencerConsultationAction();
            action.execute(request);
            Serialisation serialisation = new CommencerConsultationSerialisation();
            serialisation.appliquer(request, response);
        }
        if (todo.equals("afficher-profil-pour-employe")) {
            Action action = new AfficherProfilAstralPourEmployeAction();
            action.execute(request);
            Serialisation serialisation = new ProfilAstralSerialisation();
            serialisation.appliquer(request, response);
        }
        if (todo.equals("afficher-historique-pour-employe")) {
            Action action = new AfficherHistoriquePourEmployeAction();
            action.execute(request);
            Serialisation serialisation = new HistoriqueSerialisation();
            serialisation.appliquer(request, response);
        }
        if (todo.equals("recuperer-consultation")) {
            Action action = new RecupererConsultationAction();
            action.execute(request);
            Serialisation serialisation = new ConsultationSerialisation();
            serialisation.appliquer(request, response);
        }
        if (todo.equals("demarrer-consultation")) {
            Action action = new DemarrerConsultationAction();
            action.execute(request);
            Serialisation serialisation = new ConsultationSerialisation();
            serialisation.appliquer(request, response);
        }
        if (todo.equals("verifier-connexion")) {
            Action action = new VerifierConnexionAction();
            action.execute(request);
            Serialisation serialisation = new ConnexionSerialisation();
            serialisation.appliquer(request, response);
        }
        if (todo.equals("deconnexion")) {
            Action action = new DeconnexionAction();
            action.execute(request);
            Serialisation serialisation = new DeconnexionSerialisation();
            serialisation.appliquer(request, response);
        }
        if (todo.equals("terminer-consultation")) {
            Action action = new TerminerConsultationAction();
            action.execute(request);
            Serialisation serialisation = new TerminerConsultationSerialisation();
            serialisation.appliquer(request, response);
        }
        if (todo.equals("faire-prediction")) {
            Action action = new FairePredictionAction();
            action.execute(request);
            Serialisation serialisation = new PredictionSerialisation();
            serialisation.appliquer(request, response);
        }
        if (todo.equals("visualiser-top-mediums")) {
            Action action = new VisualiserMediumsAction();
            action.execute(request);
            Serialisation serialisation = new Top5MediumSerialisation();
            serialisation.appliquer(request, response);
        }
        if (todo.equals("visualiser-statistiques")) {
            Action action = new VisualiserStatistiquesAction();
            action.execute(request);
            Serialisation serialisation = new StatistiquesSerialisation();
            serialisation.appliquer(request, response);
        }
        
        
        
        
        
        
        
        System.out.println("Trace : response " + response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        JpaUtil.creerFabriquePersistance();
    }

    @Override
    public void destroy() {
        JpaUtil.fermerFabriquePersistance();
        super.destroy(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
