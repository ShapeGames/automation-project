package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Level;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class UserUtils {

    Map<String, User> users;

    public UserUtils() {
        try {
            Gson gson = new Gson();
            users = gson.fromJson(new FileReader("/Users/artismocans/Documents/projects/betSafe-appium-tests/src/test/resources/userData.json"), new TypeToken<Map<String, User>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUser(String desiredUser) {
        return users.get(desiredUser);
    }
    public String getFirstNameForUser(String desiredUser) {
        CustomLogger.log.setLevel(Level.INFO);
        CustomLogger.log.info("Users: " + desiredUser + " First name: " + users.get(desiredUser).getFirstName());
        return users.get(desiredUser).getFirstName();
    }

    public String getMiddleNameForUser(String desiredUser) {
        CustomLogger.log.setLevel(Level.INFO);
        CustomLogger.log.info("Users: " + desiredUser + " Middle name: " + users.get(desiredUser).getMiddleName());
        return users.get(desiredUser).getMiddleName();
    }

    public String getLastNameForUser(String desiredUser) {
        CustomLogger.log.setLevel(Level.INFO);
        CustomLogger.log.info("Users: " + desiredUser + " Last name: " + users.get(desiredUser).getLastName());
        return users.get(desiredUser).getLastName();
    }

    public String getGenderForUser(String desiredUser) {
        CustomLogger.log.setLevel(Level.INFO);
        CustomLogger.log.info("Users: " + desiredUser + " Gender: " + users.get(desiredUser).getGender());
        return users.get(desiredUser).getGender();
    }

    public String getAddressForUser(String desiredUser) {
        CustomLogger.log.setLevel(Level.INFO);
        CustomLogger.log.info("Users: " + desiredUser + " Address: " + users.get(desiredUser).getAddress());
        return users.get(desiredUser).getAddress();
    }
}