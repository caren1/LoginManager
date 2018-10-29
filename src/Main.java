public class Main {
    public static void main(String[] args) {

        User carenone = new User("Wojt", "Ciemnocki", "carenone", "asdzxc1");
        User blondas94 = new User("Piotr", "Ozio", "blondas94", "zxczxc1");
        User agamisiat = new User("Aga", "Cho", "agamisiat", "qwerty1");
        User efipe = new User("Filip", "Potter", "efipe","arkagdynia1");
        User barte = new User("Bartosz", "E", "","agniecha");

        UserManager userManager = new UserManager();
        LoginManager loginManager = new LoginManager(userManager);
        UserEditorManager userEditorManager = new UserEditorManager(userManager);
        SaveToTextFile save = new SaveToTextFile();

       userEditorManager.registerUser(carenone);
       userEditorManager.registerUser(blondas94);
       userEditorManager.registerUser(agamisiat);
       userEditorManager.registerUser(efipe);
       userEditorManager.registerUser(barte);

       loginManager.logInUser("carenone","asdzxc1");
       loginManager.logInUser("blondas94","zxczxc1");
       loginManager.logInUser("agamisiat", "qwerty1");
       loginManager.logInUser("barte", "agniecha123");

       userEditorManager.deleteUser(carenone);

       loginManager.logInUser("carenone", "ciemniecki1");


    }
}
