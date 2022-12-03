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
        String oldText = this.text;
        this.text += text;
        EventLog.getInstance().logEvent(new Event("Updated text: "
                + oldText
                + " -> "
                + this.text));
    }

    // REQUIRES: text cannot be empty string and must be in this.text. text cannot equal this.text
    // MODIFIES: this
    // EFFECTS: deletes the inputted text from the paragraph
    //          if there are duplicates, deletes first occurrence.
    public void deleteText(String text) {
        int startDelete = this.text.indexOf(text);
        int endDelete = text.length();
        String[] parts = getForEdit(text);
        String leftPart = parts[0];
        String rightPart = parts[1];
        // bolding prevention
        if (leftPart.endsWith("**") && rightPart.startsWith("**")) {
            leftPart = this.text.substring(0, startDelete - 2);
            rightPart = this.text.substring(startDelete + endDelete + 2);
        }
        // deleting
        this.text = leftPart + rightPart;
    }

    // REQUIRES: this.text cannot be empty string
    // MODIFIES: this
    // EFFECTS: bolds the text by putting double asterixes around the chosen text.
    //          if given text appears more than once in paragraph, bolds first occurrence
    public void boldText(String text) {
        String[] parts = getForEdit(text);
        String leftPart = parts[0];
        String rightPart = parts[1];
        this.text = leftPart + "**" + text + "**" + rightPart;
    }

    // REQUIRES: text must have two occurrences of "**" in it
    // MODIFIES: this
    // EFFECTS: unbolds the given text by removing the outermost two occurrences of "**"
    public void unboldText(String text) {
        String[] parts = getForEdit(text);
        String leftPart = parts[0];
        String rightPart = parts[1];

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

    // EFFECTS: returns a chunk of this.text for editing
    public String[] getForEdit(String text) {
        String[] parts = new String[2];

        int startOfDeleting = this.text.indexOf(text);
        int endOfDeleting = text.length();
        String leftPart = this.text.substring(0, startOfDeleting);
        String rightPart = this.text.substring(startOfDeleting + endOfDeleting);
        parts[0] = leftPart;
        parts[1] = rightPart;
        return parts;
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
