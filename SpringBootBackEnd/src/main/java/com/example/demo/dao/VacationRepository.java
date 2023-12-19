package com.example.demo.dao;

import com.example.demo.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Repository
public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
