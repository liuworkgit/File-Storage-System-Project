package ui.gui;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import model.Directory;
import model.Page;

// Based on the Dynamic Tree Demo Project from the Oracle Java Documentation
// Link to original code: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html

// represents the sidebar that displays folders in the application
public class SideBar implements TreeSelectionListener, ActionListener {
    private JPanel sidebar;
    private JScrollPane scrollPane;

    private JPanel buttonPanel;
    private static String ADD_PAGE = "add page";
    private static String DELETE_PAGE = "delete page";
    private static String ADD_FOLDER = "add folder";
    private static String DELETE_FOLDER = "delete folder";

    private JTree tree;
    private DefaultMutableTreeNode root;

    // EFFECTS: creates the sidebar that displays all the folders
    public JPanel createSideBar() {
        tree = createTree(); // create tree and put in scroll pane
        scrollPane = new JScrollPane(tree);

        buttonPanel = new JPanel(); // create button panel and add buttons
        buttonPanel.setLayout(new GridLayout(2, 2));
        addButtons(buttonPanel);

        sidebar = new JPanel(); // create sidebar and add scroll pane and button pane
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.PAGE_AXIS));
        sidebar.add(scrollPane);
        sidebar.add(buttonPanel);

        return sidebar;
    }

    // EFFECTS: adds buttons to the sidebar
    public void addButtons(JPanel panel) {
        JButton addPage = new JButton("Add Page");
        addPage.setActionCommand(ADD_PAGE);
        addPage.addActionListener(this);
        panel.add(addPage);

        JButton deletePage = new JButton("Delete Page");
        deletePage.setActionCommand(DELETE_PAGE);
        deletePage.addActionListener(this);
        panel.add(deletePage);

        JButton addFolder = new JButton("Add Folder");
        addFolder.setActionCommand(ADD_FOLDER);
        addFolder.addActionListener(this);
        panel.add(addFolder);

        JButton deleteFolder = new JButton("Delete Folder");
        deleteFolder.setActionCommand(DELETE_FOLDER);
        deleteFolder.addActionListener(this);
        panel.add(deleteFolder);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (Objects.equals(command, ADD_PAGE)) {
            // TODO - ADD PAGE NODE TO DISPLAY TREE
        } else if (Objects.equals(command, DELETE_PAGE)) {
            // TODO
        } else if (Objects.equals(command, ADD_FOLDER)) {
            // TODO
        } else if (Objects.equals(command, DELETE_FOLDER)) {
            // TODO
        }
    }

    // EFFECTS: creates a tree
    public JTree createTree() {
        DisplayTree dt;
        dt = new DisplayTree();
        JTree tree = dt.createTree();

        // set icon for leaf nodes
        // Icon is Bookmark Page icon from icons8.com
        // link here: https://icons8.com/icon/111779/bookmark-page
        ImageIcon leafIcon = createImageIcon("icons/pageicon.png");
        if (leafIcon != null) {
            DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
            renderer.setLeafIcon(leafIcon);
            tree.setCellRenderer(renderer);
        } else {
            System.err.println("Leaf icon missing; using default.");
        }

        return tree;
    }

    // EFFECTS: changes the current tree in the sidebar
    public void updateTree() {
        // TODO
    }

    // TODO - IF NODE SELECTED IS LEAF NODE, DISPLAY LEAF NODE IN TEXTAREA (CALL DISPLAYPAEG)
    public void valueChanged(TreeSelectionEvent event) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node == null) {
            return;
        }

        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
            Page page = (Page) nodeInfo;
            JOptionPane.showMessageDialog(null,
                    "find way to get page to show up in text area");
        }
    }

    // EFFECTS: creates an image icon to represent leaf nodes
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = SideBar.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
