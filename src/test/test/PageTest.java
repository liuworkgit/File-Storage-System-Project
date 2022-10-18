package test;

import model.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PageTest {
    private Page testPage;

    @BeforeEach
    void runBefore() {
        testPage = new Page("Math 200 notes");
    }

    @Test
    void testPage() {
        assertEquals("Math 200 notes", testPage.getName());
        assertEquals(1, testPage.getPageId());
        assertEquals(new ArrayList<>(), testPage.getListParagraphs());
        assertEquals(new ArrayList<>(), testPage.getListLinks());
    }

    @Test
    void testAddParagraph() {
        testPage.addParagraph("This is some text, blah blah blah.");
        assertEquals(Arrays.asList("This is some text, blah blah blah."), testPage.getListParagraphs());
    }

    @Test
    void testDeleteParagraph() {
        testPage.addParagraph("asdfghjk");
        testPage.deleteParagraph(0);
        assertEquals(new ArrayList<>(), testPage.getListParagraphs());
    }

    @Test
    void testAddLink() {
        testPage.addLink("Page Name");
        assertEquals(Arrays.asList("Page Name"), testPage.getListLinks());
    }

    @Test
    void testDeleteLink() {
        testPage.addLink("Math 221 Notes - Basis and Dimension");
        testPage.deleteLink(0);
        assertEquals(new ArrayList<>(), testPage.getListLinks());
    }

    @Test
    void testChangeName() {
        testPage.changeName("CPSC 210 hurts my brain");
        assertEquals("CPSC 210 hurts my brain", testPage.getName());
    }

    @Test
    // tests if can add paragraphs, then delete it
    void testAddThenDelete() {
        testPage.addParagraph("agony pain suffering");
        testPage.deleteParagraph(0);
        assertEquals(new ArrayList<>(), testPage.getListParagraphs());
    }

    @Test
    // tests if can add multiple paragraphs
    void testAddMultiple() {
        testPage.addParagraph("booboboboboobbobobobob");
        testPage.addParagraph("booboboboboobbobobobob");
        testPage.addParagraph("oooogoogooohhhghghhghgpenn");
        assertEquals(Arrays.asList("booboboboboobbobobobob",
                "booboboboboobbobobobob",
                "oooogoogooohhhghghhghgpenn"), testPage.getListParagraphs());
    }

    @Test
    // tests if can add and delete multiple times
    void testAddMultipleDeleteMultiple() {
        testPage.addParagraph("ABC");
        testPage.addParagraph("DEF");
        testPage.deleteParagraph(0);
        testPage.addParagraph("GHI123");
        testPage.deleteParagraph(1);
        assertEquals(Arrays.asList("DEF"), testPage.getListParagraphs());
    }
}