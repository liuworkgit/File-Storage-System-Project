package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

import model.Directory;
import model.Folder;
import persistence.JsonReader;
import persistence.JsonWriter;

// Based on the Menu Demo Project from the Oracle Java Documentation
// Link to original code: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html

// the window in which the app appears
public class AppWindow extends GuiRepresent implements ActionListener {
    private JFrame window;
    private TextArea textArea;
    private SideBar sideBar;
//    private TopMenuBar topMenuBar;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/notes.json";

    // EFFECTS: creates a new application window with all the app's components
    public AppWindow() {
        window = new JFrame("NoteTaker");
//        topMenuBar = new TopMenuBar();
        textArea = new TextArea();
        sideBar = new SideBar();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        directory = new Directory();

        // TODO - TEST
        directory.addItem("test folder");
        directory.addItem("folder name");
        Folder testFolder = directory.getListFolders().get(0);
        testFolder.addItem("page name");

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
        // add menu to menu bar
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(fileMenu);

        return menuBar;
    }

    // dictates the action performed when a menu item is selected
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();
        if (Objects.equals(source.getText(), "Load Files")) {
            loadFiles();
        }
        if (Objects.equals(source.getText(), "Save Files")) {
            saveFiles();
        }
    }

    // MODIFIES: this
    // EFFECTS: loads data into the application
    public void loadFiles() {
        try {
            directory = jsonReader.read();
            System.out.println("The user has loaded all files.");
            JOptionPane.showMessageDialog(window, "Files loaded.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(window, "Unable to load files.");
        }
    }

    // MODIFIES: this
    // EFFECTS: saves data
    public void saveFiles() {
        try {
            jsonWriter.open();
            jsonWriter.write(directory);
            jsonWriter.close();
            System.out.println("The user has saved all files.");
            JOptionPane.showMessageDialog(window, "Files saved.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(window, "Unable to save files.");
        }
    }

    // EFFECTS: creates a menu item
    public JMenuItem createMenuItem(String purpose) {
        JMenuItem option = new JMenuItem(purpose);
        option.addActionListener(this);
        return option;
    }
}
