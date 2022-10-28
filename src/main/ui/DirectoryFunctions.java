package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import model.Directory;
import model.Folder;
import persistence.JsonReader;
import persistence.JsonWriter;

// NOTE: Based on JsonSerializationDemo provided by CPSC210
// Found on Phase 2 page on CPSC210 edx
// Link to repository:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// functionality for the note taker app at the directory level
public class DirectoryFunctions extends FolderFunctions {
    private static final String JSON_STORE = "./data/notes.json";
    private Directory directory;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: makes a note taker with an empty directory and runs it
    public DirectoryFunctions() throws FileNotFoundException {
        directory = new Directory();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runDirectory();
    }

    // EFFECTS: run app at directory level
    public void runDirectory() {
        Scanner input = new Scanner(System.in);
        boolean stayHere = true;

        while (stayHere) {
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
                + "\n[5] save notes"
                + "\n[6] load notes"
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
        } else if (command == 5) { // save notes
            saveDirectory();
        } else if (command == 6) { // load notes
            loadDirectory();
        }
    }

    // EFFECTS: prints out folders in directory
    public void viewFolders() {
        List<Folder> folders = directory.getListFolders();
        if (folders.isEmpty()) { // no folders
            System.out.println("You have no folders currently.");
        } else { // shows all folders
            Scanner folderInput = new Scanner(System.in);
            System.out.println("Select a folder to view.");
            System.out.println(directory.displayChoices());
            int index = folderInput.nextInt() - 1;
            runFolder(directory.getListFolders().get(index));
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
        List<Folder> folders = directory.getListFolders();
        if (folders.isEmpty()) {
            System.out.println("You have no folders currently.");
        } else {
            Scanner toDelete = new Scanner(System.in);
            System.out.println("Select folder to delete:");
            System.out.println(directory.displayChoices());
            folders.remove(toDelete.nextInt() - 1);
        }
    }

    // EFFECTS: renames chosen folder from directory
    public void renameFolder() {
        List<Folder> folders = directory.getListFolders();
        if (folders.isEmpty()) {
            System.out.println("You have no folders currently.");
        } else {
            // get folder
            Scanner toRename = new Scanner(System.in);
            System.out.println("Select folder to rename:");
            System.out.println(directory.displayChoices());
            int index = toRename.nextInt();
            Folder folderToRename = folders.get(index - 1);
            // new name
            Scanner newName = new Scanner(System.in);
            System.out.println("Enter new name:");
            folderToRename.setName(newName.nextLine());
        }
    }

    // MODIFIES: directory
    // EFFECTS: loads directory from file
    public void loadDirectory() {
        try {
            directory = jsonReader.read();
            System.out.println("Loaded notes!");
        } catch (IOException e) {
            System.out.println("Unable to load notes.");
        }
    }

    // EFFECTS: saves director to file
    public void saveDirectory() {
        try {
            jsonWriter.open();
            jsonWriter.write(directory);
            jsonWriter.close();
            System.out.println("Saved notes!");
        } catch (IOException e) {
            System.out.println("Unable to save notes.");
        }
    }
}
