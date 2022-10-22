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

    // REQUIRES: text cannot be empty string and must be in this.text. text cannot equal this.text
    // MODIFIES: this
    // EFFECTS: deletes the inputted text from the paragraph
    //          if there are duplicates, deletes first occurrence.
    public void deleteText(String text) {
        // get index of first and last character of to-be-deleted
        int startOfDeleting = this.text.indexOf(text);
        int endofDeleting = text.length();
        // get parts of string to left and right of to-be-deleted
        String leftPart = this.text.substring(0, startOfDeleting);
        String rightPart = this.text.substring(startOfDeleting + endofDeleting);
        // bolding prevention
        if (leftPart.endsWith("**") && rightPart.startsWith("**")) {
            leftPart = this.text.substring(0, startOfDeleting - 2);
            rightPart = this.text.substring(startOfDeleting + endofDeleting + 2);
        }
        // deleting
        String finalText = leftPart + rightPart;
        this.text = finalText;
    }

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
        String rightPart = this.text.substring(startOfDeleting + endofDeleting);
        // bolding
        String finalText = leftPart + "**" + text + "**" + rightPart;
        this.text = finalText;
    }

    // REQUIRES: text must have two occurrences of "**" in it
    // MODIFIES: this
    // EFFECTS: unbolds the given text by removing the outermost two occurrences of "**"
    public void unboldText(String text) {
        // get index of first and last character of to-be-deleted
        int startOfDeleting = this.text.indexOf(text);
        int endofDeleting = text.length();
        // get parts of string to left and right of to-be-deleted
        String leftPart = this.text.substring(0, startOfDeleting);
        String rightPart = this.text.substring(startOfDeleting + endofDeleting, this.text.length());
        // unbolding
        if (leftPart.endsWith("**") && rightPart.startsWith("**")) {
            this.text = leftPart.substring(0, leftPart.length()-2)
                    + text
                    + rightPart.substring(2);
        } else if (rightPart.startsWith("**")) {
            this.text = leftPart
                    + "**"
                    + text
                    + rightPart.substring(2);
        } else if (leftPart.endsWith("**")) {
            this.text = leftPart.substring(0, leftPart.length()-2)
                    + text
                    + "**"
                    + rightPart;
        } else {
            this.text = leftPart + "**" + text + "**" + rightPart;
        }
    }


    // getters and setters

    public String getText() {
        return text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

}
