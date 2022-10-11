package model;

// A paragraph on a page
public class Paragraph {
    private int id;
    private String text;

    // REQUIRES: text cannot be empty
    // EFFECTS: creates a new paragraph
    public Paragraph(String text) {
        this.text = text;
        this.id = 1;
    }

    // REQUIRES: text cannot be empty
    // MODIFIES: this
    // EFFECTS: deletes text for as long as backspace is held. once there's no more text, the paragraph
    // disappears from the page
    // page list - tips on implement?
    // ASK TA ABOUT THIS !!!!!!!!!!!!!
    public void deleteText() {}

    // REQUIRES: text cannot be empty
    // MODIFIES: this
    // EFFECTS: puts double asterixes around the text
    public void boldText() {}

    // REQUIRES: text cannot be empty
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
