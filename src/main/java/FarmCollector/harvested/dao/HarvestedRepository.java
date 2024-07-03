package FarmCollector.harvested.dao;

import FarmCollector.harvested.model.Harvested;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestedRepository extends JpaRepository<Harvested, Long> {

}
