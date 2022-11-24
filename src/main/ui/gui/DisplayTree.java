package ui.gui;

import model.DataNode;
import model.Directory;

import javax.swing.*;
import javax.swing.tree.*;

// Based on Dynamic Tree Demo from docs.oracle.com
// Link to original code: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html

// visual representation of the directory
public class DisplayTree {
    protected DefaultMutableTreeNode root;
    protected TreeModel treeModel;
    protected JTree tree;
    private Directory dt = DataLog.getInstance().getDirectory();

    // EFFECT: creates a new empty display tree
    public JTree createTree() {
        root = new DefaultMutableTreeNode("Root Node");
        treeModel = new DefaultTreeModel(root);
        treeModel.addTreeModelListener(new MyTreeListener());

        tree = new JTree(treeModel);
//        tree = new JTree(root);
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(true);

        return tree;
    }

    // EFFECTS: adds a node to the display tree and displays it
    // Note: this is not the same as adding a folder/page to the directory.
    public DefaultMutableTreeNode addNode() {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = tree.getSelectionPath();

        if (parentNode == null) {
            parentNode = root;
        } else {
            parentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();
        }

        // TODO - STARTED NOV 21 - FINISH
        return new DefaultMutableTreeNode(); // stub
    } // TODO - WIP

    // EFFECT: updates the tree's appearance based on the directory's contents
    public JTree updateDisplay() {
        return new JTree(); // stub
    } // TODO - WIP

    // EFFECT: displays the directory's contents as a tree.
    public void updateTree(DataNode parentData, DefaultMutableTreeNode parentContainer) {
        for (DataNode childData : parentData.getChildren()) {
            DefaultMutableTreeNode childContainer = new DefaultMutableTreeNode(childData.getName());
            parentContainer.add(childContainer);
            updateTree(childData, childContainer);
        } // TODO - WIP
    }
}
