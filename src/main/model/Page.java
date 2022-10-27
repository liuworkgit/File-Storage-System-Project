package model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// Represents a page with a name, paragraphs (text) and links to other pages
public class Page implements Writable {
    private String name;
    private List<Paragraph> listParagraphs;
    private List<String> listLinks;

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

    // EFFECTS: shows all paragraph options
    public String displayParagraphs() {
        String message = "";
        for (Paragraph paragraph : listParagraphs) {
            int index = listParagraphs.indexOf(paragraph);
            String strIndex = String.valueOf(index + 1);
            String option = "[" + strIndex + "] " + paragraph.getText();
            message = message + option + "\n";
        }
        return message;
    }

    // REQUIRES: page must exist
    // MODIFIES: this
    // EFFECTS: adds a link to the page.
    //          Doesn't add the link if it's already been added,
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

    // EFFECTS: shows all link options
    public String displayLinks() {
        String message = "";
        for (String link : listLinks) {
            int index = listLinks.indexOf(link);
            String strIndex = String.valueOf(index + 1);
            String option = "[" + strIndex + "] " + link;
            message = message + option + "\n";
        }
        return message;
    }

    public JSONObject toJson() {
        return new JSONObject(); // STUB
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public List<Paragraph> getListParagraphs() {
        return listParagraphs;
    }

    public List<String> getListLinks() {
        return listLinks;
    }
}
