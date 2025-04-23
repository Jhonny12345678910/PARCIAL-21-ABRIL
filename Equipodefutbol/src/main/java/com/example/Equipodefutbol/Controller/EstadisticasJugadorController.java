package com.example.Equipodefutbol.Controller;

import com.example.Equipodefutbol.Model.EstadisticasJugador;
import com.example.Equipodefutbol.Service.EstadisticasJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticasjugador")
public class EstadisticasJugadorController {

    @Autowired
    private EstadisticasJugadorService estadisticasJugadorService;

    // Obtener todas las estadísticas de jugadores
    @GetMapping
    public List<EstadisticasJugador> getAllEstadisticas() {
        return estadisticasJugadorService.getAllEstadisticas();
    }

    // Obtener estadísticas de un jugador por ID
    @GetMapping("/{id}")
    public ResponseEntity<EstadisticasJugador> getEstadisticaById(@PathVariable Long id) {
        EstadisticasJugador estadisticasJugador = estadisticasJugadorService.getEstadisticaById(id);
        if (estadisticasJugador != null) {
            return new ResponseEntity<>(estadisticasJugador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva estadística de jugador
    @PostMapping
    public ResponseEntity<EstadisticasJugador> createEstadisticasJugador(@RequestBody EstadisticasJugador estadisticasJugador) {
        EstadisticasJugador createdEstadisticas = estadisticasJugadorService.createEstadisticasJugador(estadisticasJugador);
        return new ResponseEntity<>(createdEstadisticas, HttpStatus.CREATED);
    }

    // Actualizar una estadística de jugador
    @PutMapping("/{id}")
    public ResponseEntity<EstadisticasJugador> updateEstadisticasJugador(@PathVariable Long id, @RequestBody EstadisticasJugador estadisticasJugador) {
        EstadisticasJugador updatedEstadisticas = estadisticasJugadorService.updateEstadisticasJugador(id, estadisticasJugador);
        if (updatedEstadisticas != null) {
            return new ResponseEntity<>(updatedEstadisticas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una estadística de jugador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadisticasJugador(@PathVariable Long id) {
        estadisticasJugadorService.deleteEstadisticasJugador(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

