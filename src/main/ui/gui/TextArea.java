package ui.gui;

import javax.swing.*;
import java.awt.*;

import model.Page;

// Based on the Menu Demo Project from the Oracle Java Documentation
// Link to original code: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html

// represents the text area of the application
public class TextArea implements Dimensions {

    // EFFECTS: creates the text area
    public JScrollPane createTextArea() {
        JTextArea textArea = new JTextArea(height, width);
        textArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        return scrollPane;
    }

    // EFFECTS: displays a page in the text area
    public void displayPage() {
        // 1. get page from folder
        // 2. get name of page, set Jlabel as page name
        // 3. get paragraphs, for each paragraph textArea.setText(text) + hit enter
    }

    // TODO - KEEP THIS ONE OR THE ONE IN APPWINDOW?
    // EFFECTS: sets text window settings
    public void adjustTextPanel(JPanel textWindow) {
        textWindow.setBackground(Color.white);
        textWindow.setPreferredSize(new Dimension(450, height - 60));
    }
}