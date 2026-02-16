import java.sql.*;

public class VoitureDAO {

    public void ajouter(Voiture v) throws Exception {

    Connection conn = Configuration.getConnection();

    String sql = "INSERT INTO voiture(nbPortes, puissance, kilometrage, marque, type) VALUES (?, ?, ?, ?, ?)";

    PreparedStatement ps = conn.prepareStatement(sql);

    ps.setInt(1, v.getNbPortes());
    ps.setInt(2, v.getPuissance());
    ps.setInt(3, v.getKilometrage());
    ps.setString(4, v.getMarque());
    ps.setString(5, v.getType());

    ps.executeUpdate();
    conn.close();
}

    public void modifier(int id, Voiture v) throws Exception {

        Connection conn = Configuration.getConnection();

        String sql = "UPDATE voiture SET nbPortes=?, puissance=?, kilometrage=?, marque=?, type=? WHERE id=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, v.getNbPortes());
        ps.setInt(2, v.getPuissance());
        ps.setInt(3, v.getKilometrage());
        ps.setString(4, v.getMarque());
        ps.setString(5, v.getType());
        ps.setInt(6, id);

        ps.executeUpdate();
        conn.close();
    }

    public void supprimer(int id) throws Exception {

        Connection conn = Configuration.getConnection();

        String sql = "DELETE FROM voiture WHERE id=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ps.executeUpdate();
        conn.close();
    }

    public Voiture rechercher(int id) throws Exception {

        Connection conn = Configuration.getConnection();

        String sql = "SELECT * FROM voiture WHERE id=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Voiture v = new Voiture(
                rs.getInt("nbPortes"),
                rs.getInt("puissance"),
                rs.getInt("kilometrage"),
                rs.getString("marque"),
                rs.getString("type")
            );

            conn.close();
            return v;
        }

        conn.close();
        return null;
    }

    

}
