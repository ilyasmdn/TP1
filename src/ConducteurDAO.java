import java.sql.*;

public class ConducteurDAO {

    public void ajouter(Conducteur c) throws Exception {

        Connection conn = Configuration.getConnection();

        String sql = "INSERT INTO conducteur VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, Conducteur.getMatricule());
        ps.setString(2, c.getPrenom());
        ps.setString(3, c.getNom());
        ps.setInt(4, c.getDateDeNaissance());
        ps.setInt(5, c.getDatePermis());
        ps.setString(6, c.getTypePermis());

        ps.executeUpdate();

        conn.close();
    }

    public void modifier(int matricule, Conducteur c) throws Exception {

        Connection conn = Configuration.getConnection();

        String sql = "UPDATE conducteur SET prenom=?, nom=?, dateDeNaissance=?, datePermis=?, typePermis=? WHERE matricule=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, c.getPrenom());
        ps.setString(2, c.getNom());
        ps.setInt(3, c.getDateDeNaissance());
        ps.setInt(4, c.getDatePermis());
        ps.setString(5, c.getTypePermis());
        ps.setInt(6, matricule);

        ps.executeUpdate();

        conn.close();
    }

    public void supprimer(int matricule) throws Exception {

        Connection conn = Configuration.getConnection();

        String sql = "DELETE FROM conducteur WHERE matricule=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, matricule);

        ps.executeUpdate();

        conn.close();
    }

    public Conducteur rechercher(int matricule) throws Exception {

        Connection conn = Configuration.getConnection();

        String sql = "SELECT * FROM conducteur WHERE matricule=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, matricule);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Conducteur c = new Conducteur(
                rs.getString("prenom"),
                rs.getInt("dateDeNaissance"),
                rs.getString("nom"),
                rs.getInt("datePermis"),
                rs.getString("typePermis")
            );

            conn.close();
            return c;
        }

        conn.close();
        return null;
    }

    
}
