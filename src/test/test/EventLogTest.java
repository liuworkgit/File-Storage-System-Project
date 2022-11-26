package test;


import model.Event;
import model.EventLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// based on AlarmSystem project provided by CPSC 210
// link here: https://github.students.cs.ubc.ca/CPSC210/AlarmSystem

public class EventLogTest {
    private Event e1;
    private Event e2;
    private Event e3;

    @BeforeEach
    public void runBefore() {
        e1 = new Event("Event 1.");
        e2 = new Event("Event 2");
        e3 = new Event("Event 3");
        EventLog eventLog = EventLog.getInstance();
        eventLog.logEvent(e1);
        eventLog.logEvent(e2);
        eventLog.logEvent(e3);
    }

    @Test
    public void testLogEvent() {
        List<Event> list = new ArrayList<Event>();

        EventLog eventLog = EventLog.getInstance();
        for (Event next : eventLog) {
            list.add(next);
        }

        assertTrue(list.contains(e1));
        assertTrue(list.contains(e2));
        assertTrue(list.contains(e3));
    }
}
