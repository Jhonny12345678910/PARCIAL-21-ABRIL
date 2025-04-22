package com.example.Equipodefutbol.Model;

import jakarta.persistence.*;

import javax.persistence.*;

@Entity
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    // Getters y Setters
}