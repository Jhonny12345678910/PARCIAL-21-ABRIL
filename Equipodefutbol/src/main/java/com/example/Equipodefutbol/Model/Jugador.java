package com.example.Equipodefutbol.Model;

import jakarta.persistence.*;

import javax.persistence.*;
import java.util.List;

@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador")
    private List<EstadisticasJugador> estadisticas;

    // Getters y Setters
}