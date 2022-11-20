package ui.gui;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;

// TODO - FINISH MYTREELISTENER IMPLEMENTATION
public class MyTreeListener implements TreeModelListener {
    public void treeNodesChanged(TreeModelEvent e) {
        DefaultMutableTreeNode node;
        node = (DefaultMutableTreeNode) e.getTreePath().getLastPathComponent();

        /*
         * If the event lists children, then the changed
         * node is the child of the node we have already
         * gotten.  Otherwise, the changed node and the
         * specified node are the same.
         */
        try {
            int index = e.getChildIndices()[0];
            node = (DefaultMutableTreeNode) node.getChildAt(index);
        } catch (NullPointerException exc) {
            // pass
        }
        System.out.println("The user has finished editing the node.");
        System.out.println("New value: " + node.getUserObject());
        // TODO - SET SPECIFIC FOLDER/PAGE'S NAME AS NODE'S USER OBJECT
    }

    public void treeNodesInserted(TreeModelEvent e) {
    }

    public void treeNodesRemoved(TreeModelEvent e) {
    }

    public void treeStructureChanged(TreeModelEvent e) {
    }
}
