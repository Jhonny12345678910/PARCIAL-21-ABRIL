package com.example.Equipodefutbol.Service;

import com.example.Equipodefutbol.Model.Jugador;
import com.example.Equipodefutbol.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    // Obtener jugadores por equipo
    public List<Jugador> getJugadoresByEquipo(Long equipoId) {
        return jugadorRepository.findByEquipoId(equipoId);
    }

    // Obtener jugadores con más de X goles
    public List<Jugador> getJugadoresByGolesGreaterThan(int minGoles) {
        return jugadorRepository.findByGolesGreaterThan(minGoles);
    }

    // Obtener total de goles marcados por un equipo
    public Long getTotalGolesByEquipo(Long equipoId) {
        return jugadorRepository.findTotalGolesByEquipoId(equipoId);
    }

    // Obtener resultados de partidos
    public List<Object[]> getResultadosPartidos() {
        return jugadorRepository.getResultadosPartidos();
    }
}
