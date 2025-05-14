package me.mapacheee.SchoolManager.controllers;

import me.mapacheee.SchoolManager.domains.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/teacher")
@RestController
public class TeacherController {

    private void updateFields(@RequestBody Teacher teacher, Teacher tea) {
        if (teacher.getName() != null) {
            tea.setName(teacher.getName());
        }
        if (teacher.getEmail() != null) {
            tea.setEmail(teacher.getEmail());
        }
        if (teacher.getCourses() != null) {
            tea.setCourses(teacher.getCourses());
        }
    }

    // temporaly "db" to test
    private List<Teacher> teachers = new ArrayList<Teacher>();

    @GetMapping
    public List<Teacher> teachers() {
        return teachers;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacher(int id) {
        return teachers.stream()
                .filter(t -> t.getID() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> putTeacher(@RequestBody Teacher teacher, int id) {

        ResponseEntity<Teacher> re;
        Optional<Teacher> existingTeacher = teachers.stream()
                .filter(t -> t.getID() == id)
                .findFirst();

        if (existingTeacher.isPresent()) {

            re = ResponseEntity.ok(existingTeacher.get());
            updateFields(teacher, existingTeacher.get());

        }
        else { re = ResponseEntity.notFound().build(); }

        return re;
    }
}
