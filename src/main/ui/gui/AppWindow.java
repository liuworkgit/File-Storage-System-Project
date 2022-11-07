package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.util.*;

// the window in which the app appears
public class AppWindow extends JFrame {
    private JFrame window;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 550;

    // EFFECTS: creates a new application window with all the app's components
    public AppWindow() {
        window = new JFrame("NoteTaker");
        JPanel sidebar = new JPanel();
        JPanel textWindow = new JPanel();
        JPanel menuBar = new JPanel();

        // settings
        adjustSidebar(sidebar);
        adjustTextWindow(textWindow);
        adjustMenuBar(menuBar);

        // add to jframe + align
        window.setLayout(new BorderLayout());
        window.add(menuBar, BorderLayout.PAGE_START);
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

    // EFEFCTS: sets menu bar settings
    public void adjustMenuBar(JPanel menuBar) {
        menuBar.setBackground(Color.DARK_GRAY);
        menuBar.setPreferredSize(new Dimension(WIDTH, 60));
    }
}
