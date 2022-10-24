package test;

import model.Directory;

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
        testDirectory.addFolder("WWW");
        assertEquals("WWW", testDirectory.getListFolders().get(0).getName());
    }

    @Test
    void testDeleteFolder() {
        testDirectory.addFolder("Work it!!! woo!!");
        testDirectory.deleteFolder(0);
        assertEquals(new ArrayList<>(), testDirectory.getListFolders());
    }

    @Test
    void testAddMultiple() {
        testDirectory.addFolder("Folder 1");
        testDirectory.addFolder("Folder 2");
        assertEquals("Folder 1", testDirectory.getListFolders().get(0).getName());
        assertEquals("Folder 2", testDirectory.getListFolders().get(1).getName());
    }

    @Test
    void testAddThenDelete() {
        testDirectory.addFolder("AAA");
        testDirectory.addFolder("BBB");
        testDirectory.deleteFolder(0);
        assertEquals("BBB", testDirectory.getListFolders().get(0).getName());
    }
}
