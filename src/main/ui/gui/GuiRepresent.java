package ui.gui;

import model.Directory;

// Dimensions of the GUI window
public abstract class GuiRepresent {
    protected int width = 700;
    protected int height = 550;
    protected Directory directory;

    public Directory getDirectory() {
        return directory;
    }
}
