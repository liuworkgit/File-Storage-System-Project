package ui.gui.unused;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// represents the menu bar of the application
public class TopMenuBar implements GuiSize, ActionListener {
    // creates a menu bar
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

    // dictates the action performed when a menu item is selected
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();
        if (source.getText() == "Load File") {
            // TODO MENUBAR
        } else if (source.getText() == "Save File") {
            // TODO MENUBAR
        } else if (source.getText() == "Add Folder") {
            // TODO MENUBAR
        } else if (source.getText() == "Delete Folder") {
            // TODO MENUBAR
        } else if (source.getText() == "Rename Folder") {
            // TODO MENUBAR
        } else if (source.getText() == "Add Page") {
            // TODO MENUBAR
        } else if (source.getText() == "Delete Page") {
            // TODO MENUBAR
        }
    }

    // EFFECTS: creates a menu item that lets the user load data
    public JMenuItem loadOp() {
        JMenuItem option = new JMenuItem("Load File");
        option.addActionListener(this);
        return option;
    }

    // EFFECTS: creates a menu item that lets the user save data
    public JMenuItem saveOp() {
        JMenuItem option = new JMenuItem("Save File");
        option.addActionListener(this);
        return option;
    }

    // EFFECTS: creates a menu item that lets the user add a new folder
    public JMenuItem addFolderOp() {
        JMenuItem option = new JMenuItem("Add Folder");
        option.addActionListener(this);
        return option;
    }

    // EFFECTS: creates a menu item that lets the user delete a folder
    public JMenuItem deleteFolderOp() {
        JMenuItem option = new JMenuItem("Delete Folder");
        option.addActionListener(this);
        return option;
    }

    // EFFECTS: creates a menu item that lets the user rename a folder
    public JMenuItem renameFolderOp() {
        JMenuItem option = new JMenuItem("Rename Folder");
        option.addActionListener(this);
        return option;
    }

    // EFFECTS: creates a menu item that lets the user add a page to the currently selected folder
    public JMenuItem addPageOp() {
        JMenuItem option = new JMenuItem("Add Page");
        option.addActionListener(this);
        return option;
    }

    // EFFECTS: creates a menu item that lets the user delete a page from the currently selected folder
    public JMenuItem deletePageOp() {
        JMenuItem option = new JMenuItem("Delete Page");
        option.addActionListener(this);
        return option;
    }

}
