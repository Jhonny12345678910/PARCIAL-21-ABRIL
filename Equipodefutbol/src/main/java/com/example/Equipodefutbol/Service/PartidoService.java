package com.example.Equipodefutbol.Service;

import com.example.Equipodefutbol.Model.Partido;
import com.example.Equipodefutbol.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    // Obtener todos los partidos
    public List<Partido> getAllPartidos() {
        return partidoRepository.findAll();  // Devuelve todos los partidos de la base de datos
    }

    // Obtener un partido por su ID
    public Partido getPartidoById(Long id) {
        return partidoRepository.findById(id).orElse(null);  // Devuelve el partido si existe, de lo contrario null
    }

    // Crear un nuevo partido
    public Partido createPartido(Partido partido) {
        return partidoRepository.save(partido);  // Guarda el nuevo partido en la base de datos
    }

    // Actualizar un partido existente
    public Partido updatePartido(Long id, Partido partido) {
        if (partidoRepository.existsById(id)) {
            partido.setId(id);
            return partidoRepository.save(partido);  // Actualiza el partido con el ID correspondiente
        }
        return null;
    }

    // Eliminar un partido
    public void deletePartido(Long id) {
        partidoRepository.deleteById(id);  // Elimina el partido por su ID
    }
}
