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
        testDirectory.addFolder("Work it!!! woo!!");
        assertEquals(...);
    }

    @Test
    void testDeleteFolder() {
        testDirectory.addFolder("Work it!!! woo!!");
        testDirectory.deleteFolder("Work it!!! woo!!");
        assertEquals(new ArrayList<>(), testDirector.);
    }
}
