public class LoginManager implements iLoginManager {

    private UserManager userManager;

    public LoginManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public WhatIsTheResult logInUser(String login, String password) {
        return userManager.logInUser(login, password);
    }
}
