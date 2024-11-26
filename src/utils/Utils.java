package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static boolean matcher(String patternValue, String matcherValue){
        Pattern pattern = Pattern.compile(patternValue);
        Matcher matcher = pattern.matcher(matcherValue);
        return matcher.matches();
    }
}
