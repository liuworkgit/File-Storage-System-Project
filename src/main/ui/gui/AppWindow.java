package ui.gui;

import javax.swing.*;
import java.awt.*;

// Based on the Menu Demo Project from the Oracle Java Documentation
// Link to original code: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html

// the window in which the app appears
public class AppWindow extends JFrame {
    private JFrame window;
    private JPanel sidePanel;
    protected static final int WIDTH = 600;
    protected static final int HEIGHT = 550;

    // EFFECTS: creates a new application window with all the app's components
    public AppWindow() {
        window = new JFrame("NoteTaker");
        sidePanel = new JPanel(); // TODO REPURPOSE SIDE PANEL WITH TREE
        TopMenuBar topMenuBar = new TopMenuBar();
        TextArea textArea = new TextArea();

        // add to jframe + align
        window.setLayout(new BorderLayout());
        window.setJMenuBar(topMenuBar.createMenuBar());
        window.add(sidePanel, BorderLayout.LINE_START);
        window.add(textArea.createTextArea(), BorderLayout.CENTER);

        // visibility + behaviour on close
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setVisible(true);

        // settings
        adjustSidePanel(sidePanel);

    }

    // EFFECTS: sets side panel settings
    public void adjustSidePanel(JPanel sidePanel) {
        sidePanel.setBackground(Color.GRAY);
        sidePanel.setPreferredSize(new Dimension(150, HEIGHT - 60));
    }
}
