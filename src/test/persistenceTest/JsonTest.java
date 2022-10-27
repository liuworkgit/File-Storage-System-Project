package persistenceTest;

import model.Paragraph;

import static org.junit.jupiter.api.Assertions.*;

public abstract class JsonTest {
    protected void checkParagraph(String text, Paragraph paragraph) {
        assertEquals(text, paragraph.getText());
    }
}
