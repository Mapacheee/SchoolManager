package me.mapacheee.SchoolManager.controllers;

import me.mapacheee.SchoolManager.domains.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/teacher")
@RestController
public class TeacherController {

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

    /*@PutMapping("/{id}")
    public EntityResponse<Teacher> putTeacher(@RequestBody Teacher teacher, int id) {


    }*/
}
