import java.sql.Connection;
import java.sql.DriverManager;

public class Configuration {

    public static Connection getConnection() throws Exception {

        String url = "jdbc:mysql://localhost:3306/tp_java";
        String user = "root";
        String password = "";

        return DriverManager.getConnection(url, user, password);
    }
}
