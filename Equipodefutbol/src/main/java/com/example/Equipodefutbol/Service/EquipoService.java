package com.example.Equipodefutbol.Service;

import com.example.Equipodefutbol.Model.Equipo;
import com.example.Equipodefutbol.Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    // Obtener todos los equipos
    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    // Obtener equipo por ID
    public Equipo getEquipoById(Long id) {
        Optional<Equipo> equipo = equipoRepository.findById(id);
        return equipo.orElse(null);
    }

    // Crear un nuevo equipo
    public Equipo createEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    // Actualizar un equipo
    public Equipo updateEquipo(Long id, Equipo equipo) {
        if (equipoRepository.existsById(id)) {
            equipo.setId(id);
            return equipoRepository.save(equipo);
        } else {
            return null; // o lanzar una excepción
        }
    }

    // Eliminar un equipo
    public void deleteEquipo(Long id) {
        equipoRepository.deleteById(id);
    }
}

