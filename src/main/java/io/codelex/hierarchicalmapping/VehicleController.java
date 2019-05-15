package io.codelex.hierarchicalmapping;

import io.codelex.hierarchicalmapping.api.BikeRequest;
import io.codelex.hierarchicalmapping.api.CarRequest;
import io.codelex.hierarchicalmapping.api.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping("/bike")
    public void addBike(@RequestBody BikeRequest bikeRequest) {

        vehicleService.addBike(bikeRequest);
    }

    @PostMapping("/car")
    public void addCar(@RequestBody CarRequest carRequest) {
        vehicleService.addCar(carRequest);
    }

    @GetMapping("/vehicles")
    @ResponseBody
    public List<Vehicle> fetchVehicles(@RequestParam(value = "type", required = false, defaultValue = "") String type) {

        if (type.equals("BIKE") || type.equals("CAR")) {
            return vehicleService.fetchVehiclesByType(type);
        } else {
            return vehicleService.fetchAllVehicles();
        }
    }
}

