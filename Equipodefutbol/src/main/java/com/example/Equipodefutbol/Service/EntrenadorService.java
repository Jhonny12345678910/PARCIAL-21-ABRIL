package com.example.Equipodefutbol.Service;

import com.example.Equipodefutbol.Model.Entrenador;
import com.example.Equipodefutbol.Repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    // Obtener todos los entrenadores
    public List<Entrenador> getAllEntrenadores() {
        return entrenadorRepository.findAll();
    }

    // Obtener un entrenador por ID
    public Entrenador getEntrenadorById(Long id) {
        Optional<Entrenador> entrenador = entrenadorRepository.findById(id);
        return entrenador.orElse(null);
    }

    // Crear un nuevo entrenador
    public Entrenador createEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    // Actualizar un entrenador
    public Entrenador updateEntrenador(Long id, Entrenador entrenador) {
        if (entrenadorRepository.existsById(id)) {
            entrenador.setId(id);
            return entrenadorRepository.save(entrenador);
        }
        return null;
    }

    // Eliminar un entrenador
    public boolean deleteEntrenador(Long id) {
        if (entrenadorRepository.existsById(id)) {
            entrenadorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
