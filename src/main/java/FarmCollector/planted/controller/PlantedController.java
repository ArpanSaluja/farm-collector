package FarmCollector.planted.controller;

import FarmCollector.RecordNotFoundException;
import FarmCollector.planted.dao.PlantedRepository;
import FarmCollector.planted.model.Planted;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlantedController {

    private final PlantedRepository repository;

    public PlantedController(PlantedRepository repository) {
        this.repository = repository;
    }

    @Operation(summary = "Get all planted",
            description = "Get all planted. The response is Planted object with id, farm id, planting area, farm name, corp type and expected amount.")
    @GetMapping("/planted")
    List<Planted> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @Operation(summary = "Post planted details",
            description = "Post planted details. The response is Planted object with id, farm id, planting area, farm name, corp type and expected amount.")
    @PostMapping("/planted")
    Planted planted(@RequestBody Planted planted) {
        return repository.save(planted);
    }

    @Operation(summary = "Get planted for specific id",
            description = "Get planted for specific id. For supporting staff to get specific record.")
    @GetMapping("/planted/{id}")
    Planted one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }
}
