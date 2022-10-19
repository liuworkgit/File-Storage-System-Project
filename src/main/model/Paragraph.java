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
    public void deleteText(String text) {}

    // ASK FOR HELP!!!
    // REQUIRES: this.text cannot be empty string
    // MODIFIES: this
    // EFFECTS: bolds the text by putting double asterixes around the chosen text.
    //          if given text appears more than once in paragraph, bolds first occurrence
    public void boldText(String text) {
//        int leftPartIndex = this.text.indexOf(text);
//
//        // part of string before text to be bolded
//
//        String leftPart = this.text.substring(0, leftPartIndex);
//        // part of string after text to be bolded
//        String rightPart = this.text.substring(..., ...);
    }


    // getters and setters

    // REQUIRES: this.text cannot be empty string
    public String getText() {
        return text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

}
