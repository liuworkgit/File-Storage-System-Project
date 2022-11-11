package ui.gui;

import javax.swing.*;
import java.awt.*;

public class ApplicationWindow extends JFrame {
    private JFrame window;
    private SideBar sidebar;
    private TextWindow textWindow;
    private TopMenuBar topMenuBar;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 550;

    public ApplicationWindow() {
        topMenuBar = new TopMenuBar();
        window.setJMenuBar(topMenuBar.createMenuBar());

        // visibility + behaviour on close
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setVisible(true);
    }
}
