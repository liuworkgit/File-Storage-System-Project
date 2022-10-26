package model;

import java.util.List;
import java.util.ArrayList;

// a folder of all note page folders
public class Directory implements CanDisplay {
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

    // EFFECTS: shows all folders as a list of options
    public String displayChoices() {
        String message = "";
        for (Folder folder : listFolders) {
            int index = listFolders.indexOf(folder);
            String strIndex = String.valueOf(index + 1);
            String option = "[" + strIndex + "] " + folder.getName();
            message = message + option + "\n";
        }
        return message;
    }

    // getters

    public List<Folder> getListFolders() {
        return listFolders;
    }
}
