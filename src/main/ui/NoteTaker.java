package ui;

// put ui functionality in here for now

import java.util.Scanner;

import model.Directory;

public class NoteTaker {
    private int directoryInput;
    private int pageFolderInput;
    private Directory directory;

    // NOTE!
    // AFTER INPUT HAS BEEN ENTERED TO ANY INQUIRY, INPUT VALUES DEFAULT BACK TO 0

    public NoteTaker() {
        directory = new Directory();
        Scanner userInput = new Scanner(System.in);
        System.out.println("What would you like to do?"
                + "\n[1] view folder"
                + "\n[2] add folder"
                + "\n[3] delete folder"
                + "\n[4] rename folder");
        directoryInput = userInput.nextInt();

//        if (directoryInput = 1) {
//            displayOptions();
//        } else if (directoryInput = 2) {
//            Scanner newFolderInput = new Scanner(System.in);
//            System.out.println("What would you like to name this folder?");
//            String folderName = newFolderInput.nextLine();
//            directory.addFolder(folderName);
//        } else if (directoryInput = 3) {
//            System.out.println("THIS IS A PLACEHOLDER");
//        } else if (directoryInput = 4) {
//            System.out.println("THIS IS A PLACEHOLDER");
//        }
    }

}
