package persistence;

import model.Directory;
import model.Folder;
import model.Page;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// NOTE: Based on JsonSerializationDemo provided by CPSC210
// Found on Phase 2 page on CPSC210 edx
// Link to repository:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// represents a reader that reads data from a save file
public class JsonReader {
    private String source;

    // EFFECTS: creates a reader to read from a source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads directory from file and returns it;
    //          throws IOException if an error occurs reading data from file
    public Directory read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObj = new JSONObject(jsonData);
        return parseDirectory(jsonObj);
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
        Directory dr = new Directory();
        addListFolders(dr, jsonObject);
        return dr;
    }

    // modifies: directory
    // EFFECTS: parses list of folders from json object and adds them to directory
    public void addListFolders(Directory dr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("listFolders");
        for (Object json : jsonArray) {
            JSONObject nextFolder = (JSONObject) json;
            addFolder(dr, nextFolder);
        }
    }

    // MODIFIES: directory
    // EFFECTS: parses a page folder from json object and adds it to directory
    public void addFolder(Directory dr, JSONObject jsonObject) {
        String name = jsonObject.getString("name"); // make new folder
        Folder folder = new Folder(name);
        dr.getListFolders().add(folder);

        JSONArray jsonPages = jsonObject.getJSONArray("listPages"); // get pages, add to folder
        for (Object json : jsonPages) {
            JSONObject nextPage = (JSONObject) json;
            addPage(folder, nextPage);
        }
    }

    // MODIFIES: folder, directory
    // EFFECTS: parses a page from json object and adds it to folder
    public void addPage(Folder folder, JSONObject jsonObject) {
        String name = jsonObject.getString("name"); // make new page
        Page page = new Page(name);
        folder.getListPages().add(page);

        JSONArray jsonParagraphs = jsonObject.getJSONArray("listParagraphs"); // get paragraphs, add to page
        for (Object json : jsonParagraphs) {
            JSONObject nextParagraph = (JSONObject) json;
            addParagraph(page, nextParagraph);
        }
        JSONArray jsonLinks = jsonObject.getJSONArray("listLinks"); // get links, add to page
        for (Object json : jsonLinks) {
            JSONObject nextLink = (JSONObject) json;
            addLink(page, nextLink);
        }
    }

    // MODIFIES: page, folder, directory
    // EFFECTS: parses a paragraph from json object and adds it to page
    public void addParagraph(Page page, JSONObject jsonObject) {
        String text = jsonObject.getString("text"); // make new page
        page.addItem(text);
    }

    // MODIFIES: page, folder, directory
    // EFFECTS: parses a link from json object and adds it to page
    public void addLink(Page page, JSONObject jsonObject) {
        String text = jsonObject.getString("link"); // make new page
        page.addLink(text);
    }
}
