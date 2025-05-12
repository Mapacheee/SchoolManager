package me.mapacheee.SchoolManager.domains;

import me.mapacheee.SchoolManager.utils.Course;

import java.util.List;

public class Teacher {
    private String name;
    private String email;
    private List<Course> courses;

    public Teacher(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
    public void addCourse(Course course) { courses.add(course); }
    public void removeCourse(Course course) { courses.remove(course); }

}
