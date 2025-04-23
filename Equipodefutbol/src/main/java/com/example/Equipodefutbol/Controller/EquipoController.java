package com.example.Equipodefutbol.Controller;

import com.example.Equipodefutbol.Service.EquipoService;
import com.example.Equipodefutbol.Model.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    // Obtener todos los equipos
    @GetMapping
    public List<Equipo> getAllEquipos() {
        return equipoService.getAllEquipos();
    }

    // Obtener equipo por ID
    @GetMapping("/{id}")
    public Equipo getEquipoById(@PathVariable Long id) {
        return equipoService.getEquipoById(id);
    }

    // Crear un nuevo equipo
    @PostMapping
    public Equipo createEquipo(@RequestBody Equipo equipo) {
        return equipoService.createEquipo(equipo);
    }

    // Actualizar un equipo
    @PutMapping("/{id}")
    public Equipo updateEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
        return equipoService.updateEquipo(id, equipo);
    }

    // Eliminar un equipo
    @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable Long id) {
        equipoService.deleteEquipo(id);
    }
}
