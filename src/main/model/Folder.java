package model;

//As a user, I want to be able to delete pages and have their associated links disappear too.
//- functionality in page?
//As a user, I want to be able to group my note pages into folders.

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// a list of note pages
public class Folder implements CanDisplay, Writable, Printable {
    private String name;
    private List<Page> listPages;

    // REQUIRES: name cannot be empty string
    // EFFECTS: creates a page folder with given name and no pages
    public Folder(String name) {
        this.name = name;
        listPages = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a page to the list of note pages
    // potentially rename to more general if Directory shares interface?
    public void addItem(String name) {
        listPages.add(new Page(name));
        EventLog.getInstance().logEvent(new Event("Added page "
                + "\""
                + name
                + "\""));
    }

    // MODIFIES: this
    // EFFECTS: deletes the page associated with the given index from the folder
    public void deleteItem(int index) {
        EventLog.getInstance().logEvent(new Event("Removed page "
                + "\""
                + listPages.get(index).getName()
                + "\""));
        listPages.remove(index);
    }

    public String displayChoices() {
        String message = "";
        for (Page page : listPages) {
            int index = listPages.indexOf(page);
            String strIndex = String.valueOf(index + 1);
            String option = "[" + strIndex + "] " + page.getName();
            message = message + option + "\n";
        }
        return message;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("listPages", arrayToJson());
        return json;
    }

    public JSONArray arrayToJson() {
        JSONArray jsonPages = new JSONArray();
        for (Page page : listPages) {
            jsonPages.put(page.toJson());
        }

        return jsonPages;
    }

    public String toString() {
        return name;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public List<Page> getListPages() {
        return listPages;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}
