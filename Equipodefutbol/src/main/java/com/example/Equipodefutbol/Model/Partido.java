package com.example.Equipodefutbol.Model;

import jakarta.persistence.*;

import javax.persistence.*;
import java.util.List;

@Entity
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fecha;

    @ManyToOne
    @JoinColumn(name = "equipo_local_id")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante_id")
    private Equipo equipoVisitante;

    @OneToMany(mappedBy = "partido")
    private List<EstadisticasJugador> estadisticasJugadores;

    // Getters y Setters
}
