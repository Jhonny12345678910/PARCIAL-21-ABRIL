package com.example.Equipodefutbol.Controller;

import com.example.Equipodefutbol.Model.Partido;
import com.example.Equipodefutbol.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    // Obtener todos los partidos
    @GetMapping
    public List<Partido> getAllPartidos() {
        return partidoService.getAllPartidos();  // Llama al servicio para obtener todos los partidos
    }

    // Obtener un partido por ID
    @GetMapping("/{id}")
    public Partido getPartidoById(@PathVariable Long id) {
        return partidoService.getPartidoById(id);  // Llama al servicio para obtener un partido por ID
    }

    // Crear un nuevo partido
    @PostMapping
    public Partido createPartido(@RequestBody Partido partido) {
        return partidoService.createPartido(partido);  // Llama al servicio para crear un nuevo partido
    }

    // Actualizar un partido existente
    @PutMapping("/{id}")
    public Partido updatePartido(@PathVariable Long id, @RequestBody Partido partido) {
        return partidoService.updatePartido(id, partido);  // Llama al servicio para actualizar un partido
    }

    // Eliminar un partido
    @DeleteMapping("/{id}")
    public void deletePartido(@PathVariable Long id) {
        partidoService.deletePartido(id);  // Llama al servicio para eliminar un partido
    }
}

