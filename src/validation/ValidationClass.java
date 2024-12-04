package validation;

import utils.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ValidationClass {
    public Properties properties = new Properties();

    public void validation(String propertiesFilePath){
        try (FileInputStream inputStream = new FileInputStream(propertiesFilePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Error loading properties file: " + e.getMessage());
        }
    }

        // Check Country Code
     /* public boolean validateCountry(String countryCode) {
           return properties.containsKey(countryCode);
        } */

    public boolean validatePhoneNumber(String phoneNo, String regexpKey, String errorKey) {
        String regex = properties.getProperty(regexpKey);
        String error = properties.getProperty(errorKey);

        if (regex.isEmpty()) {
            System.out.println("Regex for " + regexpKey + " is not defined in properties file.");
            return false;
        }

        boolean isValid = Utils.matcher(regex, phoneNo);
        if (isValid) {
            return true;
        } else {
            System.out.println("Validation failed: " + (error != null ? error : "Invalid phone number format"));
            return false;
        }
    }



}
