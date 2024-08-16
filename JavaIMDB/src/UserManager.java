import java.io.*;
import java.util.*;

public class UserManager {
    private static final String USERS_FILE = "users.txt";

    public static void initialize() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USERS_FILE, true))) {
            File file = new File(USERS_FILE);
            if (file.length() == 0) {
                writer.println("ada;b3");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean authenticate(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void registerUser(String username, String password) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USERS_FILE, true))) {
            writer.println(username + ";" + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
