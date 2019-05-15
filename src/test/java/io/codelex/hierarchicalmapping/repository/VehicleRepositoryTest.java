package io.codelex.hierarchicalmapping.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static io.codelex.hierarchicalmapping.VehicleType.Type.BIKE;
import static io.codelex.hierarchicalmapping.VehicleType.Type.CAR;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class VehicleRepositoryTest {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    BikeRepository bikeRepository;

    @Autowired
    CarRepository carRepository;

    @Test
    public void should_return_all_vehicles() {

        BikeRecord bikeRecord = new BikeRecord();
        bikeRecord.setVehicleType(String.valueOf(BIKE));
        bikeRecord.setName("bike1");
        bikeRecord.setColor("black");
        bikeRepository.save(bikeRecord);

        CarRecord carRecord = new CarRecord();
        carRecord.setVehicleType(String.valueOf(CAR));
        carRecord.setName("car1");
        carRecord.setYear(1992);
        carRepository.save(carRecord);
        
        List<VehicleRecord> result = vehicleRepository.findAll();

        Assert.assertEquals(2, result.size());
    }

    @Test
    public void should_return_only_bikes() {
        BikeRecord bikeRecord = new BikeRecord();
        bikeRecord.setVehicleType(String.valueOf(BIKE));
        bikeRecord.setName("bike1");
        bikeRecord.setColor("black");
        bikeRepository.save(bikeRecord);

        CarRecord carRecord = new CarRecord();
        carRecord.setVehicleType(String.valueOf(CAR));
        carRecord.setName("car1");
        carRecord.setYear(1992);
        carRepository.save(carRecord);


        List<VehicleRecord> result = vehicleRepository.findAllByVehicleType("BIKE");

        Assert.assertEquals(1, result.size());
    }
}