package ui.gui;

import model.Directory;
import model.Folder;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;
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
    private static final String JSON_STORE = "./data/guinotes.json";

    private static final String ADD_COMMAND = "add";
    private static final String DELETE_COMMAND = "delete";
    private static final String SAVE_COMMAND = "save";
    private static final String LOAD_COMMAND = "load";

    public Display() {
        window = new JFrame("NoteTaker Lite");
        setWindow();
        setDirectory();
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);

        listArea = new JPanel(); // TODO - ADD A LISTENER TO LISTAREA SO IT CAN RECEIVE UPDATES
        listScrollPane = new JScrollPane(listArea);
        listScrollPane.setBackground(Color.red);
        listScrollPane.setPreferredSize(new Dimension(600, 300));

        buttonPane = new JPanel();
        setButtonPane();

        window.add(listScrollPane, BorderLayout.PAGE_START);
        window.add(buttonPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (Objects.equals(command, ADD_COMMAND)) {
            addFiles();
        }
        if (Objects.equals(command, DELETE_COMMAND)) {
            deleteFiles();
        }
        if (Objects.equals(command, SAVE_COMMAND)) {
            // TODO
        }
        if (Objects.equals(command, LOAD_COMMAND)) {
            loadFiles();
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a folder to the directory
    public void addFiles() {}

    // MODIFIES: this
    // EFFECTS: deletes the last folder from the directory
    public void deleteFiles() {}

    // MODIFIES: this
    // EFFECTS: loads in the folders in the directory
    public void loadFiles() {
        try {
            dt = jsonReader.read(); // fill our directory with stuff from our file
            JOptionPane.showMessageDialog(window, "Successfully loaded files.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(window,
                    "Unable to load files.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    // MODIFIES: this, listArea
    // EFFECTS: updates the appearance of listArea
    // TODO - DO WE KNOW IF THIS WORKS? WON'T UNTIL WE IMPLEMENT ADD/DELETE
    public JPanel updateLabels() {
        List<Folder> listFolders = dt.getListFolders();

        if (!listFolders.isEmpty()) {
            for (Folder folder : listFolders) {
                JLabel name = new JLabel(folder.getName());
                name.setVisible(true);
                listArea.add(name);
            }
        }
        return listArea;
    }

    // EFFECTS: initializes the directory
    public void setDirectory() {
        dt = new Directory();
    }

    // eFFECTS: sets the settings for the window
    public void setWindow() {
        window.setSize(new Dimension(700, 500));
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
        buttonPane.setPreferredSize(new Dimension(600, 100));
    }
}
