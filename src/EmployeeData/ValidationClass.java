package EmployeeData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ValidationClass {
    Properties properties = new Properties();

    public void validation(String propertiesFilePath){
        try (FileInputStream inputStream = new FileInputStream(propertiesFilePath)) {
            properties.load(inputStream);
            System.out.println(inputStream);
        } catch (IOException e) {
            System.out.println("Error loading properties file: " + e.getMessage());
        }

    }

    public boolean validateCountry(String country) {
        return properties.containsKey(country);

    }

    public boolean validatePhoneNumber(String phoneNo, String regexpKey, String errorKey) {
        String regex = properties.getProperty(regexpKey);
        String error = properties.getProperty(errorKey);

        if (regex == null) {
            System.out.println("Regex for " + regexpKey + " is not defined in properties file.");
            return false;
        }

        if (phoneNo.matches(regex)) {
            return true;
        } else {
            System.out.println(error);
            return false;
        }
    }

}
