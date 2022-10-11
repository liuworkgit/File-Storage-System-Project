package test;

import model.Paragraph;
import org.junit.jupiter.api.BeforeEach;

public class ParagraphTest {
    private Paragraph testParagraph;

    @BeforeEach
    void runBefore() {
        testParagraph = new Paragraph("This is a paragraph! " +
                                            "Lots of text!" +
                                            "The quick brown fox jumped over the lazy dog! " +
                                            "1973982akjhdfkjahd?:_f93940fsafhkfd~~~");
    }

}
