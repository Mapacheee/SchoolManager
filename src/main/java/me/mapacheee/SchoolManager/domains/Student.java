package me.mapacheee.SchoolManager.domains;

import me.mapacheee.SchoolManager.utils.ListNotes;

/*
    This is a POJO class with a Builder to ensure that
    this class will be inmutable and just because :p
*/
public final class Student {
    private String name, email, address;
    private final int ID;
    private static int IDcounter = 0;
    private ListNotes notes;

    public Student(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;

        this.ID = IDcounter;
        IDcounter++;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public ListNotes getNotes() { return notes; }
    public void setNotes(ListNotes notes) { this.notes = notes; }

    public int getID() { return ID; }

}
