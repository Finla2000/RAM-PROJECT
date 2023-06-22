package com.ust.admin.controllers;

import com.ust.admin.model.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "item-service")
public interface ControllerConsumer {

    @PostMapping("/fooditem")
    public ResponseEntity<Menu> createCourse(@RequestBody Menu menu);

    @GetMapping("/fooditem/{id}/topics")
    public ResponseEntity<List<Menu>> getCourseTopics(@PathVariable Long id);

    @GetMapping("/fooditem/{id}")
    public ResponseEntity<Menu> getCourseId(@PathVariable Long id);

}
