package model;

import java.util.ArrayList;
import java.util.List;

// represents a data node in a tree
public class DataNode {
    private String name;

    // EFFECT: creates a data node with the given name
    public DataNode(String name) {
        this.name = name;
    }

    // EFFECT: returns the name of the datanode
    public String getName() {
        return name;
    }

    public List<DataNode> getChildren() {
        return null;
    }
}
