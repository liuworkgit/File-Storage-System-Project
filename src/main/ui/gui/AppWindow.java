package ui.gui;

import javax.swing.*;
import java.awt.*;

// Based on the Menu Demo Project from the Oracle Java Documentation
// Link to original code: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html

// the window in which the app appears
public class AppWindow extends JFrame implements Dimensions {
    private JFrame window;
    protected static final int WIDTH = width;
    protected static final int HEIGHT = height;

    // EFFECTS: creates a new application window with all the app's components
    public AppWindow() {
        window = new JFrame("NoteTaker");
        TopMenuBar topMenuBar = new TopMenuBar();
        TextArea textArea = new TextArea();
        SideBar sideBar = new SideBar();

        // add to jframe + align
        window.setLayout(new BorderLayout());
        window.setJMenuBar(topMenuBar.createMenuBar());
        window.add(sideBar.createSideBar(), BorderLayout.LINE_START);
        window.add(textArea.createTextArea(), BorderLayout.CENTER);

        // visibility + behaviour on close
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setVisible(true);
    }
}
