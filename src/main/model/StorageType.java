package model;

import java.util.ArrayList;

// WORK IN PROGRESS
// an object that can store items
public abstract class StorageType {
    public abstract void addItem(String name);

    public abstract void deleteItem(int index);
}
