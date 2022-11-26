package test;

import model.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

// based on AlarmSystem project provided by CPSC 210
// link here: https://github.students.cs.ubc.ca/CPSC210/AlarmSystem

public class EventTest {
    private Event testEvent;
    private Date date;

    @BeforeEach
    public void runBefore() {
        testEvent = new Event("Logged Event.");
        date = Calendar.getInstance().getTime();
    }

    @Test
    public void testConstructor() {
        assertEquals("Logged Event.", testEvent.getDescription());
        assertEquals(date, testEvent.getDate());
    }

    @Test
    public void testToString() {
        assertEquals(date.toString() + "\n" + "Logged Event.", testEvent.toString());
    }
}
