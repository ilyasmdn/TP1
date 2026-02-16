import java.util.ArrayList;

public class Voiture {
    private int nbPortes;
    private int puissance;
    private int kilometrage;
    private String marque;
    private String type;
    final private ArrayList<Conducteur> listeChauffeurs = new ArrayList<>();

    public int getNbPortes() {
        return nbPortes;
    }

    public void setNbPortes(int nbPortes) {
        this.nbPortes = nbPortes;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public Voiture() {
        this.nbPortes = 4;
        this.puissance = 10;
        this.kilometrage = 0;
        this.marque = "Mercedes";
        this.type = "Test";
    }

    public Voiture(int nbPortes, int puissance, int kilometrage, String marque, String type) {
        this.nbPortes = nbPortes;
        this.puissance = puissance;
        this.kilometrage = kilometrage;
        this.marque = marque;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Voiture [nbPortes=" + nbPortes + ", puissance=" + puissance + ", kilometrage=" + kilometrage
                + ", marque=" + marque + ", type=" + type + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Voiture other = (Voiture) obj;
        if (this.nbPortes != other.nbPortes) {
            return false;
        }
        if (this.puissance != other.puissance) {
            return false;
        }
        if (this.kilometrage != other.kilometrage) {
            return false;
        }
        if (!this.marque.equals(other.marque)) {
            return false;
        }
        return this.type.equals(other.type);
    }

    public ArrayList<Conducteur> getListeChauffeurs() {
        return listeChauffeurs;
    }

    public boolean ajouterChauffeur(Conducteur C) {
        if(C.voitureExiste(this) && chauffeurExiste(C)) return false;
        if (!chauffeurExiste(C)) listeChauffeurs.add(C);
        C.ajouterVoiture(this);
        return true;
    }

    public boolean supprimerChauffeur(Conducteur C) {
        if(!C.voitureExiste(this) && !chauffeurExiste(C)) return false;
        if (chauffeurExiste(C)) listeChauffeurs.remove(C);
        C.supprimerVoiture(this);
        return true;
    }

    public boolean chauffeurExiste(Conducteur C) {
        for (Conducteur Conducteur : listeChauffeurs) {
            if (Conducteur.equals(C)) return true;
        }
        return false;
    }
    
}
