package com.example.plateforme_cours.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.plateforme_cours.model.Cours;

public interface CoursRepository extends JpaRepository<Cours, Long> {

}
