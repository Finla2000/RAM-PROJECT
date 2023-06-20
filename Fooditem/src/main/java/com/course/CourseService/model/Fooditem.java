package com.course.CourseService.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fooditem")
public class Fooditem {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
//        private String description;

        @OneToMany(targetEntity=Topic.class,
                cascade=CascadeType.ALL,
                fetch=FetchType.LAZY,
                orphanRemoval=true
        )
        @JoinColumn(referencedColumnName = "id",name="fooditem_id")

        List<Topic> topics ;
    }



