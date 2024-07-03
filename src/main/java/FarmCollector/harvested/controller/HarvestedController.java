package FarmCollector.harvested.controller;

import FarmCollector.RecordNotFoundException;
import FarmCollector.harvested.dao.HarvestedRepository;
import FarmCollector.harvested.model.Harvested;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HarvestedController {

    private final HarvestedRepository repository;

    public HarvestedController(HarvestedRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/harvested")
    List<Harvested> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/harvested")
    Harvested newEmployee(@RequestBody Harvested newEmployee) {
        return repository.save(newEmployee);
    }

    @GetMapping("/harvested/{id}")
    Harvested one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }
}
