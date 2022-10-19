package test;

import model.PageFolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PageFolderTest {
    private PageFolder testFolder;

    @BeforeEach
    void runBefore() {
        testFolder = new PageFolder("GEOS 102 NOTES!!!");
    }

    @Test
    void testPageFolder() {
        assertEquals("GEOS 102 NOTES!!!", testFolder.getName());
        assertEquals(new ArrayList<>(), testFolder.getListPages());
    }

    @Test
    void testAddPage() {
        testFolder.addPage("GEOS 102 monday lecture");
        assertEquals(Arrays.asList("GEOS 102 monday lecture"), testFolder.getListPages());
    }

    @Test
    void testDeletePage() {
        testFolder.addPage("MATH 310 notes");
        testFolder.deletePage(0);
        assertEquals(new ArrayList<>(), testFolder.getListPages());
    }

    @Test
    void testChangeName() {
        testFolder.changeName("BAJA BE THY BLAST");
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
        assertEquals(Arrays.asList("test123", "test123", "test123"), testFolder.getListPages());
    }

    @Test
    void testAddMultipleDeleteMultiple() {
        testFolder.addPage("test123");
        testFolder.addPage("test123");
        testFolder.addPage("test123");
        assertEquals(Arrays.asList("test123", "test123", "test123"), testFolder.getListPages());
        testFolder.deletePage(2);
        testFolder.deletePage(1);
        assertEquals(Arrays.asList("test123"), testFolder.getListPages());
    }
}
