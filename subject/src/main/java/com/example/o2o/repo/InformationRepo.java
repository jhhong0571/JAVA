package com.example.o2o.repo;

import com.example.o2o.domain.Member;
import com.example.o2o.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepo extends JpaRepository<Information, String> {
    public Information findByIde(String id);
}
