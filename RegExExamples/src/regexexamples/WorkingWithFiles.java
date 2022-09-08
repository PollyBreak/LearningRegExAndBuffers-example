package regexexamples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorkingWithFiles {
    public static String readFromFile(File file) {
        StringBuilder stringFromFile = new StringBuilder("");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                stringFromFile.append(currentLine + "\n");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return stringFromFile.toString();
    }
    
    public static void writeToFile(File file, String s) {
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(file))) {
            for (char c: s.toCharArray()){
                writter.write(c);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}
