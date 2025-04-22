package com.example.Equipodefutbol.Model;

import jakarta.persistence.*;

import javax.persistence.*;

@Entity
public class EstadisticasJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Partido;
    private int goles;

    @ManyToOne
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "partido_id")
    private Partido partido;

    // Getters y Setters
}