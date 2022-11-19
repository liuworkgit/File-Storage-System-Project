package ui.gui;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;

// Based on Dynamic Tree Demo from docs.oracle.com
// Link to original code: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html

// applicatoin0specific listener
public class MyTreeModelListener implements TreeModelListener {
    public void treeNodesChanged(TreeModelEvent e) {
        DefaultMutableTreeNode node;
        node = (DefaultMutableTreeNode)
                (e.getTreePath().getLastPathComponent());

        try {
            int index = e.getChildIndices()[0];
            node = (DefaultMutableTreeNode)
                    (node.getChildAt(index));
        } catch (NullPointerException exc) {
            // pass
        }

        System.out.println("The user has finished editing the node.");
        System.out.println("New value: " + node.getUserObject());
    }

    public void treeNodesInserted(TreeModelEvent e) {}

    public void treeNodesRemoved(TreeModelEvent e) {}

    public void treeStructureChanged(TreeModelEvent e) {}
}
