package ui;

import model.Folder;
import model.Page;

import java.util.List;
import java.util.Scanner;

// NOTE: Based on JsonSerializationDemo provided by CPSC210
// Found on Phase 2 page on CPSC210 edx
// Link to repository:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// functionality for the folder level of the app
public abstract class FolderFunctions extends PageFunctions {
    // EFFECTS: runs app at folder level
    public void runFolder(Folder folder) {
        Scanner input = new Scanner(System.in);
        boolean stayHere = true;

        while (stayHere == true) {
            System.out.println("Currently viewing folder:" + folder.getName());
            showFolderMenu();
            int command = input.nextInt();

            if (command == 0) {
                stayHere = false;
            } else {
                folderProcess(command, folder);
            }
        }
    }

    // EFFECTS: shows folder options
    public void showFolderMenu() {
        System.out.println("What would you like to do?"
                + "\n[1] view pages"
                + "\n[2] add page"
                + "\n[3] delete page"
                + "\n[0] back");
    }

    // EFFECTS: processes input at folder level
    public void folderProcess(int command, Folder folder) {
        if (command == 1) { // view pages
            viewPages(folder);
        } else if (command == 2) { // add page
            addPage(folder);
        } else if (command == 3) { // delete page
            deletePage(folder);
        }
    }

    // EFFECTS: shows all pages
    public void viewPages(Folder folder) {
        List<Page> pages = folder.getListPages();
        if (pages.isEmpty()) { // no pages
            System.out.println("You have no pages in this folder.");
        } else { // shows all pages
            Scanner pageInput = new Scanner(System.in);
            System.out.println("Select a page to view.");
            System.out.println(folder.displayChoices());
            int index = pageInput.nextInt() - 1;
            runPage(pages.get(index));
        }
    }

    // EFFECTS: adds new page
    public void addPage(Folder folder) {
        Scanner newName = new Scanner(System.in);
        System.out.println("What would you like to name this page?");
        folder.addPage(newName.nextLine());
    }

    // EFFECTS: deletes npage
    public void deletePage(Folder folder) {
        Scanner toDelete = new Scanner(System.in);
        System.out.println("Select page to delete:");
        System.out.println(folder.displayChoices());
        folder.getListPages().remove(toDelete.nextInt() - 1);
    }
}
