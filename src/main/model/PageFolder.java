package model;

//As a user, I want to be able to delete pages and have their associated links disappear too.
//- functionality in page?
//As a user, I want to be able to group my note pages into folders.

import java.util.ArrayList;
import java.util.List;

// a list of note pages
public class PageFolder {
    private String name;
    private int id;
    private List<Page> listPages;

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: creates a page folder
    public PageFolder(String name) {}

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: adds a page to the list of note pages
    // potentially rename to more general if Directory shares interface?
    public void addPage() {} // addPage calls Page()

    public void removePage() {}


    // getters and setters
    public String getName() {}

    public int getId() {}

    public List<Page> getListPages() {}

    // MODIFIES: this
    // EFFECTS: changes the name of the page folder
    public void changeName(String newName) {}
}
