package model;

import java.util.List;
import java.util.ArrayList;

// a folder of all note page folders
public class Directory {
    private List<Folder> listFolders;

    public Directory() {
        listFolders = new ArrayList<>();
    }

    // REQUIRES: name cannot be empty string
    // MODIFIES: this
    // EFFECTS: adds a folder with the given name to the directory
    public void addFolder(String name) {
        listFolders.add(new Folder(name));
    }

    // MODIFIES: this
    // EFFECTS: deletes folder associated with given index from directory
    public void deleteFolder(int index) {
        listFolders.remove(index);
    }


    // getters

    public List<Folder> getListFolders() {
        return listFolders;
    }
}
