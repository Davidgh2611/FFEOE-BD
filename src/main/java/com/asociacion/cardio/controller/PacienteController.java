package com.asociacion.cardio.controller;

import com.asociacion.cardio.model.Paciente;
import com.asociacion.cardio.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    // === APARTADO 5: VISUALIZACIÓN (Consultar todos los pacientes) ===
    @GetMapping
    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll();
    }

    // Consultar un solo paciente por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPacientePorId(@PathVariable Long id) {
        return pacienteRepository.findById(id)
                .map(paciente -> ResponseEntity.ok().body(paciente))
                .orElse(ResponseEntity.notFound().build());
    }

    // === APARTADO 4: ALTA DE REGISTROS (Insertar nuevo paciente) ===
    @PostMapping
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // === APARTADO 6: GESTIÓN - MODIFICAR REGISTRO ===
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable Long id, @RequestBody Paciente datosActualizados) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    paciente.setNombre(datosActualizados.getNombre());
                    paciente.setApellidos(datosActualizados.getApellidos());
                    paciente.setTelefono(datosActualizados.getTelefono());
                    paciente.setCardiopatia(datosActualizados.getCardiopatia());
                    Paciente guardado = pacienteRepository.save(paciente);
                    return ResponseEntity.ok().body(guardado);
                }).orElse(ResponseEntity.notFound().build());
    }

    // === APARTADO 6: GESTIÓN - ELIMINAR REGISTRO ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    pacienteRepository.delete(paciente);
                    return ResponseEntity.noContent().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}