package ui;

import java.util.List;
import java.util.Scanner;

import model.Directory;
import model.Folder;
import model.Page;
import model.Paragraph;

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
        Scanner toDelete = new Scanner(System.in);
        System.out.println("Select folder to delete:");
        System.out.println(directory.displayChoices());
        directory.getListFolders().remove(toDelete.nextInt() - 1);
    }

    // EFFECTS: renames chosen folder from directory
    public void renameFolder() {
        // get folder
        Scanner toRename = new Scanner(System.in);
        System.out.println("Select folder to rename:");
        System.out.println(directory.displayChoices());
        int index = toRename.nextInt();
        Folder folderToRename = directory.getListFolders().get(index - 1);
        // new name
        Scanner newName = new Scanner(System.in);
        System.out.println("Enter new name:");
        folderToRename.setName(newName.nextLine());
    }

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

    // EFFECTS: processes user input at page level
    public void runPage(Page page) {
        List<Paragraph> paragraphs = page.getListParagraphs();
        List<Page> links = page.getListLinks();
        Scanner input = new Scanner(System.in);
        boolean stayHere = true;

        while (stayHere == true) {
            System.out.println("Currently viewing page:" + page.getName());
            showPageMenu();
            int command = input.nextInt();

            if (command == 0) {
                stayHere = false;
            } else {
                pageProcess(command, page);
            }
        }
    }

    // EFFECTS: shows page options
    public void showPageMenu() {
        System.out.println("What would you like to do?"
                + "\n[1] add paragraph"
                + "\n[2] delete paragraph"
                + "\n[3] edit paragraph"
                + "\n[4] view links"
                + "\n[0] back");
    }

    // EFFECTS: processes input at the page level
    public void pageProcess(int command, Page page) {
        if (command == 1) {
            addParagraph(page);
        } else if (command == 2) {
            deleteParagraph(page);
        } else if (command == 3) {
            runEdit(page);
        } else if (command == 4) {
            viewLinks(page.getListLinks());
        }
    }

    // MODIFIES: page
    // EFFECTS: adds paragraph to page
    public void addParagraph(Page page) {
        Scanner newText = new Scanner(System.in);
        System.out.println("Enter text below:");
        page.addParagraph(newText.nextLine());
    }

    // MODIFIES: page
    // EFFECTS: deletes paragraph from page
    public void deleteParagraph(Page page) {
        if (page.getListParagraphs().isEmpty()) {
            System.out.println("You have no paragraphs to delete.");
        } else {
            Scanner toDelete = new Scanner(System.in);
            System.out.println("Select paragraph to delete:");
            page.displayParagraphs();
            page.getListParagraphs().remove(toDelete.nextInt() - 1);
        }
    }

    // EFFECTS: run app at paragraph level (related to editing only)
    public void runEdit(Page page) {
        Scanner choice = new Scanner(System.in);
        System.out.println("Select paragraph to edit:");
        page.displayParagraphs();
        Paragraph chosenParagraph = page.getListParagraphs().get(choice.nextInt());

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



    } // !!! FIX

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

    // REPETITIVE - REFACTOR! (w/ UNBOLDTEXT)
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
        text.(toUnbold.nextLine());
    }

    public void viewLinks(List<Page> links) {}
}