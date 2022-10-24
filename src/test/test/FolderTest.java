package test;

import model.Folder;
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
        testFolder.addPage("GEOS 102 monday lecture");
        assertTrue("GEOS 102 monday lecture" == testFolder.getListPages().get(0).getName());
    }

    @Test
    void testDeletePage() {
        testFolder.addPage("MATH 310 notes");
        testFolder.deletePage(0);
        assertEquals(new ArrayList<>(), testFolder.getListPages());
    }

    @Test
    void testChangeName() {
        testFolder.setName("BAJA BE THY BLAST");
        assertEquals("BAJA BE THY BLAST", testFolder.getName());
    }

    @Test
    void testAddThenDelete() {
        testFolder.addPage("BOOYAH");
        testFolder.deletePage(0);
        assertEquals(new ArrayList<>(), testFolder.getListPages());
    }

    @Test
    void testAddMultipleTimes() {
        testFolder.addPage("test123");
        testFolder.addPage("test123");
        testFolder.addPage("test123");
        assertEquals("test123", testFolder.getListPages().get(0).getName());
        assertEquals("test123", testFolder.getListPages().get(1).getName());
        assertEquals("test123", testFolder.getListPages().get(2).getName());
    }

    @Test
    void testAddMultipleDeleteMultiple() {
        testFolder.addPage("test123");
        testFolder.addPage("test123");
        testFolder.addPage("wiggles");
        assertEquals("test123", testFolder.getListPages().get(0).getName());
        assertEquals("test123", testFolder.getListPages().get(1).getName());
        assertEquals("wiggles", testFolder.getListPages().get(2).getName());
        testFolder.deletePage(1);
        testFolder.deletePage(0);
        assertEquals("wiggles", testFolder.getListPages().get(0).getName());
    }

    @Test
    void testDisplayChoices() {
        testFolder.addPage("Test");
        testFolder.addPage("Testing");
        assertEquals("Test", testFolder.getListPages().get(0).getName());
        assertEquals("Testing", testFolder.getListPages().get(1).getName());
    }
}
