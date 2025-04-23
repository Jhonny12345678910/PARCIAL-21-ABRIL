package com.example.Equipodefutbol.Repository;

import com.example.Equipodefutbol.Model.Equipo;
import com.example.Equipodefutbol.Model.Jugador; // Asegúrate de tener el modelo Jugador importado
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    // Obtener todos los jugadores de un equipo específico
    @Query(value = "SELECT j.* FROM jugador j INNER JOIN equipo e ON j.id_equipo = e.id WHERE e.id = :equipoId", nativeQuery = true)
    List<Jugador> findJugadoresByEquipo(Long equipoId);

    // Obtener los jugadores que han marcado más de X goles
    @Query(value = "SELECT j.* FROM jugador j WHERE j.goles > :goles", nativeQuery = true)
    List<Jugador> findJugadoresByGolesGreaterThan(int goles);

    // Obtener el número total de goles marcados por un equipo en todos sus partidos
    @Query(value = "SELECT SUM(j.goles) FROM jugador j INNER JOIN equipo e ON j.id_equipo = e.id WHERE e.id = :equipoId", nativeQuery = true)
    Integer getTotalGolesPorEquipo(Long equipoId);

    // Obtener los resultados de todos los partidos indicando los nombres de los equipos
    @Query(value = "SELECT e.nombre AS equipo_local, ep.nombre AS equipo_visitante, r.resultado FROM partido p " +
            "INNER JOIN equipo e ON p.equipo_local_id = e.id " +
            "INNER JOIN equipo ep ON p.equipo_visitante_id = ep.id " +
            "INNER JOIN resultado r ON p.resultado_id = r.id", nativeQuery = true)
    List<Object[]> getResultadosDePartidos();
}


