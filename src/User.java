public class User {

    private static int idUser;
    private String login;
    private String password;
    private int idAdmin;
    private boolean isAdmin;

    public User() {
        idUser++;
        this.login = "login";
        this.password = "password";
        this.isAdmin = false;
        this.idAdmin = 1;
    }

    public User(String login, String password, int idAdmin) {
        idUser++;
        this.login = login;
        this.password = password;
        this.isAdmin = false;
        this.idAdmin = idAdmin;
    }

    public int getIdUser() {
        return idUser;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
        this.idAdmin = 0;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

    public boolean authentification(String login, String password) {
        return this.login.equals(login) && this.password.equals(password);
    }

    public void resetPassword(String newPassword) {
        this.password = newPassword;
    }
}
