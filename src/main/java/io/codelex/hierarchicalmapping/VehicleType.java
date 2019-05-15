package io.codelex.hierarchicalmapping;

import lombok.Data;

@Data
public class VehicleType {

    public enum Type {
        BIKE, CAR
    }

    public Type type;

    VehicleType(Type type) {
        this.type = type;
    }
}
