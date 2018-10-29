public class User implements Observer {

    private String name;
    private String surname;
    private String login;
    private String password;

    public User(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "{ User:" + "Name & Surname}" + name + " " + surname + " " + "{ Login: " + login + " " + "password: }" + password + "\r\n";
    }

    @Override
    public void update() {

    }
}

