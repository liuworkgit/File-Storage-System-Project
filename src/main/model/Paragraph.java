package model;

import org.json.JSONObject;

// A paragraph on a page.
public class Paragraph {
    private String text;

    // REQUIRES: text cannot be empty string
    // EFFECTS: creates a new paragraph
    public Paragraph(String text) {
        this.text = text;
    }

    // REQUIRES: text cannot be empty string
    // MODIFIES: this
    // EFFECTS: adds text to the end of the paragraph
    public void addText(String text) {
        this.text = this.text + text;
    }

    // REQUIRES: text cannot be empty string and must be in this.text. text cannot equal this.text
    // MODIFIES: this
    // EFFECTS: deletes the inputted text from the paragraph
    //          if there are duplicates, deletes first occurrence.
    public void deleteText(String text) {
        int startOfDeleting = this.text.indexOf(text);
        int endofDeleting = text.length();
        String leftPart = this.text.substring(0, startOfDeleting);
        String rightPart = this.text.substring(startOfDeleting + endofDeleting);
        // bolding prevention
        if (leftPart.endsWith("**") && rightPart.startsWith("**")) {
            leftPart = this.text.substring(0, startOfDeleting - 2);
            rightPart = this.text.substring(startOfDeleting + endofDeleting + 2);
        }
        // deleting
        this.text = leftPart + rightPart;
    }

    // REQUIRES: this.text cannot be empty string
    // MODIFIES: this
    // EFFECTS: bolds the text by putting double asterixes around the chosen text.
    //          if given text appears more than once in paragraph, bolds first occurrence
    public void boldText(String text) {
        int startOfDeleting = this.text.indexOf(text);
        int endofDeleting = text.length();
        String leftPart = this.text.substring(0, startOfDeleting);
        String rightPart = this.text.substring(startOfDeleting + endofDeleting);
        this.text = leftPart + "**" + text + "**" + rightPart;
    }

    // REQUIRES: text must have two occurrences of "**" in it
    // MODIFIES: this
    // EFFECTS: unbolds the given text by removing the outermost two occurrences of "**"
    public void unboldText(String text) {
        int startOfDeleting = this.text.indexOf(text);
        int endOfDeleting = text.length();
        String leftPart = this.text.substring(0, startOfDeleting);
        String rightPart = this.text.substring(startOfDeleting + endOfDeleting);
        String leftSubstring = leftPart.substring(0, leftPart.length() - 2);
        if (leftPart.endsWith("**") && rightPart.startsWith("**")) {
            this.text = leftSubstring
                    + text
                    + rightPart.substring(2);
        } else if (rightPart.startsWith("**")) {
            this.text = leftPart
                    + "**"
                    + text
                    + rightPart.substring(2);
        } else if (leftPart.endsWith("**")) {
            this.text = leftSubstring
                    + text
                    + "**"
                    + rightPart;
        } else {
            this.text = leftPart + "**" + text + "**" + rightPart;
        }
    }

    // EFFECTS: writes paragraph as a json object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("text", text);
        return json;
    }


    // getters and setters

    public String getText() {
        return text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

}
