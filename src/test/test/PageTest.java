package test;

import model.Page;
import org.json.JSONArray;
import org.json.JSONObject;
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
        assertEquals(new ArrayList<>(), testPage.getListParagraphs());
        assertEquals(new ArrayList<>(), testPage.getListLinks());
    }

    @Test
    void testAddParagraph() {
        testPage.addItem("This is some text, blah blah blah.");
        assertEquals("This is some text, blah blah blah.",
                testPage.getListParagraphs().get(0).getText());
    }

    @Test
    void testDeleteParagraph() {
        testPage.addItem("asdfghjk");
        testPage.deleteItem(0);
        assertEquals(new ArrayList<>(), testPage.getListParagraphs());
    }

    @Test
    void testAddLink() {
        Page mathNotes = new Page("Math 200 - PDEs");
        testPage.addLink(mathNotes.getName());
        assertEquals(Arrays.asList("Math 200 - PDEs"), testPage.getListLinks());
    }

    @Test
    void testDeleteLink() {
        Page mathNotes = new Page("Math 221 Notes - Basis and Dimension");
        testPage.addLink(mathNotes.getName());
        testPage.deleteLink(0);
        assertEquals(new ArrayList<>(), testPage.getListLinks());
    }

    @Test
    void testChangeName() {
        testPage.setName("CPSC 210 hurts my brain");
        assertEquals("CPSC 210 hurts my brain", testPage.getName());
    }

    @Test
    // tests if can add paragraphs, then delete it
    void testAddThenDelete() {
        testPage.addItem("agony pain suffering");
        testPage.deleteItem(0);
        assertEquals(new ArrayList<>(), testPage.getListParagraphs());
    }

    @Test
    // tests if can add multiple paragraphs
    void testAddMultiple() {
        testPage.addItem("name 1");
        testPage.addItem("name 2");
        testPage.addItem("name 3");
        assertEquals("name 1", testPage.getListParagraphs().get(0).getText());
        assertEquals("name 2", testPage.getListParagraphs().get(1).getText());
        assertEquals("name 3", testPage.getListParagraphs().get(2).getText());
    }

    @Test
    // tests if can add and delete multiple times
    void testAddMultipleDeleteMultiple() {
        testPage.addItem("ABC");
        testPage.addItem("DEF");
        testPage.deleteItem(0);
        testPage.addItem("GHI123");
        testPage.deleteItem(1);
        assertTrue("DEF" == testPage.getListParagraphs().get(0).getText());
    }

    @Test
    // tests if adding the same link twice will only add the link once
    void testLinkSamePageTwice() {
        Page page1 = new Page("test page");
        testPage.addLink(page1.getName());
        assertEquals(Arrays.asList("test page"), testPage.getListLinks());
        testPage.addLink(page1.getName());
        assertEquals(Arrays.asList("test page"), testPage.getListLinks());
    }

    @Test
    void testDisplayChoices() {
        testPage.addItem("Test");
        testPage.addItem("Testing");
        assertEquals("[1] Test" + "\n[2] Testing" + "\n", testPage.displayChoices());
    }

    @Test
    void testDisplayLinks() {
        Page link1 = new Page("link1");
        Page link2 = new Page("link2");
        testPage.addLink(link1.getName());
        testPage.addLink(link2.getName());
        assertEquals("[1] link1" + "\n[2] link2" + "\n", testPage.displayLinks());
    }

    @Test
    void testToJson() {
        JSONObject jsonPage = testPage.toJson();
        assertEquals("Math 200 notes", jsonPage.getString("name"));
        assertTrue(jsonPage.getJSONArray("listParagraphs").isEmpty());
        assertTrue(jsonPage.getJSONArray("listLinks").isEmpty());
    }

    @Test
    void testParasToJson() {
        testPage.addItem("test1");
        testPage.addItem("test2");
        JSONObject jsonPage = testPage.toJson();
        JSONArray jsonParas = jsonPage.getJSONArray("listParagraphs");
        JSONObject jsonObj1 = jsonParas.getJSONObject(0);
        JSONObject jsonObj2 = jsonParas.getJSONObject(1);
        assertEquals("test1", jsonObj1.getString("text"));
        assertEquals("test2", jsonObj2.getString("text"));
    }

    @Test
    void testLinksToJson() {
        testPage.addLink("test1");
        testPage.addLink("test2");
        JSONObject jsonPage = testPage.toJson();
        JSONArray jsonLinks = jsonPage.getJSONArray("listLinks");
        JSONObject jsonObj1 = jsonLinks.getJSONObject(0);
        JSONObject jsonObj2 = jsonLinks.getJSONObject(1);
        assertEquals("test1", jsonObj1.getString("link"));
        assertEquals("test2", jsonObj2.getString("link"));
    }
}