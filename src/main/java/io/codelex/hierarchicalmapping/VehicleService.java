package io.codelex.hierarchicalmapping;

import io.codelex.hierarchicalmapping.api.BikeRequest;
import io.codelex.hierarchicalmapping.api.CarRequest;
import io.codelex.hierarchicalmapping.api.Vehicle;
import io.codelex.hierarchicalmapping.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static io.codelex.hierarchicalmapping.VehicleType.Type.BIKE;
import static io.codelex.hierarchicalmapping.VehicleType.Type.CAR;

@Component
@RequiredArgsConstructor
public class VehicleService {

    private final BikeRepository bikeRepository;
    private final CarRepository carRepository;
    private final VehicleRepository vehicleRepository;
    
    void addBike(BikeRequest bikeRequest) {

        BikeRecord bikeRecord = new BikeRecord();
        bikeRecord.setVehicleType(String.valueOf(BIKE));
        bikeRecord.setName(bikeRequest.getName());
        bikeRecord.setColor(bikeRequest.getColor());
        bikeRepository.save(bikeRecord);

    }

    void addCar(CarRequest carRequest) {

        CarRecord carRecord = new CarRecord();
        carRecord.setVehicleType(String.valueOf(CAR));
        carRecord.setName(carRequest.getName());
        carRecord.setYear(carRequest.getYear());
        carRepository.save(carRecord);

    }

    List<Vehicle> fetchAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(this::vehicle)
                .collect(Collectors.toList());
    }

    List<Vehicle> fetchVehiclesByType(String type) {
        return vehicleRepository.findAllByVehicleType(type)
                .stream()
                .map(this::vehicle)
                .collect(Collectors.toList());
    }

    private Vehicle vehicle(VehicleRecord vehicleRecord) {
        return new Vehicle(
                vehicleRecord.getId(),
                vehicleRecord.getVehicleType(),
                vehicleRecord.getName()
        );
    }
}
