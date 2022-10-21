package model;

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

    // ASK FOR HELP!!!
    // REQUIRES: text cannot be empty string and must be in this.text. text cannot equal this.text
    // MODIFIES: this
    // EFFECTS: deletes the inputted text from the paragraph
    //          if there are duplicates, deletes last occurrence.
    public void deleteText(String text) {
        // get index of first and last character of to-be-deleted
        int startOfDeleting = this.text.indexOf(text);
        int endofDeleting = text.length();
        // get parts of string to left and right of to-be-deleted
        String leftPart = this.text.substring(0, startOfDeleting);
        String rightPart = this.text.substring(startOfDeleting + endofDeleting, this.text.length());
        // deleting
        String finalText = leftPart + rightPart;
        this.text = finalText;
    }

    // ASK FOR HELP!!!
    // REQUIRES: this.text cannot be empty string
    // MODIFIES: this
    // EFFECTS: bolds the text by putting double asterixes around the chosen text.
    //          if given text appears more than once in paragraph, bolds first occurrence
    public void boldText(String text) {
        // get index of first and last character of to-be-deleted
        int startOfDeleting = this.text.indexOf(text);
        int endofDeleting = text.length();
        // get parts of string to left and right of to-be-deleted
        String leftPart = this.text.substring(0, startOfDeleting);
        String rightPart = this.text.substring(startOfDeleting + endofDeleting, this.text.length());
        // bolding
        String finalText = leftPart + "**" + text + "**" + rightPart;
        this.text = finalText;
    }

    // REQUIRES: text must have two occurrences of "**" at the end
    // MODIFIES: this
    // EFFECTS: unbolds the given text by removing the outermost two occurrences of "**"
    public void unboldText(String text) {}


    // getters and setters

    public String getText() {
        return text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

}
