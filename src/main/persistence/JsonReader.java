package persistence;

// NOTE: Based on JsonSerializationDemo provided by CPSC210
// Found on Phase 2 page on CPSC210 edx
// Link to repository:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

import model.Directory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// represents a reader that reads data from a save file
public class JsonReader {
    private String source;

    // EFFECTS: creates a reader to read from a source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads directory from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Directory read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseDirectory(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses directory from data and returns it
    public Directory parseDirectory(JSONObject jsonObject) {
        return new Directory(); // stub
    }

    // modifies: directory
    // EFFECTS: parses list of folders from json object and adds them to directory
    public void addListFolders(Directory directory, JSONObject jsonObject) {}

    // MODIFIES: directory
    // EFFECTS: parses a page folder from json object and adds it to directory
    public void addFolder(Directory directory, JSONObject jsonObject) {}

//    // EFFECTS: parses workroom from JSON object and returns it
//    private WorkRoom parseWorkRoom(JSONObject jsonObject) {
//        String name = jsonObject.getString("name");
//        WorkRoom wr = new WorkRoom(name);
//        addThingies(wr, jsonObject);
//        return wr;
//    }
//    // MODIFIES: wr
//    // EFFECTS: parses thingies from JSON object and adds them to workroom
//    private void addThingies(WorkRoom wr, JSONObject jsonObject) {
//        JSONArray jsonArray = jsonObject.getJSONArray("thingies");
//        for (Object json : jsonArray) {
//            JSONObject nextThingy = (JSONObject) json;
//            addThingy(wr, nextThingy);
//        }
//    }
//
//    // MODIFIES: wr
//    // EFFECTS: parses thingy from JSON object and adds it to workroom
//    private void addThingy(WorkRoom wr, JSONObject jsonObject) {
//        String name = jsonObject.getString("name");
//        Category category = Category.valueOf(jsonObject.getString("category"));
//        Thingy thingy = new Thingy(name, category);
//        wr.addThingy(thingy);
//    }
}
