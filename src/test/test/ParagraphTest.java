package test;

import model.Paragraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*; // static means calling assertions on class itself

public class ParagraphTest {
    private Paragraph testParagraph;

    @BeforeEach
    void runBefore() {
        testParagraph = new Paragraph("This is a paragraph! " +
                "Lots of text!" +
                "The quick brown fox jumped over the lazy dog! " +
                "1973982akjhdfkjahd?:_f93940fsafhkfd~~~");
    }

    @Test
    void testParagraph() {
        assertEquals("This is a paragraph! " +
                "Lots of text!" +
                "The quick brown fox jumped over the lazy dog! " +
                "1973982akjhdfkjahd?:_f93940fsafhkfd~~~", testParagraph.getText());
        assertEquals(1, testParagraph.getId());
    }

}
