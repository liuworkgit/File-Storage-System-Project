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
    private List<String> listLinks;

    // !!!!!!
    // REQUIRES:
    // MODIFIES:
    // EFFECTS: creates a page
    public Page(String name) {
        this.name = name;
    }

    // !!!!!!
    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public String getName() {
        return "";
    }

    // !!!!!!
    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public int getPageId() {
        return 0;
    }

    // !!!!!!
    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public List<Paragraph> getParagraphList() {}

    // !!!!!!
    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public List<String> getListLinks() {}
}
