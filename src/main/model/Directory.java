package model;

import org.json.JSONObject;
import org.json.JSONArray;

import java.util.List;
import java.util.ArrayList;

// a folder of all note page folders
public class Directory extends DataNode implements CanDisplay, Writable {
    private List<Folder> listFolders;
    private List<DataNode> children;

    public Directory() {
        super("Directory");
        listFolders = new ArrayList<>();
        children = new ArrayList<>();
    }

    public void addItem(String name) {
        listFolders.add(new Folder(name));
        children.add(new DataNode(name));
        EventLog.getInstance().logEvent(new Event("Added folder "
                + "\""
                + name
                + "\""));
    }

    public void deleteItem(int index) {
        EventLog.getInstance().logEvent(new Event("Removed folder "
                + "\""
                + listFolders.get(index).getName()
                + "\""));
        listFolders.remove(index);
        children.remove(index);
    }

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

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("listFolders", arrayToJson());
        return json;
    }

    // EFFECTS: returns directory's folders as a json array
    public JSONArray arrayToJson() {
        JSONArray jsonFolder = new JSONArray();
        for (Folder folder : listFolders) {
            jsonFolder.put(folder.toJson());
        }

        return jsonFolder;
    }

    // getters
    public List<Folder> getListFolders() {
        return listFolders;
    }

    public List<DataNode> getChildren() {
        return children;
    }
}
