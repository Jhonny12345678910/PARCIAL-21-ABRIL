package com.example.Equipodefutbol.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "equipoLocal")
    private List<Partido> partidosLocal;

    @OneToMany(mappedBy = "equipoVisitante")
    private List<Partido> partidosVisitante;

    @OneToMany(mappedBy = "equipo")
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "equipo")
    private List<Entrenador> entrenadores;

    // Getters y Setters
}