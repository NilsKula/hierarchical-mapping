package io.codelex.hierarchicalmapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.codelex.hierarchicalmapping.api.BikeRequest;
import io.codelex.hierarchicalmapping.api.CarRequest;
import io.codelex.hierarchicalmapping.api.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    VehicleService vehicleService;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    public void should_be_able_to_add_new_bike() throws Exception {

        BikeRequest bikeRequest = new BikeRequest(
                "bike1",
                "black"
        );

        String json = MAPPER.writeValueAsString(bikeRequest);

        //expect
        mockMvc.perform(
                post("/api/bike")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void should_be_able_to_add_new_car() throws Exception {

        CarRequest carRequest = new CarRequest(
                "car1",
                1992
        );

        String json = MAPPER.writeValueAsString(carRequest);

        //expect
        mockMvc.perform(
                post("/api/car")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void should_return_list_of_vehicles() throws Exception {

        Vehicle vehicle = new Vehicle(
                1L,
                "BIKE",
                "bike1"
        );

        Mockito.lenient()
                .when(vehicleService.fetchAllVehicles())
                .thenReturn(Collections.singletonList(vehicle));

        //expect
        mockMvc.perform(
                get("/api/vehicles"))
                .andExpect(jsonPath("$", hasSize(1)));

    }
}