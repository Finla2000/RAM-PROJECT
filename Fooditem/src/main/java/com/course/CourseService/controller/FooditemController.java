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
    @GetMapping("/topics/{id}")
    public ResponseEntity<List<Topic>> getCourseTopics(@PathVariable Long id) {
        List<Topic> topics = fooditemService.getCourseTopics(id);
        return ResponseEntity.ok(topics);
    }
    @GetMapping("/fooditems/{foodid}/{topicid}")
    public ResponseEntity<Topic> getFoodItemTopic(
            @PathVariable Long foodid,
            @PathVariable Long topicid
    ) {
        Fooditem fooditem = fooditemService.getFooditemById(foodid);

        if (fooditem == null) {
            // Food item with the specified ID not found
            return ResponseEntity.notFound().build();
        }

        List<Topic> topics = fooditem.getTopics();
        for (Topic topic : topics) {
            if (topic.getId().equals(topicid)) {
                return ResponseEntity.ok(topic);
            }
        }

        // Topic with the specified ID not found for the given food item
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Fooditem> getCourseId(@PathVariable Long id)
    {
        Fooditem fooditem= fooditemService.getCourseId(id);
        return ResponseEntity.ok(fooditem);
    }
}

