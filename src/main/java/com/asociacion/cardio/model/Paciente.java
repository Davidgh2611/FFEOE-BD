package com.asociacion.cardio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "pacientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(nullable = false, length = 15)
    private String telefono;

    @Column(length = 100)
    private String cardiopatia;

    // Un paciente puede tener muchas inscripciones
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Inscripcion> inscripciones;
}