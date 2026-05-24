/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package console;

import static console.Predictif_scenario_alice.scenarioAlice;
import static console.Predictif_scenario_camille.scenarioCamille;
import dao.JpaUtil;
import java.util.List;
import java.util.Random;
import metier.modele.Client;
import metier.modele.Consultation;
import metier.modele.Medium;
import metier.service.Service;
import metier.service.ServiceInitialisation;

public class PeuplerConsultations {

    public static void main(String[] args) {

        JpaUtil.creerFabriquePersistance();

        ServiceInitialisation.initialiserClient();
        ServiceInitialisation.initialiserEmploye();
        ServiceInitialisation.initialiserMedium();
        
        scenarioAlice();
        scenarioCamille();
        peuplerConsultations();

        JpaUtil.fermerFabriquePersistance();
    }

    public static void peuplerConsultations() {

        List<Client> clients = Service.recupererListeClients();
        List<Medium> mediums = Service.recupererListeMediums();

        Random random = new Random();

        String[] commentaires = {
            "Le client a vu une aura violette autour de son grille-pain.",
            "Consultation interrompue par un chat très agressif.",
            "Les cartes annoncent un avenir riche en pâtes carbo.",
            "Le médium ressent une énergie liée aux yaourts périmés.",
            "Excellente réceptivité astrale malgré une connexion WiFi faible.",
            "Le client semble hanté par ses partiels.",
            "Présence cosmique détectée dans la cuisine.",
            "Les astres déconseillent fortement les trottinettes électriques.",
            "Boule de cristal légèrement embuée aujourd'hui.",
            "Consultation très intense émotionnellement et astrologiquement.",
            "Le client a posé 14 fois la même question.",
            "Alignement des planètes favorable aux grasses matinées.",
            "Esprit protecteur identifié : probablement un hamster.",
            "Très forte énergie du signe du micro-ondes.",
            "Les cartes prédisent une livraison Amazon imminente.",
            "Le futur sentimental semble contenir beaucoup de raclette.",
            "Connexion spirituelle interrompue par une pub YouTube.",
            "Le médium recommande d’éviter les lasagnes industrielles.",
            "Consultation validée par Saturne.",
            "Une chèvre astrale est apparue durant la séance.",
            "Mars indique une forte probabilité de fatigue existentielle.",
            "Vénus confirme une attirance étrange pour les chips barbecue.",
            "Les astres hésitent entre réussite et sieste prolongée.",
            "Saturne recommande de ne pas répondre à ses mails aujourd’hui.",
            "Alignement cosmique perturbé par une notification Instagram.",
            "Jupiter signale une opportunité de procrastination avancée.",
            "Le client a posé une question que même l’univers a ignorée.",
            "Très forte énergie de confusion générale.",
            "Le client semble douter de tout, y compris de la gravité.",
            "Présence d’un doute existentiel mineur mais persistant.",
            "Le client voulait connaître son avenir, mais a changé d’avis en cours de route.",
            "Le médium a consulté les cartes… puis les a reposées sans explication.",
            "Connexion interrompue par une panne de motivation.",
            "Le médium affirme que ‘ça dépend’.",
            "Lecture interrompue par une vision de son propre repas du soir.",
            "Le médium demande un redémarrage cosmique.",
            "L’avenir semble fortement influencé par la météo de demain.",
            "Une grande décision dépendra du choix du dessert.",
            "Les cartes recommandent de boire de l’eau et de voir après.",
            "Risque élevé de situations gênantes dans les 48 prochaines heures.",
            "Bonne période pour exister tranquillement sans trop réfléchir.",
            "Une chèvre astrale confirme les prédictions.",
            "Le destin a refusé de commenter.",
            "Le futur est en cours de compilation… merci de patienter.",
            "Erreur 404 : vision non trouvée.",
            "L’univers a haussé les épaules."
        };

        for (int i = 0; i < 40; i++) {

            Client client = clients.get(random.nextInt(clients.size()));
            Medium medium = mediums.get(random.nextInt(mediums.size()));

            Consultation consultation =
                    Service.demanderConsultation(client, medium);

            if (consultation != null) {

                // l'employé accepte la consultation
                Service.seMettrePret(consultation.getEmploye());

                // commentaire aléatoire
                String commentaire =
                        commentaires[random.nextInt(commentaires.length)];

                // terminer consultation
                Service.terminerConsultation(
                        consultation,
                        commentaire
                );

                System.out.println(
                    "Consultation créée : "
                    + client.getPrenom()
                    + " avec "
                    + medium.getDenomination()
                );

            } else {
                System.out.println(
                    "Impossible de créer une consultation"
                );
            }
        }
    }
}
