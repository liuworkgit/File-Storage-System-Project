package ui.gui;

import javax.swing.*;
import java.util.*;

// the window in which the app appears
public class AppWindow extends JFrame {
    private JFrame window;

    // EFFECTS: creates a new application window with all the app's components
    public AppWindow() {
        window = new JFrame("NoteTaker");
        JPanel sidebar = new JPanel();
        JPanel textWindow = new JPanel();
        JPanel menuBar = new JPanel();

        // adjustments

        window.add(sidebar);
        window.add(textWindow);
        window.add(menuBar);
    }
}
