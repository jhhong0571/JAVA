package com.example.people.repository;

import com.example.people.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LectureRepository extends JpaRepository<Lecture,Long>{
}
