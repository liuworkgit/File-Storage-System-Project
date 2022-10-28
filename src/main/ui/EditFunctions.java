package ui;

import model.Page;
import model.Paragraph;

import java.util.Scanner;
import java.util.List;

// NOTE: Based on JsonSerializationDemo provided by CPSC210
// Found on Phase 2 page on CPSC210 edx
// Link to repository:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// functionality for the paragraph level of the app (editing specific)
public abstract class EditFunctions {

    // EFFECTS: run app at paragraph level (related to editing only)
    public void runEdit(Page page) {
        Scanner choice = new Scanner(System.in);
        System.out.println("Select paragraph to edit:");
        System.out.println(page.displayParagraphs());
        Paragraph chosenParagraph = page.getListParagraphs().get(choice.nextInt() - 1);

        boolean stayHere = true;
        Scanner input = new Scanner(System.in);
        while (stayHere == true) {
            showEditMenu(chosenParagraph);
            int command = input.nextInt();

            if (command == 0) {
                stayHere = false;
            } else {
                editProcess(command, chosenParagraph);
            }
        }
    }

    // EFFECTS: shows edit options
    public void showEditMenu(Paragraph paragraph) {
        System.out.println("What would you like to do to this paragraph?"
                + "\n" + "\"" + paragraph.getText() + "\""
                + "\n[1] bold text"
                + "\n[2] unbold text"
                + "\n[3] rewrite text"
                + "\n[0] back");
    }

    // EFFECTS: processes user input at paragraph level (for editing only)
    public void editProcess(int command, Paragraph paragraph) {
        if (command == 1) {
            boldText(paragraph);
        } else if (command == 2) {
            unboldText(paragraph);
        } else if (command == 3) {
            rewriteText(paragraph);
        }
    }

    // MODIFIES: text
    // EFFECTS: bolds given text
    public void boldText(Paragraph text) {
        Scanner toBold = new Scanner(System.in);
        System.out.println("Enter part of text you want to bold.");
        System.out.println(text.getText());
        text.boldText(toBold.nextLine());
    }

    // REPETITIVE - REFACTOR! (W/ BOLDTEXT)
    // REQUIRES: given text must already be bolded
    // MODIFIES: text
    // EFFECTS: unbolds given text
    public void unboldText(Paragraph text) {
        Scanner toUnbold = new Scanner(System.in);
        System.out.println("Enter part of text you want to unbold.");
        System.out.println(text.getText());
        text.unboldText(toUnbold.nextLine());
    }

    // MODIFIES: text
    // EFFECTS: rewrites given text
    public void rewriteText(Paragraph text) {
        Scanner toRewrite = new Scanner(System.in);
        System.out.println("Enter rewritten text:");
        System.out.println(text.getText());
        text.setText(toRewrite.nextLine());
    }
}
