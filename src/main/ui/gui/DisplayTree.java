package ui.gui;

import model.Directory;

import javax.swing.*;
import javax.swing.tree.*;

// Based on Dynamic Tree Demo from docs.oracle.com
// Link to original code: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html

// visual representation of the directory
public class DisplayTree extends GuiRepresent {
    protected DefaultMutableTreeNode root;
    protected TreeModel treeModel;
    protected JTree tree;

    // EFFECT: creates a tree
    public JTree createTree() {
        root = new DefaultMutableTreeNode("Root Node");
        treeModel = new DefaultTreeModel(root);
        treeModel.addTreeModelListener(new MyTreeListener());

        tree = new JTree(treeModel);
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(true);

        return tree;
    }

    // EFFECT: displays the directory's contents as a tree.
    public void displayNodes() {

    }
}
