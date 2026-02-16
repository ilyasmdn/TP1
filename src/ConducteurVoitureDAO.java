import java.sql.*;
import java.util.ArrayList;

public class ConducteurVoitureDAO {

    public void ajouterRelation(int matricule, int voitureId) throws Exception {

        Connection conn = Configuration.getConnection();

        String sql = "INSERT INTO conducteur_voiture (matricule, voiture_id) VALUES (?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, matricule);
        ps.setInt(2, voitureId);

        ps.executeUpdate();
        conn.close();
    }

    public void supprimerRelation(int matricule, int voitureId) throws Exception {

        Connection conn = Configuration.getConnection();

        String sql = "DELETE FROM conducteur_voiture WHERE matricule=? AND voiture_id=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, matricule);
        ps.setInt(2, voitureId);

        ps.executeUpdate();
        conn.close();
    }

    public boolean relationExiste(int matricule, int voitureId) throws Exception {

        Connection conn = Configuration.getConnection();

        String sql = "SELECT * FROM conducteur_voiture WHERE matricule=? AND voiture_id=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, matricule);
        ps.setInt(2, voitureId);

        ResultSet rs = ps.executeQuery();

        boolean existe = rs.next();

        conn.close();
        return existe;
    }

    public ArrayList<Integer> getVoituresByConducteur(int matricule) throws Exception {

        Connection conn = Configuration.getConnection();

        String sql = "SELECT voiture_id FROM conducteur_voiture WHERE matricule=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, matricule);

        ResultSet rs = ps.executeQuery();

        ArrayList<Integer> liste = new ArrayList<>();

        while (rs.next()) {
            liste.add(rs.getInt("voiture_id"));
        }

        conn.close();
        return liste;
    }

    public ArrayList<Integer> getConducteursByVoiture(int voitureId) throws Exception {

        Connection conn = Configuration.getConnection();

        String sql = "SELECT matricule FROM conducteur_voiture WHERE voiture_id=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, voitureId);

        ResultSet rs = ps.executeQuery();

        ArrayList<Integer> liste = new ArrayList<>();

        while (rs.next()) {
            liste.add(rs.getInt("matricule"));
        }

        conn.close();
        return liste;
    }
}
