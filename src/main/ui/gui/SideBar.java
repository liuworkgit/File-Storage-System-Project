package ui.gui;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;

import model.Page;

// Based on the Tree Demo Project from the Oracle Java Documentation
// Link to original code: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html

// represents the sidebar that displays folders in the application
public class SideBar implements Dimensions {

    // EFFECTS: creates the sidebar that displays all the folders
    public Container createSideBar() {
        JTree tree = createTree();
        // create scroll pane and add tree to it
        JScrollPane sidebar = new JScrollPane();
        adjustSideBar(sidebar);
        sidebar.add(tree);

        return sidebar;
    }

    // EFFECTS: sets sidebar settings
    public void adjustSideBar(JScrollPane sidebar) {
//        sidebar.setBackground(Color.GRAY); // TODO - CHANGE AFTER ALL IS DONE
        sidebar.setPreferredSize(new Dimension(150, height - 60));
    }

    // EFFECTS: creates a tree
    public JTree createTree() {
        // create nodes
        DefaultMutableTreeNode root =
                new DefaultMutableTreeNode("Directory"); // TODO - TOGGLE NAME VISIBLE OFF?
        createTestNodes(root);

        // create single selection tree
        JTree tree = new JTree(root);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        // set icon for leaf nodes
        // Icon is One Page icon from icons8.com
        // link here: https://icons8.com/icon/92781/one-page
        ImageIcon leafIcon = createImageIcon("icons/page-icon.png");
        if (leafIcon != null) {
            DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
            renderer.setLeafIcon(leafIcon);
            tree.setCellRenderer(renderer);
        } else {
            System.err.println("Leaf icon missing; using default.");
        }

        // listen for when selection changes

        return new JTree(); // stub // TODO TREE
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

    // EFFECTS: creates test nodes to see if my shit works // TODO - TESTING METHOD
    private void createTestNodes(DefaultMutableTreeNode root) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode book = null;

        category = new DefaultMutableTreeNode("test folder");
        root.add(category);

        //original Tutorial
        book = new DefaultMutableTreeNode(new Page("test name"));
        category.add(book);
    }
}
