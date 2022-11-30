package ui.gui.unused;

import model.Directory;

// stores the singular directory that all classes in the gui access
public class DataLog {
    private static DataLog dataLog = new DataLog();
    private static Directory dt;

    // EFFECT: creates a new data log. prevents external construction
    private DataLog() {
        dt = new Directory();
    }

    // getter
    public static DataLog getInstance() {
        if (dataLog == null) {
            dataLog = new DataLog();
        }
        return dataLog;
    }

    public Directory getDirectory() {
        return dt;
    }
}
