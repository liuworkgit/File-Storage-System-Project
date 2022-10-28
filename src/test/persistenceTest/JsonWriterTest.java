package persistenceTest;

import model.Directory;
import model.Folder;
import model.Page;
import model.Paragraph;

import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// NOTE: Based on JsonSerializationDemo provided by CPSC210
// Found on Phase 2 page on CPSC210 edx
// Link to repository:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonWriterTest extends JsonTest {
    @Test
    void testWriteInvalidFile() {
        try {
            Directory testDr = new Directory();
            JsonWriter writer = new JsonWriter("./data/\0lol.json");
            writer.open();
            fail("IOException was expected.");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriteEmptyDirectory() {
        try {
            Directory dr = new Directory();

            JsonWriter writer = new JsonWriter("./data/testToDirectoryLvlWriter.json");
            writer.open();
            writer.write(dr);
            writer.close();
            JsonReader reader = new JsonReader("./data/testToDirectoryLvlWriter.json");
            dr = reader.read();

            assertEquals(new ArrayList<>(), dr.getListFolders());
        } catch (IOException e) {
            fail("Exception shouldn't have been thrown.");
        }
    }

    @Test
    void testWriteToFolderLvl() {
        try {
            Directory dr = new Directory();
            dr.addItem("folder 1");
            dr.addItem("1234567");

            JsonWriter writer = new JsonWriter("./data/testToFolderLvlWriter.json");
            writer.open();
            writer.write(dr);
            writer.close();
            JsonReader reader = new JsonReader("./data/testToFolderLvlWriter.json");
            dr = reader.read();

            List<Folder> folders = dr.getListFolders();
            assertEquals("folder 1", folders.get(0).getName());
            assertEquals("1234567", folders.get(1).getName());
        } catch (IOException e) {
            fail("Exception shouldn't have been thrown.");
        }
    }

    @Test
    void testWriteToPageLvl() {
        try {
            Directory dr = new Directory();
            dr.addItem("test folder");
            Folder folder = dr.getListFolders().get(0);
            folder.addItem("page 1");
            folder.addItem("page 2");

            JsonWriter writer = new JsonWriter("./data/testToPageLvlWriter.json");
            writer.open();
            writer.write(dr);
            writer.close();
            JsonReader reader = new JsonReader("./data/testToPageLvlWriter.json");
            dr = reader.read();

            List<Folder> testFolders = dr.getListFolders();
            Folder testFolder = testFolders.get(0);
            Page testPage1 = testFolder.getListPages().get(0);
            Page testPage2 = testFolder.getListPages().get(1);

            assertEquals(2, testFolder.getListPages().size());
            assertEquals("page 1", testPage1.getName());
            assertEquals("page 2", testPage2.getName());
        } catch (IOException e) {
            fail("Exception shouldn't have been thrown.");
        }
    }

    @Test
    void testWriteToParaLinkLvl() {
        try {
            Directory dr = new Directory();
            dr.addItem("1");
            Folder folder = dr.getListFolders().get(0);
            folder.addItem("2");
            Page page = folder.getListPages().get(0);
            page.addItem("lorem ipsum idk");
            page.addItem("dummy text 1234;;;;;**");
            page.addLink("page name");

            JsonWriter writer = new JsonWriter("./data/testToFolderLvlWriter.json");
            writer.open();
            writer.write(dr);
            writer.close();
            JsonReader reader = new JsonReader("./data/testToFolderLvlWriter.json");
            dr = reader.read();

            List<Folder> testFolders = dr.getListFolders();
            Folder testFolder = testFolders.get(0);
            Page testPage = testFolder.getListPages().get(0);
            Paragraph para1 = testPage.getListParagraphs().get(0);
            Paragraph para2 = testPage.getListParagraphs().get(1);
            String link1 = testPage.getListLinks().get(0);

            checkParagraph("lorem ipsum idk", para1);
            checkParagraph("dummy text 1234;;;;;**", para2);
            assertEquals("page name", link1);
        } catch (IOException e) {
            fail("Exception shouldn't have been thrown.");
        }
    }
}
