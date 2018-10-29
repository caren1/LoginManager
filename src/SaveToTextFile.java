import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveToTextFile implements Observer {

    private UserManager userManager;
    private static String filePath = "C:\\Users\\Wojt\\Documents\\LogInZadanie\\LogIn.txt";

    public SaveToTextFile() {

    }

    public static String getFilePath() {
        return filePath;
    }

    public void saveToFile(Map<String, User> map) {
        try (PrintWriter out = new PrintWriter(filePath)) {
            out.print(map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        saveToFile(userManager.getUsersMap());
    }
}

