package com.example.plateforme_cours.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cours")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Cours {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "titre", nullable = false)
  private String titre;  @Column(name = "description")
  private String description;  @ManyToOne  @JoinColumn(name = "createur_id")
  private Utilisateur createur;}