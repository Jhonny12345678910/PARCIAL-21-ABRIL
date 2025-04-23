package com.example.Equipodefutbol.Repository;

import com.example.Equipodefutbol.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    // Obtener jugadores por equipo
    @Query("SELECT j FROM Jugador j WHERE j.equipo.id = :equipoId")
    List<Jugador> findByEquipoId(Long equipoId);

    // Obtener jugadores con más de X goles
    @Query("SELECT j FROM Jugador j JOIN j.estadisticas ej WHERE ej.goles > :minGoles")
    List<Jugador> findByGolesGreaterThan(Integer minGoles);

    // Obtener el total de goles marcados por un equipo en todos sus partidos
    @Query("SELECT SUM(ej.goles) FROM EstadisticasJugador ej WHERE ej.jugador.equipo.id = :equipoId")
    Long findTotalGolesByEquipoId(Long equipoId);

    // Obtener los resultados de todos los partidos con los nombres de los equipos
    @Query("SELECT p.resultado, e1.nombre, e2.nombre FROM Partido p JOIN p.equipo1 e1 JOIN p.equipo2 e2")
    List<Object[]> findResultadosPartidos();

    List<Object[]> getResultadosPartidos();
}
