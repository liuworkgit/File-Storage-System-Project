package persistence;

import model.Directory;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// NOTE: Based on JsonSerializationDemo provided by CPSC210
// Found on Phase 2 page on CPSC210 edx
// Link to repository:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// represents a writer that writes json data to a destination
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: creates a writer to write data to a destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer for writing
    //          throws FileNotFoundException if destination file can't be opened
    public void open() throws FileNotFoundException {}

    // MODIFIES: this
    // EFFECTS: writes JSON representation of directory to file
    public void write(Directory dr) {}

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {}

    // MODIFIES: this
    // EFFECTS: writes a string to file
    private void saveToFile(String json) {}
}
