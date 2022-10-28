package model;

// an object that can store a collection
public interface CanDisplay {
    // EFFECTS: displays items as options in an options menu
    String displayChoices();

    // REQUIRES: text cannot be empty
    // MODIFIES: this
    // EFFECTS: adds an item with the given text to an object's collection
    void addItem(String text);

    // MODIFIES: this
    // EFFECTS: deletes an item from an object's collection
    void deleteItem(int index);
}
