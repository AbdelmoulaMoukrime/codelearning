package com.example.plateforme_cours.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.plateforme_cours.model.Cours;
import com.example.plateforme_cours.model.SupportPedagogique;
import com.example.plateforme_cours.model.Utilisateur;
import com.example.plateforme_cours.repository.CoursRepository;
import com.example.plateforme_cours.repository.SupportPedagogiqueRepository;
import com.example.plateforme_cours.repository.UtilisateurRepository;

@Service
public class CoursService {

    private final CoursRepository coursRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final SupportPedagogiqueRepository supportRepository;

    public CoursService(CoursRepository coursRepository,
                        UtilisateurRepository utilisateurRepository,
                        SupportPedagogiqueRepository supportRepository) {

        this.coursRepository = coursRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.supportRepository = supportRepository;
    }

    // ========== 1) publierCours ==========
    public Cours publierCours(Cours cours, Long createurId) {

        Utilisateur createur = utilisateurRepository.findById(createurId)
                .orElseThrow(() -> new RuntimeException("Createur introuvable !"));

        cours.setCreateur(createur);

        return coursRepository.save(cours);
    }

    // ========== 2) mettreAJourCours ==========
    public Cours mettreAJourCours(Long id, Cours nouveauCours) {

        Cours cours = coursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours introuvable !"));

        cours.setTitre(nouveauCours.getTitre());
        cours.setDescription(nouveauCours.getDescription());

        return coursRepository.save(cours);
    }

    // ========== 3) gererSupports ==========
    public SupportPedagogique ajouterSupport(Long coursId, SupportPedagogique support) {

        Cours cours = coursRepository.findById(coursId)
                .orElseThrow(() -> new RuntimeException("Cours introuvable !"));

        support.setCours(cours);

        return supportRepository.save(support);
    }

    // (OPTIONNEL) afficher tous les cours
    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }
}
