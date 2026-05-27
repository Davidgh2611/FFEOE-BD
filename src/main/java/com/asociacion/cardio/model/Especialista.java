package com.asociacion.cardio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "especialistas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Especialista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String especialidad;

    // Un especialista puede impartir muchos talleres
    @OneToMany(mappedBy = "especialista", cascade = CascadeType.ALL)
    private List<Taller> talleres;
}