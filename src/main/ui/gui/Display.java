package ui.gui;

import model.Directory;
import model.Event;
import model.EventLog;
import model.Folder;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.swing.*;

// display window for the application
public class Display implements ActionListener, WindowListener {
    private JFrame window;
    private JPanel listArea;
    private JScrollPane listScrollPane;
    private JPanel buttonPane;
    private ImageIcon icon;

    private Directory dt;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/guinotes.json";

    private static final String ADD_COMMAND = "add";
    private static final String DELETE_COMMAND = "delete";
    private static final String SAVE_COMMAND = "save";
    private static final String LOAD_COMMAND = "load";
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    public Display() {
        window = new JFrame("NoteTaker Lite");
        setDirectory();
        setWindow();
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);

        listArea = new JPanel();
        listArea.setLayout(new BoxLayout(listArea, BoxLayout.PAGE_AXIS));
        listScrollPane = new JScrollPane(listArea);
        listScrollPane.setBackground(Color.red);
        listScrollPane.setPreferredSize(new Dimension(WIDTH, 300));

        icon = createImageIcon("icons/pageicon.png", "page icon");

        buttonPane = new JPanel();
        setButtonPane();

        window.add(listScrollPane, BorderLayout.PAGE_START);
        window.add(buttonPane, BorderLayout.PAGE_END);
        window.addWindowListener(this);
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
            saveFiles();
        }
        if (Objects.equals(command, LOAD_COMMAND)) {
            loadFiles();
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a folder to the directory
    public void addFiles() {
        String name = JOptionPane.showInputDialog("Enter name:");
        JLabel label = new JLabel(name, icon, JLabel.CENTER);

        dt.addItem(name);
        listArea.add(label);
        listArea.revalidate();
    }

    // MODIFIES: this
    // EFFECTS: deletes the last folder from the directory
    public void deleteFiles() {
        if (!dt.getListFolders().isEmpty()) {
            int index = dt.getListFolders().toArray().length - 1;
            dt.deleteItem(index);
            listArea.remove(index);
            listArea.revalidate();
            listArea.repaint();
        } else {
            JOptionPane.showMessageDialog(window, "There's nothing to delete.");
        }
    }

    // MODIFIES: this
    // EFFECTS: saves data
    public void saveFiles() {
        try {
            jsonWriter.open();
            jsonWriter.write(dt);
            jsonWriter.close();
            EventLog.getInstance().logEvent(new Event("Saved files."));
            JOptionPane.showMessageDialog(window, "Files saved.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(window, "Unable to save files.");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads in the folders in the directory
    public void loadFiles() {
        try {
            dt = jsonReader.read(); // fill our directory with stuff from our file
            listArea = updateLabels();
            listArea.revalidate();
            EventLog.getInstance().logEvent(new Event("Loaded files."));
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
    public JPanel updateLabels() {
        List<Folder> listFolders = dt.getListFolders();

        if (!listFolders.isEmpty()) {
            for (Folder folder : listFolders) {
                JLabel name = new JLabel(folder.getName(), icon, JLabel.CENTER);
                name.setVisible(true);
                listArea.add(name);
            }
        }
        return listArea;
    }

    // EFFECTS: creates an image icon
    public ImageIcon createImageIcon(String path, String description) {
        java.net.URL url = getClass().getResource(path);
        if (url != null) {
            return new ImageIcon(url, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    // EFFECTS: initializes the directory
    public void setDirectory() {
        dt = new Directory();
    }

    // eFFECTS: sets the settings for the window
    public void setWindow() {
        window.setSize(new Dimension(WIDTH, HEIGHT));
        window.setLayout(new BorderLayout());
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
        buttonPane.setPreferredSize(new Dimension(WIDTH, 100));
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        for (Event event : EventLog.getInstance()) {
            System.out.println(event.toString());
        }
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
