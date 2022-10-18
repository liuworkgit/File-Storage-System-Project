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
    void testSetText() {
        testParagraph.setText("I am SICK AND TIRED AND EVERYTHING HURTS");
        assertEquals("I am SICK AND TIRED AND EVERYTHING HURTS", testParagraph.getText());
    }

    @Test
    // tests if can bold part of the paragraph
    void testBoldPartOfText() {
        testParagraph.boldText("This is ");
        assertEquals("**This is ** a paragraph!", testParagraph.getText());
    }

    @Test
    // tests if can add text, then delete it
    void testAddThenDelete() {
        testParagraph.addText("123456789!!!");
        assertEquals("This is a paragraph!123456789!!!", testParagraph.getText());
        testParagraph.deleteText("4567");
        assertEquals("This is a paragraph!12389!!!", testParagraph.getText());
    }

    @Test
    // tests if can bold text, then add more, then delete text
    void testBoldAddAndDelete() { // help? how to deal with bold markdown stuff when delete?
        testParagraph.boldText("paragraph!");
        assertEquals("This is a **paragraph!**", testParagraph.getText());
        testParagraph.addText(" [[[[[[[[");
        assertEquals("This is a **paragraph!** [[[[[[[[", testParagraph.getText());
        testParagraph.deleteText("paragraph!");
        assertEquals("This is a  [[[[[[[[", testParagraph.getText());
    }

    @Test
    void testDeleteMultipleTimes() {
        testParagraph.addText("A!B!C!D!Pow!");
        assertEquals("This is a paragraph!A!B!C!D!Pow!", testParagraph.getText());
        testParagraph.deleteText("A");
        testParagraph.deleteText("B");
        testParagraph.deleteText("C");
        assertEquals("This is a paragraph!!!!D!Pow!", testParagraph.getText());
    }

    @Test
    void testDeleteSameTextMultipleTimes() {
        testParagraph.addText("paragraph!paragraph!paragraph!");
        assertEquals("This is a paragraph!paragraph!paragraph!paragraph!", testParagraph.getText());
        testParagraph.deleteText("paragraph!");
        testParagraph.deleteText("paragraph!");
        testParagraph.deleteText("paragraph!");
        assertEquals("This is a paragraph!", testParagraph.getText());
    }
}
