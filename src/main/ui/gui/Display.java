package ui.gui;

import model.Directory;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

/**
 * SOLUTION, CREATE A DIRECTORY, PUT ONE FOLDER IN IT, AND HAVE THE ADD FUNCTION RELATE
 * TO ADDING PAGES AND THAT ALONE
 * */

// display window for the application
public class Display implements ActionListener {
    private JFrame window;
    private JPanel listArea;
    private JScrollPane listScrollPane;
    private JPanel buttonPane;

    private Directory dt;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private static final String ADD_COMMAND = "add";
    private static final String DELETE_COMMAND = "delete";
    private static final String SAVE_COMMAND = "save";
    private static final String LOAD_COMMAND = "load";

    public Display() {
        window = new JFrame("NoteTaker Lite");
        setWindow();
        setDirectory();

        listArea = new JPanel();
        listScrollPane = new JScrollPane(listArea);
        listScrollPane.setPreferredSize(new Dimension(550, 250));
        listScrollPane.setBackground(Color.red);

        buttonPane = new JPanel();
        setButtonPane();

        window.add(listScrollPane, BorderLayout.PAGE_START);
        window.add(buttonPane, BorderLayout.PAGE_END);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (Objects.equals(command, ADD_COMMAND)) {
            // TODO
        }
        if (Objects.equals(command, DELETE_COMMAND)) {
            // TODO
        }
        if (Objects.equals(command, SAVE_COMMAND)) {
            // TODO
        }
        if (Objects.equals(command, LOAD_COMMAND)) {
            loadFiles();
        }
    }

    // EFFECTS: loads in the pages of the first folder in the directory
    public void loadFiles() {

    }

    // EFFECTS: initializes the directory
    public void setDirectory() {
        dt = new Directory();
    }

    // eFFECTS: sets the settings for the window
    public void setWindow() {
        window.setSize(new Dimension(600, 400));
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBackground(Color.green);
    }

    // EFFECTS: creates the button pane
    public void setButtonPane() {
        JButton addButton = new JButton("Add");
        addButton.setActionCommand(ADD_COMMAND);
        addButton.addActionListener(this);
        buttonPane.add(addButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setActionCommand(DELETE_COMMAND);
        deleteButton.addActionListener(this);
        buttonPane.add(deleteButton);

        JButton saveButton = new JButton("Save");
        saveButton.setActionCommand(SAVE_COMMAND);
        saveButton.addActionListener(this);
        buttonPane.add(saveButton);

        JButton loadButton = new JButton("Load");
        loadButton.setActionCommand(LOAD_COMMAND);
        loadButton.addActionListener(this);
        buttonPane.add(loadButton);

        buttonPane.setBackground(Color.yellow);
    }
}
