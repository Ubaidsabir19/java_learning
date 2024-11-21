package EmployeeData;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ValidationClass {
    Properties properties = new Properties();

    public void validation(String propertiesFilePath){
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFilePath)) {
            if (inputStream == null) {
                throw new IOException("Properties file not found!");
            }
            properties.load(inputStream);
            System.out.println(inputStream);
        } catch (IOException e) {
            System.out.println("Error loading properties file: " + e.getMessage());
        }

    }

    public String validateCountry(String country) {
        String[] countries = {"Pak", "IND", "US"};
        for (String countryName : countries) {
            if (country.equalsIgnoreCase(countryName)) {
                return countryName;
            }
        }
        return country;
    }


    public boolean validatePhoneNumber(String phoneNo, String regexp, String errorMessage) {
        String regex = properties.getProperty(regexp);
        String error = properties.getProperty(errorMessage);

        if (regex == null) {
            System.out.println("Invalid properties file: missing phone regex or error message.");
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
