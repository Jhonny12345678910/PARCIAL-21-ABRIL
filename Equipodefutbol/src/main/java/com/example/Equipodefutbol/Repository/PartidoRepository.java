package com.example.Equipodefutbol.Repository;

import com.example.Equipodefutbol.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {

    // Consulta nativa que devuelve resultados sin DTO
    @Query(value = "SELECT e1.nombre AS equipo_local, e2.nombre AS equipo_visitante, p.goles_local, p.goles_visitante " +
            "FROM partido p " +
            "JOIN equipo e1 ON p.id_equipo_local = e1.id " +
            "JOIN equipo e2 ON p.id_equipo_visitante = e2.id", nativeQuery = true)
    List<Object[]> obtenerResultadosPartidos();
}


