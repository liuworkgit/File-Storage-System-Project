package model;

import java.util.List;

// when make interfaces
// - implementation is different
// abstract class - very general
// - implementation same/same use

// inf - no implementation, only specification
// abstract class - some implemented methods, some abstract methods
// class - MUST HAVE IMPLEMNTATION

// why abs classes?
// ex from lect: assume all dogs walk and eat same way, but some make different noises
// defs new type data
// can have implemented methods and abstract methods
// CANNOT BE INSTANTIATED

// ACTUAL CLASS
// must GIVE IMPLEMENTATION to all abstract methods or else declared abstract

// abstract meths - specification only
// if a class has even ONE abstract method, whole class is ABSTRACT

public class StorageType {
    // MODIFIES: this
    public void addItem() {
        // calls constructor and adds to list
    }

    public abstract void deleteItem();
}
