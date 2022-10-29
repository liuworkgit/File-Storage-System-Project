package ui;

// possible messages to prompt user behaviour
public abstract class MessageToUser {
    // EFFECTS: prints out a warning message if there are no items to operate on
    public void noItemsMessage(String item) {
        System.out.println("You have no " + item + " currently.");
    }

    // EFFECTS: prints a message asking user to select something
    public void selectMessage(String item) {
        System.out.println("Select a " + item + " to view.");
    }
}