package FarmCollector.planted.dao;

import FarmCollector.planted.model.Planted;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantedRepository extends JpaRepository<Planted, Long> {

}