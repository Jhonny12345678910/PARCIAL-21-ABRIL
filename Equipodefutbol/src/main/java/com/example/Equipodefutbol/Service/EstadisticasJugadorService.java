package com.example.Equipodefutbol.Service;

import com.example.Equipodefutbol.Model.EstadisticasJugador;
import com.example.Equipodefutbol.Repository.EstadisticasJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticasJugadorService {

    @Autowired
    private EstadisticasJugadorRepository estadisticasJugadorRepository;

    // Obtener todas las estadísticas de jugadores
    public List<EstadisticasJugador> getAllEstadisticas() {
        return estadisticasJugadorRepository.findAll();
    }

    // Obtener una estadística de jugador por su ID
    public EstadisticasJugador getEstadisticaById(Long id) {
        Optional<EstadisticasJugador> estadisticasJugador = estadisticasJugadorRepository.findById(id);
        return estadisticasJugador.orElse(null);  // Si no se encuentra, devuelve null
    }

    // Crear una nueva estadística de jugador
    public EstadisticasJugador createEstadisticasJugador(EstadisticasJugador estadisticasJugador) {
        return estadisticasJugadorRepository.save(estadisticasJugador);
    }

    // Actualizar una estadística de jugador
    public EstadisticasJugador updateEstadisticasJugador(Long id, EstadisticasJugador estadisticasJugador) {
        if (estadisticasJugadorRepository.existsById(id)) {
            estadisticasJugador.setId(id);
            return estadisticasJugadorRepository.save(estadisticasJugador);
        } else {
            return null;
        }
    }

    // Eliminar una estadística de jugador
    public void deleteEstadisticasJugador(Long id) {
        estadisticasJugadorRepository.deleteById(id);
    }
}
