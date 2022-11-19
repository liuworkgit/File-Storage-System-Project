package ui.gui;

import javax.swing.*;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import model.Directory;
import model.Folder;
import model.Page;
import ui.gui.DisplayTree;

// Based on the Tree Demo Project from the Oracle Java Documentation
// Link to original code: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html

// TODO - NEED SIDEBAR AND TEXTAREA TO ACCESS DIRECTORY IN ORDER TO VISUALIZE PAGES BUT UNSURE HOW
// TODO - IF MENUBAR CONTAINS DIRECTORY, MENU FUNCTIONALITY AND DIRECTORY CHANGES LINKED
// TODO - HAVE A GETTER THAT PASSES DIRECTORY TO SIDEBAR AND TEXTAREA

// represents the sidebar that displays folders in the application
public class SideBar extends GuiTraits implements TreeSelectionListener {
    protected JTree tree;
    private JScrollPane sidebar;
    private DefaultMutableTreeNode root;

    // EFFECTS: creates the sidebar that displays all the folders
    public Container createSideBar() {
        tree = createTree();
        sidebar = new JScrollPane(tree); // create scroll pane and add tree to it
        adjustSideBar(sidebar);

        return sidebar;
    }

    // EFFECTS: sets sidebar settings
    public void adjustSideBar(JScrollPane sidebar) {
        Dimension dimension = new Dimension(150, height - 60);
        sidebar.setPreferredSize(dimension);
    }

    // EFFECTS: creates a tree
    public JTree createTree() {
        DisplayTree dt = new DisplayTree();
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
//        // create nodes
//        root = new DefaultMutableTreeNode("Directory"); // TODO - TOGGLE NAME VISIBLE OFF?
//        createNodes();
//
//        // create single selection tree
//        JTree tree = new JTree(root);
//        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
//
//        // set icon for leaf nodes
//        // Icon is Bookmark Page icon from icons8.com
//        // link here: https://icons8.com/icon/111779/bookmark-page
//        ImageIcon leafIcon = createImageIcon("icons/pageicon.png");
//        if (leafIcon != null) {
//            DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
//            renderer.setLeafIcon(leafIcon);
//            tree.setCellRenderer(renderer);
//        } else {
//            System.err.println("Leaf icon missing; using default.");
//        }
//
//        // listen for when selection changes
//        tree.addTreeSelectionListener(this); // TODO - ADD LISTENER TO TREE NOT SIDEBAR?
//
//        return tree;
    }

    public void valueChanged(TreeSelectionEvent event) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node == null) {
            return;
        }

        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
            // TODO - IF NODE SELECTED IS LEAF NODE, DISPLAY LEAF NODE IN TEXTAREA (CALL DISPLAYPAEG)
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

    // EFFECTS: creates the nodes based on elements in the directory // TODO - PRINTS ITEMS IN DIRECTORY TO TREE
    public void createNodes() {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode leaf = null;

        for (Folder folder: directory.getListFolders()) {
            category = new DefaultMutableTreeNode(folder);
            for (Page page: folder.getListPages()) {
                leaf = new DefaultMutableTreeNode(page);
                category.add(leaf);
            }
            root.add(category);
        }
    }
}
