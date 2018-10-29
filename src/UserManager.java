import java.util.*;

public class UserManager implements iLoginManager, iUserEditorManager, Subject {

    private WhatIsTheResult whatIsTheResult;
    private User user;
    private Map<String, User> usersMap = new HashMap<>();
    private SaveToTextFile save = new SaveToTextFile();
    private List<Observer> userManagerObservers = new ArrayList<>();

    public Map<String, User> getUsersMap() {
        return usersMap;
    }

    private boolean isFieldIncorrect(String text) {
        return (text == null) || (text.isEmpty()) || (text == "");
    }

    public WhatIsTheResult logInUser(String login, String password) {

        if (usersMap.containsKey(login) && (usersMap.get(login).getPassword().equals(password))) {
            System.out.println("You have succesfully have logged in! - SUCCSESS" + " " + login);
            return WhatIsTheResult.SUCCSESS;
        } else if (usersMap.containsKey(login) && !usersMap.get(login).getPassword().equals(password)) {
            System.out.println("You have provided wrong password - WRONG_PASSWORD");
            return WhatIsTheResult.WRONG_PASSWORD;
        }
        if (!usersMap.containsKey(login)) {
            System.out.println("You must register first! - USER_DOESNT_EXIST");
            return WhatIsTheResult.USER_DOESNT_EXIST;
        } else {
            System.out.println("You have provided incorrect values - FIELDS_MISSING");
            return WhatIsTheResult.FIELDS_MISSING;
        }
    }

    public WhatIsTheResult registerUser(User user) {
        if (usersMap.containsKey(user.getLogin())) {
            System.out.println("Your login is taken. Please choose other login - USER_ALREADY_EXIST");
            return WhatIsTheResult.USER_ALREADY_EXIST;
        }
        if ((isFieldIncorrect(user.getLogin())) || (isFieldIncorrect(user.getName())) || (isFieldIncorrect(user.getPassword())) || (isFieldIncorrect(user.getSurname()))) {
            System.out.println("You have provided blanks in the fields - FIELDS_MISSING");
            return WhatIsTheResult.FIELDS_MISSING;
        }
        System.out.println("You have succesfully registered! - SUCCSESS " + user.getLogin());
        usersMap.put(user.getLogin(), user);
        save.saveToFile(usersMap);
        userManagerObservers.add(user);
        notifyObservers();
        return WhatIsTheResult.SUCCSESS;
    }

    public WhatIsTheResult deleteUser(User user) {
        if (usersMap.containsKey(user.getLogin())) {
            System.out.println("Please provide the password of the user " + user.getLogin() + " to delete the user.");
            Scanner sc = new Scanner(System.in);
            String pass = sc.nextLine().toLowerCase();
            if (usersMap.get(user.getLogin()).getPassword().equals(pass)) {
                usersMap.remove(user.getLogin());
                System.out.println("You have succesfully deleted the user " + user.getLogin() + " - SUCCSESS");
                return WhatIsTheResult.SUCCSESS;
            } else if (!usersMap.get(user.getLogin()).getPassword().equals(pass)) {
                System.out.println("Deletion error - WRONG_PASSWORD");
                return WhatIsTheResult.WRONG_PASSWORD;
            }
        }
        System.out.println("User doesn't exist - USER_DOESNT_EXIST");
        return WhatIsTheResult.USER_DOESNT_EXIST;
    }

    @Override
    public void unregisterObserver(Observer observer) {
        userManagerObservers.add(observer);
    }

    @Override
    public void registerObserver(Observer observer) {
        userManagerObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        userManagerObservers.forEach(Observer::update);
    }

    public void save() {
        save.saveToFile(usersMap);
        notifyObservers();
    }
}


