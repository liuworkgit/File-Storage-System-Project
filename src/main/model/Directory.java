package model;

import java.util.List;

// a folder of all note page folders
public class Directory {
    private List<PageFolder> listFolders;

    public Directory() {
        listFolders = new ArrayList<>();
    }

    public void addFolder(String name) {}
    // addFolder calls PageFolder(), if same name as other folder add (2) on end

    public void removeFolder(String name) {}


    // getters

    public List<PageFolder> getListFolders() {}
}
