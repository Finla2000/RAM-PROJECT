package com.course.CourseService.controller;


import com.course.CourseService.model.Fooditem;
import com.course.CourseService.model.Topic;
import com.course.CourseService.service.FooditemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fooditem")
public class FooditemController {

    private final FooditemService fooditemService;

    public FooditemController(FooditemService fooditemService) {
        this.fooditemService = fooditemService;
    }

    @PostMapping
    public ResponseEntity<Fooditem> createCourse(@RequestBody Fooditem fooditem) {
        Fooditem createdCourse = fooditemService.createCourse(fooditem);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);

    }
    @GetMapping("/{id}/topics")
    public ResponseEntity<List<Topic>> getCourseTopics(@PathVariable Long id) {
        List<Topic> topics = fooditemService.getCourseTopics(id);
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fooditem> getCourseId(@PathVariable Long id)
    {
        Fooditem fooditem= fooditemService.getCourseId(id);
        return ResponseEntity.ok(fooditem);
    }
}

