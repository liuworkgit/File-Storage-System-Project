package ui;

// generic ui functionality
public abstract class UiFunctions {
    public void noItemsMessage(String item) {
        System.out.println("You have no " + item + " currently.");
    }
}
