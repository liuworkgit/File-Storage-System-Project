package ui;

import model.Page;
import model.Paragraph;

import java.util.List;
import java.util.Scanner;

// functionality for the page level of the app
public abstract class PageFunctionality extends EditFunctionality {
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
            viewLinks(page);
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

    // EFFECTS: shows links
    public void viewLinks(Page page) {
        List<Page> pages = page.getListLinks();
        if (pages.isEmpty()) { // no links
            System.out.println("You have no linked pages.");
        } else { // shows all links
            Scanner pageInput = new Scanner(System.in);
            System.out.println("Select a page to view.");
            System.out.println(page.displayLinks());
            int index = pageInput.nextInt() - 1;
            runLink(pages.get(index));
        }
    }

    // EFFECTS: runs things in regard to links
    public void runLink(Page page) {
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
}
