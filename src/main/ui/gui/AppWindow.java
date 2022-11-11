package ui.gui;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

// the window in which the app appears
public class AppWindow extends JFrame {
    private JFrame window;
    private JPanel sidebar;
    private JPanel textWindow;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 550;

    // EFFECTS: creates a new application window with all the app's components
    public AppWindow() {
        window = new JFrame("NoteTaker");
        sidebar = new JPanel(); // TODO REPURPOSE SIDEBAR WITH TREE
        textWindow = new JPanel(); // TODO REPURPOSE TEXTWINDOW WITH SCROLL
        TopMenuBar topMenuBar = new TopMenuBar();

        // settings
        adjustSidebar(sidebar);
        adjustTextWindow(textWindow);

        // add to jframe + align
        window.setLayout(new BorderLayout());
        window.setJMenuBar(topMenuBar.createMenuBar());
        window.add(sidebar, BorderLayout.LINE_START);
        window.add(textWindow, BorderLayout.CENTER);

        // visibility + behaviour on close
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setVisible(true);
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
}
