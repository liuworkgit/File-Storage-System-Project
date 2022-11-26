package model;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

// based on AlarmSystem project provided by CPSC 210
// link here: https://github.students.cs.ubc.ca/CPSC210/AlarmSystem

// represents an event in the noteTaker
public class Event {
    private Date date;
    private String description;

    // EFFECTS: creates a new event
    public Event(String description) {
        date = Calendar.getInstance().getTime();
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Event event = (Event) o;
        return this.date.equals(event.date) && this.description.equals(event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, description);
    }

    @Override
    public String toString() {
        return date.toString() + "\n" + description;
    }

    // getters
    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
