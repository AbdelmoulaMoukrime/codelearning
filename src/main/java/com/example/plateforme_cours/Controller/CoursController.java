package com.example.plateforme_cours.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.plateforme_cours.model.Cours;
import com.example.plateforme_cours.model.SupportPedagogique;
import com.example.plateforme_cours.service.CoursService;

@RestController
@RequestMapping("/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    // 1) publierCours
    @PostMapping("/publier/{createurId}")
    public Cours publierCours(@RequestBody Cours cours, @PathVariable Long createurId) {
        return coursService.publierCours(cours, createurId);
    }