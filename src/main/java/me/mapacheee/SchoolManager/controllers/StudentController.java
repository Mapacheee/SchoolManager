package me.mapacheee.SchoolManager.controllers;

import me.mapacheee.SchoolManager.domains.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    // Temporaly this will be a "database" of students to test
    private List<Student> students = new ArrayList<Student>();

    @GetMapping
    public List<Student> getStudents() { return students; }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return students.stream()
                .filter(s -> s.getID() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()).getBody();
    }

    @PutMapping
    public Student putStudent(@RequestBody Student student) {
        Student s = null;
        for (Student stu: students) {
            if (stu.getName().equalsIgnoreCase(student.getName())) {
                stu.setName(student.getName());
                stu.setAddress(student.getAddress());
                stu.setEmail(student.getEmail());
                stu.setNotes(student.getNotes());

                s = stu;
                break;
            }
        }
        return s;
    }

    @PostMapping
    public Student postStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @DeleteMapping({"/{id}"})
    public Student deleteStudent(@PathVariable int id) {
        Student s = null;
        for (Student stu: students) {
            if (stu.getID() == id) {
                students.remove(stu);
                s = stu;
            }
        }
        return s;
    }

    @PatchMapping
    public Student patchStudent(@RequestBody Student student) {
        Student s = null;
        for (Student stu: students) {

            if (stu.getID() == student.getID()) {
                if (student.getName() != null) {
                    stu.setName(student.getName());
                }
                if (student.getAddress() != null) {
                    stu.setAddress(student.getAddress());
                }
                if (student.getEmail() != null) {
                    stu.setEmail(student.getEmail());
                }
                if (student.getNotes() != null) {
                    stu.setNotes(student.getNotes());
                }

                s = stu;
                break;
            }
        }
        return s;
    }

}