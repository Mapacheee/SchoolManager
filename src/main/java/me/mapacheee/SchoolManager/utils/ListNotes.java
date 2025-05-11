package me.mapacheee.SchoolManager.utils;

import java.util.ArrayList;
import java.util.List;

public class ListNotes {

    private final List<Float> notes;

    public ListNotes() {
        notes = new ArrayList<Float>();
    }

    public float getNote(int index) {
        return notes.get(index);
    }

    public Object[] getNotes() {
        return notes.toArray();
    }

    public void addNote(float note) {
        notes.add(note);
    }
    public void removeNote(float note) {
        notes.remove(note);
    }
}
