/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author macbookpro
 */
import controller.DictionaryController;
import java.util.Scanner;

public class DictionaryView {
    private DictionaryController controller;
    private Scanner scanner;

    public DictionaryView(DictionaryController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }
public void setController(DictionaryController controller) {
        this.controller = controller;
    }

    public void displayMenu() {
        System.out.println("=====Dictionary Program=====");
        System.out.println("1. Add word");
        System.out.println("2. Delete word");
        System.out.println("3. Translate");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void handleUserInput() {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addWord();
                    break;
                case 2:
                    deleteWord();
                    break;
                case 3:
                    searchWord();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public void addWord() {
        System.out.println("----------Add----------");
        System.out.print("Enter English : ");
        String engWord = scanner.nextLine();
        System.out.print("Enter Vietnamese: ");
        String viWord = scanner.nextLine();

        boolean success = controller.addWord(engWord, viWord);
        if (success) {
            System.out.println("Word added.");
        }
    }

    public void deleteWord() {
        System.out.println("-----------Delete----------");
        System.out.print("Enter English:");
        String engWord = scanner.nextLine();

        boolean success = controller.removeWord(engWord);
        if (success) {
            System.out.println("successful.");
        }
    }

    public void searchWord() {
        System.out.print("Enter English: ");
        String engWord = scanner.nextLine();

        String translation = controller.translate(engWord);
        System.out.println("Vietnamese: " + translation);
    }
}