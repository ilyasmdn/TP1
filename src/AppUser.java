public class AppUser {

    public static void main(String[] args) {

        try {

            UserDAO dao = new UserDAO();

            User admin = new User("admin", "admin123", 0);
            admin.setAdmin(true);
            dao.ajouter(admin);

            User u1 = new User("ilyas", "pass123", 1);
            dao.ajouter(u1);

            boolean ok = dao.authentifier("ilyas", "pass123");
            System.out.println("Authentification ilyas : " + ok);

            dao.resetPassword(2, "newpass");

            boolean ok2 = dao.authentifier("ilyas", "newpass");
            System.out.println("Authentification après reset : " + ok2);

            System.out.println("===== TEST USER TERMINÉ =====");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
