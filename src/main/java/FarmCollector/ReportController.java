package FarmCollector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class ReportController {

    private final PlantedRepository repository;

    private final HarvestedRepository harvestedRepository;

    public ReportController(PlantedRepository repository,HarvestedRepository harvestedRepository) {
        this.repository = repository;
        this.harvestedRepository = harvestedRepository;
    }

    @GetMapping("/report")
    public String greeting(Model model) {
        model.addAttribute("reportDatas", getAllPlanted());
        return "report";
    }

    private Report converPlanedToReport(Planted planted){
        int actualAmount = harvestedRepository.findAll()
                                                .stream()
                                                .filter(item -> item.getFarmId() == planted.getFarmId())
                                                .collect(Collectors.toList())
                                                .get(0)
                                                .getActualAmount();
        return new Report(planted.getFarmId(), planted.getFarmName(), planted.getCorpType(), planted.getExpectedAmount(), actualAmount);
    }

    private List<Report> getAllPlanted(){
        List<Planted> planted= repository.findAll();
        List<Report> objectStream = planted
                .stream()
                .map((item) ->converPlanedToReport(item)).collect(Collectors.toList());
        return objectStream;
    }
}
