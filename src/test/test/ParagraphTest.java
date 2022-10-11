package test;

import model.Paragraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParagraphTest {
    private Paragraph testParagraph;

    @BeforeEach
    void runBefore() {
        testParagraph = new Paragraph("This is a paragraph!");
    }

    @Test
    void testParagraph() {
        assertEquals("This is a paragraph!", testParagraph.getText());
        assertEquals(1, testParagraph.getId());
    }

    @Test
    void testAddText() {
        testParagraph.addText("New text");
        assertEquals("This is a paragraph!" + "New text", testParagraph.getText());
    }

    @Test
    void testDeleteText() {
        testParagraph.deleteText("paragraph!");
        assertEquals("This is a ", testParagraph.getText());
    }

    @Test
    void testBoldPartOfText() {
        testParagraph.boldText("This is ");
        assertEquals("**This is ** a paragraph!", testParagraph.getText());
    }

    @Test
    void testAddThenDelete() {
        testParagraph.addText("123456789!!!");
        assertEquals("This is a paragraph!123456789!!!", testParagraph.getText());
        testParagraph.deleteText("4567");
        assertEquals("This is a paragraph!12389!!!", testParagraph.getText());
    }

    @Test
    void testBoldAddAndDelete() {
        testParagraph.boldText("paragraph!");
        assertEquals("This is a **paragraph!**", testParagraph.getText());
        testParagraph.addText(" [[[[[[[[");
        assertEquals("This is a **paragraph!** [[[[[[[[", testParagraph.getText());
        testParagraph.deleteText("paragraph!");
        assertEquals("This is a  [[[[[[[[", testParagraph.getText());
    }
}
