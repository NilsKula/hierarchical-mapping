package io.codelex.hierarchicalmapping.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
public class VehicleRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String vehicleType;
    private String name;

}
