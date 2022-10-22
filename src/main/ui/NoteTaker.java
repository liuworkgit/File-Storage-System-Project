package ui;

// put ui functionality in here for now

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Directory;
import model.Page;
import model.PageFolder;
import model.Paragraph;

public class NoteTaker {
    private int directoryInput;
    private int pageFolderInput;
    private Directory directory;

    // NOTE!
    // AFTER INPUT HAS BEEN ENTERED TO ANY INQUIRY, INPUT VALUES DEFAULT BACK TO 0

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: creates a new note-taking application
    public NoteTaker() {
        // create new directory
        directory = new Directory();
        // ask + receive user input
        System.out.println("What would you like to do?"
                + "\n[1] view folders"
                + "\n[2] add folder"
                + "\n[3] delete folder"
                + "\n[4] rename folder");
        Scanner userInput = new Scanner(System.in);
        directoryInput = userInput.nextInt();
        // process input
        directoryMenu(directoryInput);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: displays the directory menu
    public void directoryMenu(int input) {
        List<PageFolder> directoryFolders = directory.getListFolders();

        if (input == 1) { // view folders
            // ???
        } else if (input == 2) { // add folder
            // ask for name
            Scanner newFolderInput = new Scanner(System.in);
            System.out.println("What would you like to name this folder?");
            // creates new folder and adds it
            directory.addFolder(newFolderInput.nextLine());
        } else if (input == 3) { // delete folder
            // display options + ask for folder to delete
            Scanner deleteFolderInput = new Scanner(System.in);
            System.out.println("Select folder to delete:");
            displayOptions();
            // deletes chosen folder
            directoryFolders.remove(deleteFolderInput.nextInt());
        } else if (input == 4) { // rename folder
            System.out.println("THIS IS A PLACEHOLDER");
        }
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: displays the folder menu
    public void folderMenu() {
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: displays the page menu
    public void pageMenu() {
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void displayOptions() {
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void goBack() {
    }
}
