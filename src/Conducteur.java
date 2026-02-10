import java.time.Year;
import java.util.ArrayList;

public class Conducteur extends Personne {
    private int datePermis;
    private String typePermis;
    private static int matricule;
    final private ArrayList<Voiture> listeVoitures = new ArrayList<>();

    @Override
    public int age() {
        return (Year.now().getValue() - getDateDeNaissance());
    }

    public int getDatePermis() {
        return datePermis;
    }

    public void setDatePermis(int datePermis) {
        this.datePermis = datePermis;
    }

    public String getTypePermis() {
        return typePermis;
    }

    public void setTypePermis(String typePermis) {
        this.typePermis = typePermis;
    }

    public static int getMatricule() {
        return matricule;
    }
    
    public Conducteur() {
        this.datePermis = 2024;
        this.typePermis = "A";
        matricule++;
    }

    public Conducteur(String prenom, int dateDeNaissance, String nom, int datePermis, String typePermis) {
        super(prenom, dateDeNaissance, nom);
        this.datePermis = datePermis;
        this.typePermis = typePermis;
        matricule++;
    }

    public Conducteur(Conducteur C) {
        super(C);
        this.datePermis = C.datePermis;
        this.typePermis = C.typePermis;
        matricule++;
    }

    public ArrayList<Voiture> getListeVoitures() {
        return listeVoitures;
    }
    
    @Override
    public String toString() {
        return "Conducteur [prenom=" + getPrenom() + ", nom=" + getNom() + ", datePermis=" + datePermis + ", dateDeNaissance="
                + getDateDeNaissance() + ", typePermis=" + typePermis + ", age()=" + age() + "]";
    }

    public boolean ajouterVoiture(Voiture V) {
        if (voitureExiste(V) && V.chauffeurExiste(this)) return false;
        if (!voitureExiste(V)) listeVoitures.add(V);
        V.ajouterChauffeur(this);
        return true;
    }

    public boolean supprimerVoiture(Voiture V) {
        if (!voitureExiste(V) && !V.chauffeurExiste(this)) return false;
        if (voitureExiste(V)) listeVoitures.remove(V);
        V.supprimerChauffeur(this);
        return true;
    }

    public boolean voitureExiste(Voiture V) {
        for (Voiture Voiture : listeVoitures) {
            if (Voiture.equals(V)) return true;
        }
        return false;
    }


}
