public class App {
    public static void main(String[] args) throws Exception {
        Voiture V1 = new Voiture();
        Voiture V2 = new Voiture(4, 20, 1000, "Ford", "Test");
        Conducteur C1 = new Conducteur();

        C1.ajouterVoiture(V1);
        C1.ajouterVoiture(V2);
        
        System.out.println(C1);
        System.out.println(C1.getListeVoitures() + "\n--------------------------------");
        System.out.println(V1);
        System.out.println(V1.getListeChauffeurs() + "\n--------------------------------");
        System.out.println(V2);
        System.out.println(V2.getListeChauffeurs() + "\n--------------------------------");
    }
}
