package ui;

import model.Page;
import model.Paragraph;

import java.util.List;
import java.util.Scanner;

// NOTE: Based on JsonSerializationDemo provided by CPSC210
// Found on Phase 2 page on CPSC210 edx
// Link to repository:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// functionality for the page level of the app
public abstract class PageFunctions extends EditFunctions {
    private List<Paragraph> paragraphs;
    private List<String> links;

    // EFFECTS: processes user input at page level
    public void runPage(Page page) {
        paragraphs = page.getListParagraphs();
        links = page.getListLinks();
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
            editAccess(page);
        } else if (command == 4) {
            viewLinks(page);
        }
    }

    // EFFECTS: prevents access to paragraph editing if there are no paragraphs to edit
    public void editAccess(Page page) {
        List<Paragraph> paras = page.getListParagraphs();
        if (paras.isEmpty()) {
            System.out.println("You have no paragraphs to edit.");
        } else {
            runEdit(page);
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
            System.out.println(page.displayParagraphs());
            page.getListParagraphs().remove(toDelete.nextInt() - 1);
        }
    }

    // EFFECTS: shows links
    public void viewLinks(Page page) {
        List<String> pages = page.getListLinks();
        if (pages.isEmpty()) { // no links
            noItemsMessage("links");
        }
        runLink(page);
    }

    // EFFECTS: runs things in regard to links
    public void runLink(Page page) {
        Scanner input = new Scanner(System.in);
        boolean stayHere = true;

        while (stayHere == true) {
            System.out.println("The following pages are associated with " + page.getName() + ":");
            System.out.println(page.displayLinks());
            linkMenu();

            int command = input.nextInt();
            if (command == 0) {
                stayHere = false;
            } else {
                linkProcess(command, page);
            }
        }
    }

    // EFFECTS: shows link options
    public void linkMenu() {
        System.out.println("What would you like to do?"
                + "\n[1] add link"
                + "\n[2] delete link"
                + "\n[0] back");
    }

    // EFFECTS: processes user input at page level (link-specific)
    public void linkProcess(int command, Page page) {
        if (command == 1) {
            addLink(page);
        } else if (command == 2) {
            deleteLink(page);
        }
    }

    // EFFECTS: adds a link
    public void addLink(Page page) {
        Scanner newLink = new Scanner(System.in);
        System.out.println("Enter name of link below:");
        page.addLink(newLink.nextLine());
    }

    // EFFECTS: deletes a link
    public void deleteLink(Page page) {
        if (page.getListLinks().isEmpty()) {
            noItemsMessage("links");
        } else {
            Scanner toDelete = new Scanner(System.in);
            System.out.println("Select link to delete:");
            System.out.println(page.displayLinks());
            page.getListLinks().remove(toDelete.nextInt() - 1);
        }
    }
}
