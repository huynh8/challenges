package com.example.missingletters;

import java.util.Scanner;

public class MissingLettersApplication {
    static MissingLettersFinder missingLettersFinder = new MissingLettersFinder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a sentence: ");
            String sentence = scanner.nextLine();
            String missingLetters = missingLettersFinder.getMissingLetters(sentence);
            System.out.println("Missing letters from sentence: " + missingLetters);
            System.out.print("Do you want to quit? ");
            String exitConfirmation = scanner.nextLine().toLowerCase();
            if (exitConfirmation.contains("y")) {
                System.exit(0);
            }
        }
    }
}
