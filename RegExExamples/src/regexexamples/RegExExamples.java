package regexexamples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RegExExamples{

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File textFile = new File("textFile.txt");
        File fileResult = new File("fileResult.txt");
        File formattedText = new File("formattedText.txt");
        String s = WorkingWithFiles.readFromFile(textFile);
        s = WorkingWithStrings.setWidth(s,100);
        WorkingWithFiles.writeToFile(formattedText,s);
        System.out.println(s);
        System.out.println("Что вы хотите сделать с файлом "+textFile.getName()+"?\n"
                + "Нажмите: \n"
                + "1 - для того, чтобы сделать все русские гласные буквы в файле заглавными\n"
                + "2 - для того, чтобы найти в файле все слова в кавычках \n"
                + "3 - для того, чтобы найти в файле все футбольные счета \n"
                + "4 - для выхода из программы");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.trim();
        int button = 0;
        while (button !=4){ 
            if (!input.equals("1") && !input.equals("2") && !input.equals("3")&& !input.equals("4")) {
                 System.out.println("Ошибка! Вы ввели не 1 или 2 или 3 или 4");
                 break;
            } else {
                button = Integer.parseInt(input);
                if (button == 4) break;
                switch(button){
                    case 1:
                        s = WorkingWithStrings.vowelsToUpper(s);
                        WorkingWithFiles.writeToFile(fileResult, s);
                        break;
                    case 2:
                        s = WorkingWithStrings.findWordsInQuotes(s).toString();
                        WorkingWithFiles.writeToFile(fileResult, s);
                        break;
                    case 3: 
                        s = WorkingWithStrings.findScores(s).toString();
                        WorkingWithFiles.writeToFile(fileResult, s);
                        break;
                }   
            System.out.println("Готово. Результат в файле "+fileResult.getName()+"\n"
                    + "Что делать дальше?");
            input = scanner.nextLine();
            input = input.trim();
        }
        }
    }
    
}
