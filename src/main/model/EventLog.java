package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// based on AlarmSystem project provided by CPSC 210
// link here: https://github.students.cs.ubc.ca/CPSC210/AlarmSystem

public class EventLog implements Iterable<Event> {
    private static EventLog EVENT_LOG;
    private Collection<Event> events;

    // EFFECTS: creates a new event log
    private EventLog() {
        events = new ArrayList<>();
    }

    // EFFECTS: allows for global access of the event log
    public static EventLog getInstance() {
        if (EVENT_LOG == null) {
            EVENT_LOG = new EventLog();
        }
        return EVENT_LOG;
    }

    // EFFECTS: logs an event in the event log
    public void logEvent(Event e) {
        events.add(e);
    }

    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}
