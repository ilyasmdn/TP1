import java.sql.*;

public class UserDAO {

    public void ajouter(User user) throws Exception {

        Connection conn = Configuration.getConnection();

        String check = "SELECT isAdmin FROM user WHERE idUser=?";
        PreparedStatement psCheck = conn.prepareStatement(check);
        psCheck.setInt(1, user.getIdAdmin());

        ResultSet rs = psCheck.executeQuery();

        if (rs.next()) {
            if (!rs.getBoolean("isAdmin")) {
                throw new Exception("Erreur : idAdmin n'est pas administrateur !");
            }
        }

        String sql = "INSERT INTO user(login, pass, isAdmin, idAdmin) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getLogin());
        ps.setString(2, user.getPassword());
        ps.setBoolean(3, user.isAdmin());
        ps.setInt(4, user.getIdAdmin());

        ps.executeUpdate();
        conn.close();
    }

    // Authentification
    public boolean authentifier(String login, String password) throws Exception {

        Connection conn = Configuration.getConnection();

        String sql = "SELECT * FROM user WHERE login=? AND pass=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, login);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        boolean ok = rs.next();

        conn.close();
        return ok;
    }

    // Reset password
    public void resetPassword(int idUser, String newPass) throws Exception {

        Connection conn = Configuration.getConnection();

        String sql = "UPDATE user SET pass=? WHERE idUser=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, newPass);
        ps.setInt(2, idUser);

        ps.executeUpdate();
        conn.close();
    }

    // Rechercher user
    public User rechercher(int idUser) throws Exception {

        Connection conn = Configuration.getConnection();

        String sql = "SELECT * FROM user WHERE idUser=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idUser);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            User u = new User();
            u.setLogin(rs.getString("login"));
            u.setPassword(rs.getString("pass"));
            u.setAdmin(rs.getBoolean("isAdmin"));
            u.setIdAdmin(rs.getInt("idAdmin"));
            conn.close();
            return u;
        }

        conn.close();
        return null;
    }
}
