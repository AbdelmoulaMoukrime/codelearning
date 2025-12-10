package com.example.plateforme_cours.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "supportpedagogique")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SupportPedagogique {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "type_support")
  private ResourceType typeSupport; // PDF or Video

  @Column(name = "url", nullable = false)
  private String url;

  @ManyToOne
  @JoinColumn(name = "cours_id")
  private Cours cours;
}
