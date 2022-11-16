package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.Directory;
import persistence.JsonReader;
import persistence.JsonWriter;

// Based on the Menu Demo Project from the Oracle Java Documentation
// Link to original code: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html

// the window in which the app appears
public class AppWindow extends JFrame implements Dimensions, ActionListener {
    private JFrame window;
    private TopMenuBar topMenuBar;
    private TextArea textArea;
    private SideBar sideBar;

    private Directory directory;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/notes.json";

    // EFFECTS: creates a new application window with all the app's components
    public AppWindow() {
        window = new JFrame("NoteTaker");
//        topMenuBar = new TopMenuBar();
        textArea = new TextArea();
        sideBar = new SideBar();
        directory = new Directory();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        // add to jframe + align
        window.setLayout(new BorderLayout());
//        window.setJMenuBar(topMenuBar.createMenuBar());
        window.setJMenuBar(createMenuBar());
        window.add(sideBar.createSideBar(), BorderLayout.LINE_START);
        window.add(textArea.createTextArea(), BorderLayout.CENTER);

        // visibility + behaviour on close
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(width, height);
        window.setVisible(true);
    }

    // creates a menu bar
    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar(); // create menu bar
        JMenu fileMenu = new JMenu("File"); // create menu
        // add options to menu
        fileMenu.add(createMenuItem("Load Files"));
        fileMenu.add(createMenuItem("Save Files"));
        fileMenu.addSeparator(); // separator
        fileMenu.add(createMenuItem("Add Folder"));
        fileMenu.add(createMenuItem("Delete Folder"));
        fileMenu.add(createMenuItem("Rename Folder"));
        fileMenu.addSeparator(); // separator
        fileMenu.add(createMenuItem("Add Page"));
        fileMenu.add(createMenuItem("Delete Page"));
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
            loadFiles();
        } else if (source.getText() == "Save File") {
            saveFiles();
        } else if (source.getText() == "Add Folder") {
            addFolder();
        } else if (source.getText() == "Delete Folder") {
            deleteFolder();
        } else if (source.getText() == "Rename Folder") {
            renameFolder();
        } else if (source.getText() == "Add Page") {
            addPage();
        } else if (source.getText() == "Delete Page") {
            deletePage();
        }
    }

    // MODIFIES: this
    // EFFECTS: loads data into the application
    public void loadFiles() {
        try {
            directory = jsonReader.read();
            JOptionPane.showMessageDialog(window, "Files loaded.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(window, "Unable to load files."); // TODO - POPUP NOT SHOWING
        }
    }

    // MODIFIES: this
    // EFFECTS: saves data
    public void saveFiles() {} // TODO

    public void addFolder() {} // TODO

    public void deleteFolder() {} // TODO

    public void renameFolder() {} // TODO

    public void addPage() {} // TODO

    public void deletePage() {} // TODO

    // EFFECTS: creates a menu item
    public JMenuItem createMenuItem(String purpose) {
        JMenuItem option = new JMenuItem(purpose);
        option.addActionListener(this);
        return option;
    }

}
