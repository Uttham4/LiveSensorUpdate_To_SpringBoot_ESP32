package com.example.demo.repository;

//import java.awt.print.Pageable;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Entity;
//import org.springframework.data.domain.Pageable;

//import jakarta.persistence.Entity;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Entity, Integer>{
//    @Query("SELECT * FROM ultrasonic ORDER BY id DESC")
//    List<Entity> findLatestTransaction(Pageable pageable);/
	Entity findFirstByOrderByIdDesc();

}
