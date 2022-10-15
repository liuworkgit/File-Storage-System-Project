package model;

import java.util.ArrayList;

// a folder of all note page folders
public class Directory {
    private ArrayList<PageFolder> listFolders;

    public Directory() {
        listFolders = new ArrayList<>();
    }

    public void addFolder() {} // addFolder calls PageFolder()

    public void removeFolder() {}
}
