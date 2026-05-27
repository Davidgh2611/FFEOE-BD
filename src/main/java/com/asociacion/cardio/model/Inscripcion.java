package com.asociacion.cardio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "inscripciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Muchas inscripciones corresponden a un paciente
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PACIENTE_INSCRIPCION"))
    private Paciente paciente;

    // Muchas inscripciones corresponden a un taller
    @ManyToOne
    @JoinColumn(name = "taller_id", nullable = false, foreignKey = @ForeignKey(name = "FK_TALLER_INSCRIPCION"))
    private Taller taller;

    @Column(nullable = false, name = "fecha_registro")
    private LocalDate fechaRegistro = LocalDate.now();
}