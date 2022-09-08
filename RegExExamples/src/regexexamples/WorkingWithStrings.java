package regexexamples;
import java.util.ArrayList;
import java.util.regex.*;

public class WorkingWithStrings {
    
    public static String setWidth(String s, int width){
        StringBuilder newString = new StringBuilder();
        newString.append(s.charAt(0));
        boolean isNewLine = false;
        for (int i = 1; i<s.length();i++) {
            newString.append(s.charAt(i));
            if (i % width == 0) {
                isNewLine = true;
            }
            if (isNewLine) {
                if (s.charAt(i)==' '){
                    newString.append("\n");
                    isNewLine = false;
                }
            }
        }
        return newString.toString();
    }
    
    public static String vowelsToUpper(String s) {
        String result = s;
        ArrayList<Character> foundVowels = new ArrayList<>();
        Pattern pattern = Pattern.compile("(а)|(е)|(ё)|(и)|(о)|(у)|(ы)|(э)|(ю)|(я)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            if (!foundVowels.contains(s.charAt(matcher.start()))){
                foundVowels.add(Character.toLowerCase(s.charAt(matcher.start())));
            }
            else {continue;}
            if (foundVowels.size()==10) {break;}
        }
        for (char c: foundVowels){
            result = result.replace(c, Character.toUpperCase(c));
        }
        return result;
    }
    
    public static ArrayList<String> findWordsInQuotes(String s) { //returns all words in quotes
        ArrayList<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\".+?\")|(«.+?»)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            if (!words.contains(matcher.group())) {
                words.add(matcher.group());
            }
        }
        return words;
    }
    
    public static ArrayList<String> findScores(String s) { //returns all scores as "0-0"
        ArrayList<String> scores = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d[- :]\\d");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
                scores.add(matcher.group().replaceAll("[ :]", "-"));
        }
        
        return scores;
    }
}
