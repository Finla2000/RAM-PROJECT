package com.course.CourseService.repository;

import com.course.CourseService.model.Fooditem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FooditemRepository extends JpaRepository<Fooditem,Long> {
}
