package test;

import model.Folder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FolderTest {
    private Folder testFolder;

    @BeforeEach
    void runBefore() {
        testFolder = new Folder("GEOS 102 NOTES!!!");
    }

    @Test
    void testPageFolder() {
        assertEquals("GEOS 102 NOTES!!!", testFolder.getName());
        assertEquals(new ArrayList<>(), testFolder.getListPages());
    }

    @Test
    void testAddPage() {
        testFolder.addItem("GEOS 102 monday lecture");
        assertTrue("GEOS 102 monday lecture" == testFolder.getListPages().get(0).getName());
    }

    @Test
    void testDeletePage() {
        testFolder.addItem("MATH 310 notes");
        testFolder.deleteItem(0);
        assertEquals(new ArrayList<>(), testFolder.getListPages());
    }

    @Test
    void testChangeName() {
        testFolder.setName("BAJA BE THY BLAST");
        assertEquals("BAJA BE THY BLAST", testFolder.getName());
    }

    @Test
    void testAddThenDelete() {
        testFolder.addItem("BOOYAH");
        testFolder.deleteItem(0);
        assertEquals(new ArrayList<>(), testFolder.getListPages());
    }

    @Test
    void testAddMultipleTimes() {
        testFolder.addItem("test123");
        testFolder.addItem("test123");
        testFolder.addItem("test123");
        assertEquals("test123", testFolder.getListPages().get(0).getName());
        assertEquals("test123", testFolder.getListPages().get(1).getName());
        assertEquals("test123", testFolder.getListPages().get(2).getName());
    }

    @Test
    void testAddMultipleDeleteMultiple() {
        testFolder.addItem("test123");
        testFolder.addItem("test123");
        testFolder.addItem("wiggles");
        assertEquals("test123", testFolder.getListPages().get(0).getName());
        assertEquals("test123", testFolder.getListPages().get(1).getName());
        assertEquals("wiggles", testFolder.getListPages().get(2).getName());
        testFolder.deleteItem(1);
        testFolder.deleteItem(0);
        assertEquals("wiggles", testFolder.getListPages().get(0).getName());
    }

    @Test
    void testDisplayChoices() {
        testFolder.addItem("bazinga");
        testFolder.addItem("banger");
        assertEquals("[1] bazinga" + "\n[2] banger" + "\n", testFolder.displayChoices());
    }

    @Test
    void testToJson() {
        JSONObject jsonFolder = testFolder.toJson();
        assertEquals("GEOS 102 NOTES!!!", jsonFolder.getString("name"));
        assertTrue(jsonFolder.getJSONArray("listPages").isEmpty());
    }

    @Test
    void testPagesToJson() {
        testFolder.addItem("test");
        JSONObject jsonFolder = testFolder.toJson();
        JSONArray jsonPages = jsonFolder.getJSONArray("listPages");
        JSONObject jsonObj = jsonPages.getJSONObject(0);
        assertEquals("test", jsonObj.getString("name"));
    }
}
