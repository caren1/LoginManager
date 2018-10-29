public class UserEditorManager implements iUserEditorManager {
    private User user;
    private UserManager userManager;

    public UserEditorManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public WhatIsTheResult registerUser(User user) {
        return userManager.registerUser(user);
    }

    @Override
    public WhatIsTheResult deleteUser(User user) {
        return userManager.deleteUser(user);
    }
}
