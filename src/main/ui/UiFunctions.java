package ui;

// generic ui functionality
public abstract class UiFunctions {
    // EFFECTS: prints out a warning message if there are no items to operate on
    public void noItemsMessage(String item) {
        System.out.println("You have no " + item + " currently.");
    }

    // EFFECTS: runs a certain level of the app
    public abstract void run();

    // EFFECTS: shows the options menu
    public abstract void showMenu();

    // EFFECTS: processes user input
    public abstract void process(int command);
}