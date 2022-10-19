package test;

import model.Directory;

import model.Page;
import model.PageFolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

//    @Test
//    void testAddFolder() {
//        testDirectory.addFolder("WWW");
//    }

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
        assertTrue(testDirectory.getListFolders().contains(new PageFolder("Folder 1")));
        assertTrue(testDirectory.getListFolders().contains(new PageFolder("Folder 2")));
    }

    @Test
    void testAddThenDelete() {
        testDirectory.addFolder("AAA");
        testDirectory.addFolder("BBB");
        testDirectory.deleteFolder(0);
        assertTrue(testDirectory.getListFolders().contains(new PageFolder("BBB")));
        assertFalse(testDirectory.getListFolders().contains(new PageFolder("AAA")));
    }
}
