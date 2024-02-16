import java.util.Scanner;
import static java.lang.System.exit;
import java.security.SecureRandom;
/**
 * This program demonstrates a simple menu-based application that performs string encoding and decoding using the
 * Vigenere cipher.
 */
public class Main {
    /**
     * Prints the menu options.
     * @param options The array of menu options.
     */
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
    /**
     * Main method to run the program.
     */
    public static void main(String[] args) {
        String[] options = {"1- Input string or generate it",
                "2- Input key or generate it",
                "3- Code the string",
                "4- Show decode string",
                "5- Exit",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option!=5){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1: massageDefinition(); break;
                    case 2: keyDefinition(); break;
                    case 3: codeString(); break;
                    case 4: showDecodeString(); break;
                    case 5: exit(0);
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    }

    static String massage = "";
    static String key = "";
    static String code = "";
    /**
     *Defines the message to be used for encoding.
     *If inputMassage is empty, a random message will be generated.
     */
    private static void massageDefinition() {
        code = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your massage or it wold be generate!");
        String inputMassage = scanner.nextLine();
        if (inputMassage.isEmpty()) {
            SecureRandom secureRandom = new SecureRandom();
            StringBuilder randomMassage = new StringBuilder(7);
            for (int i = 0; i < 7; i++) {
                int randomIndexLetter = secureRandom.nextInt(97, 122);
                randomMassage.append((char) randomIndexLetter);
            }
            System.out.println(randomMassage);
            massage = randomMassage.toString();
        }
        else{
            System.out.println(inputMassage);
            massage = inputMassage;
        }
    }
    /**
     * Defines the key to be used for encoding.
     * If inputKey is empty, a random key will be generated.
     */
    private static void keyDefinition() {
        code = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your key or it wold be generate!");
        String inputKey = scanner.nextLine();
        if (inputKey.isEmpty()) {
            SecureRandom secureRandom = new SecureRandom();
            StringBuilder randomKey = new StringBuilder(3);
            for (int i = 0; i < 7; i++) {
                int randomIndexLetter = secureRandom.nextInt(97, 122);
                randomKey.append((char) randomIndexLetter);
            }
            System.out.println(randomKey);
            key = randomKey.toString();
        }
        else{
            System.out.println(inputKey);
            key = inputKey;
        }
    }
    /**
     * Codes the message using Vigenere cipher.
     * The massage and key must be defined before.
     */
    public static void codeString() {
        if (massage.isEmpty()|key.isEmpty()) {
//            System.out.println("Please identify massage and key before");
//            System.out.println("Please identify massage and key before");
            System.out.println("Please identify massage and key before");
        }
        else {
            String decodeMassage = VeginerCipher.cipher(massage, key);
            System.out.println("Massage was code by Viginer cipher!");
            code = decodeMassage;
        }
    }
    /**
     * Shows the decoded message.
     * The message must be coded before.
     */
    private static void showDecodeString() {
            if(code.isEmpty()){
                System.out.println("Please code the massage before");
            }
            else {
                System.out.println(code);
            }
    }
}
