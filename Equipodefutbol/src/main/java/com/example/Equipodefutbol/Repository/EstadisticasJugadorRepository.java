package com.example.Equipodefutbol.Repository;

import com.example.Equipodefutbol.Model.EstadisticasJugador;
import com.example.Equipodefutbol.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadisticasJugadorRepository extends JpaRepository<EstadisticasJugador, Long> {

    // 1. Obtener todos los jugadores de un equipo específico
    @Query("SELECT ej.jugador FROM EstadisticasJugador ej WHERE ej.jugador.equipo.id = :equipoId")
    List<Jugador> findJugadoresByEquipoId(Long equipoId);

    // 2. Obtener los jugadores que han marcado más de X goles
    @Query("SELECT ej.jugador FROM EstadisticasJugador ej WHERE ej.goles > :goles")
    List<Jugador> findJugadoresByGolesMarcadosGreaterThan(int goles);

    // 3. Obtener el número total de goles marcados por un equipo en todos sus partidos
    @Query("SELECT SUM(ej.goles) FROM EstadisticasJugador ej WHERE ej.jugador.equipo.id = :equipoId")
    Integer findTotalGolesByEquipoId(Long equipoId);

    // 4. Obtener los resultados de todos los partidos, indicando los nombres de los equipos
    @Query("SELECT p.fecha, el.nombre, ev.nombre, p.golesLocal, p.golesVisitante " +
            "FROM Partido p " +
            "JOIN p.equipoLocal el " +
            "JOIN p.equipoVisitante ev")
    List<Object[]> findResultadosDePartidos();
}
