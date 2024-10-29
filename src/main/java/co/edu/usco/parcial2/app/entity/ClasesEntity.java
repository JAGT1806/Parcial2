package co.edu.usco.parcial2.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name="clases")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClasesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String asignatura;

    @Column(length = 100)
    private String descripcion;

    private Integer salon;

    private LocalTime horaInicio;

    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private UserEntity profesor;
}
