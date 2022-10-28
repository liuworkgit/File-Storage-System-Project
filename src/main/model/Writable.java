package model;

import org.json.JSONArray;
import org.json.JSONObject;

// NOTE: Based on JsonSerializationDemo provided by CPSC210
// Found on Phase 2 page on CPSC210 edx
// Link to repository:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// an object with collections that can be converted to json
public interface Writable {
    // EFFECTS: returns this as json object
    JSONObject toJson();

    // EFFECTS: returns an array of objects as a json array
    JSONArray arrayToJson();
}
