package FarmCollector.harvested.controller;

import FarmCollector.RecordNotFoundException;
import FarmCollector.harvested.dao.HarvestedRepository;
import FarmCollector.harvested.model.Harvested;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HarvestedController {

    private final HarvestedRepository repository;

    public HarvestedController(HarvestedRepository repository) {
        this.repository = repository;
    }

    @Operation(summary = "Get all Harvested",
            description = "Get all Harvested. The response is Harvested object with id, farm id, farm name, corp type and expected amount.")
    @GetMapping("/harvested")
    List<Harvested> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/harvested")
    Harvested harvested(@RequestBody Harvested harvested) {
        return repository.save(harvested);
    }

    @GetMapping("/harvested/{id}")
    Harvested one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }
}
