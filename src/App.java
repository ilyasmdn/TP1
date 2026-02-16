public class App {

    public static void main(String[] args) {

        try {

            ConducteurDAO conducteurDAO = new ConducteurDAO();
            VoitureDAO voitureDAO = new VoitureDAO();
            ConducteurVoitureDAO relationDAO = new ConducteurVoitureDAO();

            Conducteur c1 = new Conducteur("Ilyas", 2004, "El Madni", 2022, "B");
            conducteurDAO.ajouter(c1);
            
            Conducteur c2 = new Conducteur("Ali", 2000, "Ben Salah", 2020, "C");
            conducteurDAO.ajouter(c2);

            Voiture v1 = new Voiture(4, 110, 50000, "Mercedes", "Classe A");
            voitureDAO.ajouter(v1);
            
            Voiture v2 = new Voiture(2, 90, 20000, "BMW", "Serie 1");
            voitureDAO.ajouter(v2);

            relationDAO.ajouterRelation(1, 1);
            relationDAO.ajouterRelation(1, 2);
            relationDAO.ajouterRelation(2, 1);

            System.out.println("Voitures du conducteur 1 : ");
            for (int idVoiture : relationDAO.getVoituresByConducteur(1)) {
                System.out.println(" - Voiture ID : " + idVoiture);
            }

            System.out.println("\nConducteurs de la voiture 1 : ");
            for (int matricule : relationDAO.getConducteursByVoiture(1)) {
                System.out.println(" - Conducteur matricule : " + matricule);
            }

            relationDAO.supprimerRelation(1, 2);

            System.out.println("\nAprès suppression de la relation c1 <-> v2 :");
            for (int idVoiture : relationDAO.getVoituresByConducteur(1)) {
                System.out.println(" - Voiture ID : " + idVoiture);
            }

            System.out.println("\n===== TEST TERMINÉ AVEC SUCCÈS =====");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
