package FarmCollector.report.controller;

import FarmCollector.harvested.dao.HarvestedRepository;
import FarmCollector.harvested.model.Harvested;
import FarmCollector.planted.model.Planted;
import FarmCollector.planted.dao.PlantedRepository;
import FarmCollector.report.model.Report;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        List<Harvested> harvestedList = harvestedRepository.findAll()
                .stream()
                .filter(item -> item.getFarmId() == planted.getFarmId())
                .collect(Collectors.toList());

        int actualAmount = !harvestedList.isEmpty() ? harvestedList.get(0).getActualAmount() : -1;
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
