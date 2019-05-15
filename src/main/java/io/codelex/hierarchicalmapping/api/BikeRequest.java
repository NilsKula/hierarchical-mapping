package io.codelex.hierarchicalmapping.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class BikeRequest {

    private final String name;
    private final String color;
}
