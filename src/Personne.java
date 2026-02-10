public abstract class Personne {
    private String prenom;
    private String nom;
    private int dateDeNaissance;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(int dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public Personne() {
        this.prenom = "Ilyas";
        this.dateDeNaissance = 2004;
        this.nom = "El Madni";
    }
    
    public Personne(String prenom, int dateDeNaissance, String nom) {
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.nom = nom;
    }

    public Personne(Personne P) {
        this.prenom = P.prenom;
        this.dateDeNaissance = P.dateDeNaissance;
        this.nom = P.nom;
    }

    public abstract int age();

    @Override
    public String toString() {
        return "Personne [prenom=" + prenom + ", nom=" + nom + ", dateDeNaissance=" + dateDeNaissance + "]";
    }
    
}

