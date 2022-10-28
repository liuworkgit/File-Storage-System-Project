package ui;

import java.io.FileNotFoundException;

// NOTE: Based on JsonSerializationDemo provided by CPSC210
// Found on Phase 2 page on CPSC210 edx
// Link to repository:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// initializes the note taker app
public class NoteTaker {
    public static void main(String[] args) {
        try {
            new DirectoryFunctions();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found.");
        }
    }
}
