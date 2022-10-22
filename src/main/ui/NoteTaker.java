package ui;

// put ui functionality in here for now

import java.util.List;
import java.util.Scanner;

import model.Directory;
import model.PageFolder;

public class NoteTaker {
    private Directory directory;
    private List<PageFolder> directoryFolders;

    // NOTE!
    // AFTER INPUT HAS BEEN ENTERED TO ANY INQUIRY, INPUT VALUES DEFAULT BACK TO 0

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: creates a new note-taking application
    public NoteTaker() {
        // create new directory + set values
        directory = new Directory();
        directoryFolders = directory.getListFolders();
        // ask + receive user input
        System.out.println("What would you like to do?"
                + "\n[1] view folders"
                + "\n[2] add folder"
                + "\n[3] delete folder"
                + "\n[4] rename folder");
        Scanner userInput = new Scanner(System.in);
        int directoryInput = userInput.nextInt();
        // process input
        directoryOptions(directoryInput);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: displays the directory menu
    public void directoryOptions(int input) {
        if (input == 1) { // view folders
            viewFolder();
        } else if (input == 2) { // add folder
            addFolder();
            goBack("y");
        } else if (input == 3) { // delete folder
            deleteFolder();
            goBack("y");
        } else if (input == 4) { // rename folder
            renameFolder();
            goBack("y");
        }
    }


    // folder level
    // REQUIRES:
    // MODIFIES:
    // EFFECTS: displays the folder menu
    public void folderOptions(int input) {
        PageFolder currentFolder = directoryFolders.get(input);
    }

    // EFFECTS: displays directory's folders
    public void viewFolder() {
        Scanner viewFolderInput = new Scanner(System.in);
        if (directoryFolders.isEmpty()) {
            Scanner goBackInput = new Scanner(System.in);
            System.out.println("You have no folders currently."
                    + "\nGo back to main menu? [y] [n]");
            goBack(goBackInput.nextLine());
        } else {
            System.out.println("Select a folder to view.");
            displayChoices();
            folderOptions(viewFolderInput.nextInt());
        }
    }

    // EFFECTS: adds a folder to the directory
    public void addFolder() {
        // ask for name
        Scanner newFolderInput = new Scanner(System.in);
        System.out.println("What would you like to name this folder?");
        // creates new folder and adds it
        directory.addFolder(newFolderInput.nextLine());
    }

    // EFFECTS: deletes chosen folder from directory
    public void deleteFolder() {
        // display options + ask for folder to delete
        Scanner deleteFolderInput = new Scanner(System.in);
        System.out.println("Select folder to delete:");
        displayChoices();
        // deletes chosen folder
        directoryFolders.remove(deleteFolderInput.nextInt());
    }

    // EFFECTS: renames chosen folder
    public void renameFolder() {
        // get folder
        Scanner renameFolderInput = new Scanner(System.in);
        System.out.println("Select folder to rename:");
        displayChoices();
        PageFolder toBeRenamed = directoryFolders.get(renameFolderInput.nextInt());
        // new name
        Scanner newName = new Scanner(System.in);
        System.out.println("Enter new name:");
        toBeRenamed.setName(newName.nextLine());
    }


    // page level
    // REQUIRES:
    // MODIFIES:
    // EFFECTS: displays the page menu
    public void pageOptions(int input) {
    }


    // general
    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void displayChoices() {
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void goBack(String input) {
    }
}
