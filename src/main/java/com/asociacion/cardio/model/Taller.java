package com.asociacion.cardio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "talleres")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Taller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, name = "fecha_hora")
    private LocalDateTime fechaHora;

    @Column(nullable = false, name = "cupo_maximo")
    private Integer cupoMaximo;

    // Muchos talleres pertenecen a un único especialista
    @ManyToOne
    @JoinColumn(name = "especialista_id", foreignKey = @ForeignKey(name = "FK_ESPECIALISTA_TALLER"))
    private Especialista especialista;

    // Un taller puede tener muchas inscripciones
    @OneToMany(mappedBy = "taller", cascade = CascadeType.ALL)
    private List<Inscripcion> inscripciones;
}