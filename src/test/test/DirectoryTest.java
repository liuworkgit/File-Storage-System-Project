package test;

import model.Directory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest {
    private Directory testDirectory;

    @BeforeEach
    void runBefore() {
        testDirectory = new Directory();
    }

    @Test
    void testDirectory() {
        assertEquals(new ArrayList<>(), testDirectory.getListFolders());
    }

    @Test
    void testAddFolder() {
        testDirectory.addItem("WWW");
        assertEquals("WWW", testDirectory.getListFolders().get(0).getName());
    }

    @Test
    void testDeleteFolder() {
        testDirectory.addItem("Work it!!! woo!!");
        testDirectory.deleteItem(0);
        assertEquals(new ArrayList<>(), testDirectory.getListFolders());
    }

    @Test
    void testAddMultiple() {
        testDirectory.addItem("Folder 1");
        testDirectory.addItem("Folder 2");
        assertEquals("Folder 1", testDirectory.getListFolders().get(0).getName());
        assertEquals("Folder 2", testDirectory.getListFolders().get(1).getName());
    }

    @Test
    void testAddThenDelete() {
        testDirectory.addItem("AAA");
        testDirectory.addItem("BBB");
        testDirectory.deleteItem(0);
        assertEquals("BBB", testDirectory.getListFolders().get(0).getName());
    }

    @Test
    void testDisplayChoices() {
        testDirectory.addItem("Test");
        testDirectory.addItem("Testing");
        assertEquals("[1] Test" + "\n[2] Testing" + "\n", testDirectory.displayChoices());
    }

    @Test
    void testToJson() {
        JSONObject jsonDr = testDirectory.toJson();
        assertTrue(jsonDr.getJSONArray("listFolders").isEmpty());
    }

    @Test
    void testFoldersToJson() {
        testDirectory.addItem("test"); // add folder to directory
        JSONObject jsonDr = testDirectory.toJson(); // convert directory to json
        JSONArray jsonFolders = jsonDr.getJSONArray("listFolders"); // get jsonarray from json directory
        JSONObject jsonObj = jsonFolders.getJSONObject(0); // get first object in jsonarray
        assertEquals("test", jsonObj.getString("name"));
    }
}
