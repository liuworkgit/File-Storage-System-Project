package ui.gui;

import model.Directory;

// stores the singular directory that all classes in the gui access
public class DataLog {
    private static DataLog dataLog;
    private Directory dt;

    // EFFECT: creates a new data log. prevents external construction
    private DataLog() {
        dt = new Directory();
    }

    // getter
    public static DataLog getInstance() {
        return dataLog;
    }

    public Directory getDirectory() {
        return dt;
    }
}
