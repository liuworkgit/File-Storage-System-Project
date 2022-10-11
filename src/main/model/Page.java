package model;

// Represents a page

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

public class Page {
    private String name;
    private int pageId;
    private ArrayList<Paragraph> listParagraphs;

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: creates a page
    public Page(String name) {
        this.name = name;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void highlightText() {} // (?) how to know when method should be public or private?

    private String getName() {
        return "";
    }

    private int getPageId() {
        return 0;
    }

    private void getParagraph() {}
}
