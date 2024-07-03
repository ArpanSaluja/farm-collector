package FarmCollector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabaseOldNew(PlantedRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Planted(100,10,"Arpan Farm", "corn", 1000)));
            log.info("Preloading " + repository.save(new Planted(101,10,"Arpan Farm 2", "corn", 2000)));
        };
    }

    @Bean
    CommandLineRunner initDatabaseHarvested(HarvestedRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Harvested(100,"Arpan Farm", "corn", 2000)));
            log.info("Preloading " + repository.save(new Harvested(101,"Arpan Farm 2", "corn", 2000)));
        };
    }
}
