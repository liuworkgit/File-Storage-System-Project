package ui.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// event handling related to folders
public class TopMenuBar implements ActionListener {

    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar(); // create menu bar
        JMenu fileMenu = new JMenu("File"); // create menu
        // add options to menu
        fileMenu.add(loadOp());
        fileMenu.add(saveOp());
        fileMenu.addSeparator(); // separator
        fileMenu.add(addFolderOp());
        fileMenu.add(deleteFolderOp());
        fileMenu.add(renameFolderOp());
        fileMenu.addSeparator(); // separator
        fileMenu.add(addPageOp());
        fileMenu.add(deletePageOp());
        // add menu to menu bar
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(fileMenu);

        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO ACTION PERFORMED MENUBAR
    }

    // EFFECTS: creates a menu item that lets the user load data
    public JMenuItem loadOp() {
        return new JMenuItem("Load File"); // stub
    }

    // EFFECTS: creates a menu item that lets the user load data
    public JMenuItem saveOp() {
        return new JMenuItem("Save File"); // stub
    }

    // EFFECTS: creates a menu item that lets the user load data
    public JMenuItem addFolderOp() {
        return new JMenuItem("Add Folder"); // stub
    }

    // EFFECTS: creates a menu item that lets the user load data
    public JMenuItem deleteFolderOp() {
        return new JMenuItem("Delete Folder"); // stub
    }

    // EFFECTS: creates a menu item that lets the user load data
    public JMenuItem renameFolderOp() {
        return new JMenuItem("Rename Folder"); // stub
    }

    // EFFECTS: creates a menu item that lets the user load data
    public JMenuItem addPageOp() {
        return new JMenuItem("Add Page"); // stub
    }

    // EFFECTS: creates a menu item that lets the user load data
    public JMenuItem deletePageOp() {
        return new JMenuItem("Delete Page"); // stub
    }

}
