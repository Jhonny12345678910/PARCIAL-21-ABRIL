package com.example.Equipodefutbol.Controller;

import com.example.Equipodefutbol.Service.EntrenadorService;
import com.example.Equipodefutbol.Model.Entrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")  // Ruta base para las peticiones REST
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    // Obtener todos los entrenadores
    @GetMapping
    public ResponseEntity<List<Entrenador>> getAllEntrenadores() {
        List<Entrenador> entrenadores = entrenadorService.getAllEntrenadores();
        return ResponseEntity.ok(entrenadores);
    }

    // Obtener un entrenador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> getEntrenadorById(@PathVariable Long id) {
        Entrenador entrenador = entrenadorService.getEntrenadorById(id);
        if (entrenador == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entrenador);
    }

    // Crear un nuevo entrenador
    @PostMapping
    public ResponseEntity<Entrenador> createEntrenador(@RequestBody Entrenador entrenador) {
        Entrenador newEntrenador = entrenadorService.createEntrenador(entrenador);
        return ResponseEntity.status(201).body(newEntrenador); // Status 201 Created
    }

    // Actualizar un entrenador existente
    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> updateEntrenador(@PathVariable Long id, @RequestBody Entrenador entrenador) {
        Entrenador updatedEntrenador = entrenadorService.updateEntrenador(id, entrenador);
        if (updatedEntrenador == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEntrenador);
    }

    // Eliminar un entrenador por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrenador(@PathVariable Long id) {
        if (entrenadorService.deleteEntrenador(id)) {
            return ResponseEntity.noContent().build(); // Status 204 No Content
        }
        return ResponseEntity.notFound().build();
    }
}

