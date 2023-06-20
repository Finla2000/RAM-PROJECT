package com.course.CourseService.service;


import com.course.CourseService.exception.ItemNotFoundException;
import com.course.CourseService.model.Fooditem;
import com.course.CourseService.model.Topic;
import com.course.CourseService.repository.FooditemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FooditemService {

    private final FooditemRepository fooditemRepository;

    public FooditemService(FooditemRepository fooditemRepository) {
        this.fooditemRepository = fooditemRepository;
    }


    public Fooditem createCourse(Fooditem fooditem) {

//        course.setCourseId(courseId);
        return fooditemRepository.save(fooditem);
    }

    public List<Topic> getCourseTopics(Long id) {
        Optional<Fooditem> courseOptional = fooditemRepository.findById(id);
        if (courseOptional.isPresent()) {
            Fooditem course = courseOptional.get();
            return course.getTopics();
        }
        throw new ItemNotFoundException("Course not found with ID: " + id);
    }

    public Fooditem getCourseId(Long id) {
        Optional<Fooditem> courseOptional = fooditemRepository.findById(id);
        if (courseOptional.isPresent()) {
            Fooditem course = courseOptional.get();
            return course;
        }
        throw new ItemNotFoundException("Course not found with ID: " + id);
    }
}
