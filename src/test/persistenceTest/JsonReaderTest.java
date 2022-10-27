package persistenceTest;

import model.Directory;
import model.Page;
import model.Paragraph;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// NOTE: Based on JsonSerializationDemo provided by CPSC210
// Found on Phase 2 page on CPSC210 edx
// Link to repository:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonReaderTest extends JsonTest {
    @Test
    void testReadNonExistentFile() {
        JsonReader reader = new JsonReader("./data/ThisFileDoesn'tExist!Lol!.json");
        try {
            Directory directory = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReadEmptyDirectory() {
        JsonReader reader = new JsonReader("./data/testEmptyDirectoryReader.json");
        try {
            Directory directory = reader.read();
            assertEquals(new ArrayList<>(), directory.getListFolders());
        } catch (IOException e) {
            fail("Couldn't read from file.");
        }
    }

    @Test
    void testReadOnlyFolders() {
        JsonReader reader = new JsonReader("./data/testToFolderLvlReader.json");
        try {
            Directory directory = reader.read();
            assertEquals("Math 200 Week 8", directory.getListFolders().get(0).getName());
            assertEquals("CO-OP INFORMATION", directory.getListFolders().get(1).getName());
        } catch (IOException e) {
            fail("Couldn't read from file.");
        }
    }

    @Test
    void testReadHasEverything() {
        JsonReader reader = new JsonReader("./data/testHasEverythingReader.json");
        try {
            Directory directory = reader.read();
            assertEquals("Math 200 Week 8", directory.getListFolders().get(0).getName());
            assertEquals("CO-OP INFORMATION", directory.getListFolders().get(1).getName());

            List<Page> testPages = directory.getListFolders().get(0).getListPages();
            List<Paragraph> testParagraphs1 = testPages.get(0).getListParagraphs(); // 1
            assertEquals("Approximation", testPages.get(0).getName());
            checkParagraph("Tan plane, differential and linear approx. all related.",
                    testParagraphs1.get(0));
            checkParagraph("tan plane of 3varfxn: fx(P)(x-a) + fy(P)(y-b) + fz(P)(z-c) = 0",
                    testParagraphs1.get(1));
            assertEquals("Math 200 Week 7", testPages.get(0).getListLinks().get(0));
            assertEquals("Math 200 Midterm 2 review", testPages.get(0).getListLinks().get(1));

            List<Paragraph> testParagraphs2 = testPages.get(1).getListParagraphs(); // 2
            assertEquals("Gradient vectors and directional derivatives", testPages.get(1).getName()); // 2
            checkParagraph("gradient vectors are vectors whose components are the partial derivatives",
                    testParagraphs2.get(0));
            assertEquals(new ArrayList<>(), testPages.get(1).getListLinks());
        } catch (IOException e) {
            fail("Couldn't read from file.");
        }
    }
}
