package ui.gui;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;

// Based on the Tree Demo Project 2 from the Oracle Java Documentation
// Link to original code: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html

// represents the sidebar that displays folders in the application
public class SideBar implements Dimensions {

    // EFFECTS: creates the sidebar that displays all the folders
    public Container createSideBar() {
        JScrollPane sidebar = new JScrollPane();
        JTree tree = createTree();

        sidebar.add(tree);
        return sidebar;
    }

    // EFFECTS: sets sidebar settings
    public void adjustSidePanel(JPanel sidebar) {
        sidebar.setBackground(Color.GRAY);
        sidebar.setPreferredSize(new Dimension(150, height - 60));
    }

    // EFFECTS: creates a tree
    public JTree createTree() {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("PLACEHOLDER NAME");
        DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
//        treeModel.addTreeModelListener(new createTreeModelListener());

        JTree tree = new JTree(treeModel);
        tree.setEditable(true); // can change name of nodes
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION); // one selection at time
        tree.setShowsRootHandles(true); // shows node names?

        return new JTree(); // stub // TODO TREE
    }
}
