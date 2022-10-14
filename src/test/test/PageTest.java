package test;

import model.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageTest {
    private Page testPage;

    @BeforeEach
    void runBefore() {
        testPage = new Page("Math 200 notes");
    }
}