package ui.gui;

import model.Directory;
import model.Folder;

import javax.swing.*;
import javax.swing.tree.*;

// Based on Dynamic Tree Demo from docs.oracle.com
// Link to original code: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html

// visual representation of the directory
public class DisplayTree {
    protected DefaultMutableTreeNode root;
    protected TreeModel treeModel;
    protected JTree tree;

    // EFFECT: creates a new empty display tree
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
    } // stub

    // EFFECT: displays the directory's contents as a tree.
    public void displayNodes(Object dataNode, DefaultMutableTreeNode treeNode) {
        Directory dt = DataLog.getInstance().getDirectory();
        for (Object obj: dt.getListFolders()) {
            /**
             * DefaultMutableTreeNode childContainer = new DefaultMutableTreeNode(childData.getName());
             *             parentContainer.add(childContainer);
             *             addChildren(childContainer, childData); // close your eyes; trust the natural recursion!
             * */
//            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(...));
//            treeNode.add(childNode);
//            displayNodes(/);
        }
    }
}
