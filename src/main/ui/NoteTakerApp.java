package ui;

import java.util.List;
import java.util.Scanner;

import model.Directory;
import model.Folder;

// NOTE: Based on JsonSerializationDemo provided by CPSC210
// Found on Phase 2 page on CPSC210 edx
// Link to repository:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// creates a note-taking app
public class NoteTakerApp {
    private Directory directory;

    // EFFECTS: makes a note taker with an empty directory and runs it
    public NoteTakerApp() {
        directory = new Directory();
        runDirectory();
    }

    // EFFECTS: processes user input at the directory level
    public void runDirectory() {
        Scanner input = new Scanner(System.in);
        boolean stayHere = true;

        while (stayHere == true) {
            showDirectoryMenu();
            int command = input.nextInt();

            if (command == 0) {
                stayHere = false;
            } else {
                directoryProcess(command);
            }
        }
        System.out.println("You have exited the app.");
    }

    // EFFECTS: shows directory options
    public void showDirectoryMenu() {
        System.out.println("What would you like to do?"
                + "\n[1] view folders"
                + "\n[2] add folder"
                + "\n[3] delete folder"
                + "\n[4] rename folder"
                + "\n[0] quit");
    }

    // EFFECTS: processes input at directory level
    public void directoryProcess(int command) {
        if (command == 1) { // view folders
            viewFolders();
        } else if (command == 2) { // add folder
            addFolder();
        } else if (command == 3) { // delete folder
            deleteFolder();
        } else if (command == 4) { // rename folder
            renameFolder();
        }
    }

    // EFFECTS: prints out folders in directory
    public void viewFolders() {
        List<Folder> folders = directory.getListFolders();
        if (folders.isEmpty()) { // no folders
            System.out.println("You have no folders currently.");
        } else { // shows all folders
            System.out.println("Select a folder to view.");
            directory.displayChoices();
            runFolder();
        }
    }

    // EFFECTS: adds a folder to the directory
    public void addFolder() {
        Scanner newName = new Scanner(System.in);
        System.out.println("What would you like to name this folder?");
        directory.addFolder(newName.nextLine());
    }

    // EFFECTS: deletes a folder from the directory
    public void deleteFolder() {
        Scanner toDelete = new Scanner(System.in);
        System.out.println("Select folder to delete:");
        // deletes chosen folder
        directory.getListFolders().remove(toDelete.nextInt());
    }

    // EFFECTS: renames chosen folder from directory
    public void renameFolder() {}

    // EFFECTS: processes user input at folder level
    public void runFolder() {
        Scanner input = new Scanner(System.in);
        boolean stayHere = true;

        while (stayHere == true) {
            showFolderMenu();
            int command = input.nextInt();

            if (command == 0) {
                stayHere = false;
            } else {
                folderProcess(command);
            }
        }
    }

    // EFFECTS: shows folder options
    public void showFolderMenu() {
        System.out.println("What would you like to do?"
                + "\n[1] view page"
                + "\n[2] add page"
                + "\n[3] delete page"
                + "\n[0] back");
    }

    // EFFECTS: processes input at folder level
    public void folderProcess(int command) {}

    // EFFECTS: processes user input at page level
    public void runPage() {}

    // EFFECTS: shows page options
    public void showPageOptions() {
        System.out.println("What would you like to do?"
                + "\n[1] add paragraph"
                + "\n[2] delete paragraph"
                + "\n[3] bold paragraph"
                + "\n[4] unbold paragraph"
                + "\n[5] rewrite paragraph"
                + "\n[6] add link"
                + "\n[7] delete link"
                + "\n[8] view links"
                + "\n[9] back");
    }
}
