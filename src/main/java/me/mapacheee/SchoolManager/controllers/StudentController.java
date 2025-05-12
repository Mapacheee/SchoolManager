package me.mapacheee.SchoolManager.controllers;

import me.mapacheee.SchoolManager.domains.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/student")
public class StudentController {

    // Temporaly this will be a "database" of students to test
    private List<Student> students = new ArrayList<Student>();

    private void updateFields(@RequestBody Student student, Student stu) {
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
    }

    @GetMapping
    public List<Student> getStudents() { return students; }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        return students.stream()
                .filter(s -> s.getID() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> putStudent(@RequestBody Student student, @PathVariable int id) {

        ResponseEntity<Student> re;
        Optional<Student> existingStudent = students.stream()
                .filter(s -> s.getID() == id)
                .findFirst();

        if (existingStudent.isEmpty()) {
            re = ResponseEntity.notFound().build();
        }
        else {
            Student stu = existingStudent.get();
            updateFields(student, stu);

            re = ResponseEntity.ok(student);
        }

        return re;
    }

    @PostMapping
    public Student postStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        Iterator<Student> iterator = students.iterator();
        ResponseEntity<Student> re = ResponseEntity.notFound().build();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getID() == id) {
                iterator.remove();
                re = ResponseEntity.ok(student);

                break;
            }
        }
        return re;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Student> patchStudent(@RequestBody Student student, @PathVariable int id) {
        return students.stream()
                .filter(s -> s.getID() == id)
                .findFirst()
                .map(stu -> {
                    updateFields(student, stu);
                    return ResponseEntity.ok(student); })
                .orElse(ResponseEntity.notFound().build());
    }

}