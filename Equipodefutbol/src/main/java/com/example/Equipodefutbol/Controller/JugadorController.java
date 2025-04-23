package com.example.Equipodefutbol.Controller;

import com.example.Equipodefutbol.Model.Jugador;
import com.example.Equipodefutbol.Service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    // Obtener jugadores por equipo
    @GetMapping("/equipo/{equipoId}")
    public List<Jugador> getJugadoresByEquipo(@PathVariable Long equipoId) {
        return jugadorService.getJugadoresByEquipo(equipoId);
    }

    // Obtener jugadores con más de X goles
    @GetMapping("/goles/{minGoles}")
    public List<Jugador> getJugadoresByGolesGreaterThan(@PathVariable int minGoles) {
        return jugadorService.getJugadoresByGolesGreaterThan(minGoles);
    }

    // Obtener total de goles marcados por un equipo
    @GetMapping("/total-goles/{equipoId}")
    public Long getTotalGolesByEquipo(@PathVariable Long equipoId) {
        return jugadorService.getTotalGolesByEquipo(equipoId);
    }

    // Obtener resultados de partidos
    @GetMapping("/resultados")
    public List<Object[]> getResultadosPartidos() {
        return jugadorService.getResultadosPartidos();
    }
}
