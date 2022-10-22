package model;

import java.util.ArrayList;
import java.util.List;

// Represents a page with an id, paragraphs (text) and links to other pages
public class Page {
    private String name;
    private List<Paragraph> listParagraphs;
    private List<String> listLinks; // LINK TO PAGE AND PARAGRAPH+PAGE IT'S IN, save as list strings of name or name|id

    // REQUIRES: name must not be empty
    // EFFECTS: creates a page with the given name, no paragraphs and no links
    public Page(String name) {
        this.name = name;
        this.listParagraphs = new ArrayList<>();
        this.listLinks = new ArrayList<>();
    }

    // REQUIRES: text cannot be an empty string
    // MODIFIES: this
    // EFFECTS: adds a paragraph to the bottom of the page
    public void addParagraph(String text) {
        listParagraphs.add(new Paragraph(text));
    }

    // MODIFIES: this
    // EFFECTS: deletes a paragraph from the page
    public void deleteParagraph(int index) {
        listParagraphs.remove(index);
    }

    // MODIFIES: this
    // EFFECTS: rewrite an existing paragraph
    public void rewriteParagraph(int index, String newText) {
        Paragraph oldText = listParagraphs.get(index);
        oldText.setText(newText);
    }

    // REQUIRES: a page must exist and have the given name
    // MODIFIES: this
    // EFFECTS: adds a link to the page
    public void addLink(String name) {
        if (listLinks.contains(name)) {
            System.out.println("You've already linked page named " + name);
        } else {
            listLinks.add(name);
        }
    }

    // MODIFIES: this
    // EFFECTS: deletes a link from the page
    public void deleteLink(int index) {
        listLinks.remove(index);
    }


    // getters and setters

    public String getName() {
        return name;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public List<Paragraph> getListParagraphs() {
        return listParagraphs;
    }

    public List<String> getListLinks() {
        return listLinks;
    }
}
