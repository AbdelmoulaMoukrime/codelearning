package com.example.plateforme_cours.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.plateforme_cours.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
