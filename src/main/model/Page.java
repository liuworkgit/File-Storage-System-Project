package model;

// Represents a page with an id, paragraphs (text) and links to other pages

// (METHOD CREATED) As a user, I want to be able to create a new page and have it be added to my list of existing pages.
//- Page (represents an empty page)
//- ListOfPages (represents an empty list of note pages)
//
// As a user, I want to be able to highlight text.
//- highlighter? idk
//
//As a user, I want to be able to type and delete text.
//- functionality in page?
//
//As a user, I want to be able to create a hyperlink between a word and another page, or between two pages.
//- functionality in page? (ask TA)

import java.util.ArrayList;
import java.util.List;

public class Page {
    private String name;
    private int pageId;
    private List<Paragraph> listParagraphs;
    private List<String> listLinks; // LINK TO PAGE AND PARAGRAPH+PAGE IT'S IN, save as list strings of name or name|id

    // !!!!!! what about id?
    // REQUIRES:
    // MODIFIES:
    // EFFECTS: creates a page with no paragraphs and links
    public Page(String name) {
        this.name = name;
        this.pageId = 1; // PLACEHOLDER
        this.listParagraphs = new ArrayList<>();
        this.listLinks = new ArrayList<>();
    }

    public void addParagraph(String text) {} // calls Paragraph, increments paragraph id by 1

    public void deleteParagraph(String text) {} // calls deleteParagraph, inputted text gets deleted

    public void addLink(String name) {}

    public void deleteLink(String name) {}


    // getters

    // !!!!!!
    // REQUIRES:
    // EFFECTS: gets the name of the page
    public String getName() {
        return "";
    }

    public void changeName(String newName) {}

    // !!!!!!
    // REQUIRES:
    // EFFECTS: gets the id of the page
    public int getPageId() {
        return 0;
    }

    // !!!!!!
    // REQUIRES:
    // EFFECTS: gets the list of paragraphs of the page
    public List<Paragraph> getListParagraphs() {
        return ArrayList<>();
    }

    // !!!!!!
    // REQUIRES:
    // EFFECTS: get the list of links of the page
    public List<String> getListLinks() {
        return ArrayList<>();
    }
}
