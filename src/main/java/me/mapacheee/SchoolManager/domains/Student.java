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

    private Student() {
        this.ID = IDcounter;
        IDcounter++;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public ListNotes getNotes() { return notes; }
    public int getID() { return ID; }

    public static class StudentBuilder {
        private String name, email, address;
        private ListNotes notes;

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public StudentBuilder setNotes(ListNotes notes) {
            this.notes = notes;
            return this;
        }
        public Student build() {
            Student student = new Student();
            student.name = name;
            student.email = email;
            student.address = address;
            student.notes = notes;

            return student;
        }
    }
}
