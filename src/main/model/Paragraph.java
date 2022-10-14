package model;

// A paragraph on a page.
public class Paragraph {
    private int id;
    private String text; // RESTRICTIONS: text cannot have three or more consecutive asterixes (*)

    // REQUIRES: text cannot be empty string
    // EFFECTS: creates a new paragraph
    public Paragraph(String text) {
        this.text = text;
        this.id = 1;
    }

    // REQUIRES: text cannot be empty string
    // MODIFIES: this
    // EFFECTS: adds text to the paragraph
    public void addText(String text) {}

    // REQUIRES: text cannot be empty string and must be in this.text
    // MODIFIES: this
    // EFFECTS: deletes the inputted text from the paragraph. once there's no more text, the paragraph
    // disappears from the page
    // page list - tips on implement?
    // ASK TA ABOUT THIS !!!!!!!!!!!!!
    public void deleteText(String text) {}

    // REQUIRES: this.text cannot be empty string
    // MODIFIES: this
    // EFFECTS: bolds the text by putting double asterixes around the chosen text
    public void boldText(String text) {}

    // REQUIRES: this.text cannot be empty string
    // EFFECTS: returns the paragraph's text
    public String getText() {
        return text;
    }

    // EFFECTS: returns the paragraph's id
    public int getId() {
        return id;
    }

    // when make methods private/public
    // - depends on who's using it
    // how to do id - increment values
    // - in page,
    //
    // how to implement delete stuff in string?

}
