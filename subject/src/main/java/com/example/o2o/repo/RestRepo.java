package com.example.o2o.repo;

import com.example.o2o.entity.Rest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RestRepo extends JpaRepository<Rest, String> {
    public List<Rest> findAllByMemId(String memId);
    public Rest findById(Long Id);
}
