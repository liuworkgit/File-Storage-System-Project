package ui;

// put ui functionality in here for now

import java.util.Scanner;

public class NoteTaker {
    private int directoryInput = 0;
    private int pageFolderInput = 0;

    // NOTE!
    // AFTER INPUT HAS BEEN ENTERED TO ANY INQUIRY, INPUT VALUES DEFAULT BACK TO 0

    public NoteTaker() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What would you like to do?"
                + "\n[1] view folder"
                + "\n[2] add folder"
                + "\n[3] delete folder"
                + "\n[4] rename folder");
        directoryInput = userInput.nextInt();
        // RESULT OF USER INPUT AT DIRECTORY LEVEL
    }

    // MODIFIES: this
    // EFFECTS: asks the user what they would like to do in regard to the NoteTaker's folders
    public void directoryInquiry(int input) {
        System.out.println("PRINT OUT PAGE FOLDERS HERE!");

        if (input = 1) {}
    }

    // MODIFIES: this
    // EFFECTS: asks the user what they would like to do in regard to the NoteTaker's pages
    public void pageFolderInquiry(int input) {
        System.out.println("PRINT OUT PAGE NAMES HERE!");
        System.out.println("What would you like to do?"
                + "\n[1] view page"
                + "\n[2] add page"
                + "\n[3] delete page");
    }

    public void createPage() {}
}
