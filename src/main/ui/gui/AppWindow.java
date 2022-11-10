package ui.gui;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

// the window in which the app appears
public class AppWindow extends JFrame {
    private JFrame window;
    private JPanel sidebar;
    private JPanel textWindow;
    private JMenuBar topMenuBar;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 550;

    // EFFECTS: creates a new application window with all the app's components
    public AppWindow() {
        window = new JFrame("NoteTaker");
        sidebar = new JPanel();
        textWindow = new JPanel();
        topMenuBar = new JMenuBar();

        // settings
        adjustSidebar(sidebar);
        adjustTextWindow(textWindow);
        adjustMenuBar(topMenuBar);

        // add to jframe + align
        window.setLayout(new BorderLayout());
        window.add(topMenuBar, BorderLayout.PAGE_START);
        window.add(sidebar, BorderLayout.LINE_START);
        window.add(textWindow, BorderLayout.CENTER);

        // visibility + behaviour on close
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setVisible(true);

        // TODO n EVENT IMPLEMENTATION
        // Event impl goes here
    }

    // EFFECTS: sets sidebar settings
    public void adjustSidebar(JPanel sidebar) {
        sidebar.setBackground(Color.GRAY);
        sidebar.setPreferredSize(new Dimension(150, HEIGHT - 60));
    }

    // EFFECTS: sets text window settings
    public void adjustTextWindow(JPanel textWindow) {
        textWindow.setBackground(Color.white);
        textWindow.setPreferredSize(new Dimension(450, HEIGHT - 60));
    }

    // EFFECTS: sets menu bar implementation, including event handling
    public void adjustMenuBar(JMenuBar menuBar) {
        // create components
        JLabel label = new JLabel("NoteTaker");
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadOption = new JMenuItem("Open File");
        JMenuItem saveOption = new JMenuItem("Save File");
        JMenuItem addFolder = new JMenuItem("Add Folder");
        JMenuItem deleteFolder = new JMenuItem("Delete Folder");
        JMenuItem renameFolder = new JMenuItem("Rename Folder");
        JMenuItem addPage = new JMenuItem("Add Page");
        JMenuItem deletePage = new JMenuItem("Delete Page");

        menuBar.add(label);
        fileMenu.add(loadOption);
        fileMenu.add(saveOption);
        fileMenu.addSeparator(); // separator
        fileMenu.add(addFolder);
        fileMenu.add(deleteFolder);
        fileMenu.add(renameFolder);
        fileMenu.addSeparator(); // separator
        fileMenu.add(addPage);
        fileMenu.add(deletePage);
        menuBar.add(fileMenu);
    }
}
