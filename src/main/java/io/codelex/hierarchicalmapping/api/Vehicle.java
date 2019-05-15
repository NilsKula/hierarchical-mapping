package io.codelex.hierarchicalmapping.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Vehicle {

    private final Long id;
    private final String vehicleType;
    private final String name;

}
