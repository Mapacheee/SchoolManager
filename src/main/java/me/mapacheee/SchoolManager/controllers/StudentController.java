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

    @PutMapping("/{student}")
    public Student putStudent(@RequestBody Student student) {
        Student s = null;
        for (Student stu: students) {
            if (stu.getID() == student.getID()) {
                // okay, i need to do changes in student class :p
            }
        }

        return student;
    }


}
