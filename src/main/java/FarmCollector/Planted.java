package FarmCollector;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Planted {

    private @Id
    @GeneratedValue Long id;
    private int farmId;
    private int plantingArea;
    private String farmName;
    private String corpType;
    private int expectedAmount;

    public Planted() {
    }

    public Planted(int farmId,int plantingArea, String farmName, String corpType, int expectedAmount) {
        this.farmId = farmId;
        this.plantingArea = plantingArea;
        this.farmName = farmName;
        this.corpType = corpType;
        this.expectedAmount = expectedAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public int getPlantingArea() {
        return plantingArea;
    }

    public void setPlantingArea(int plantingArea) {
        this.plantingArea = plantingArea;
    }

    public String getCorpType() {
        return corpType;
    }

    public void setCorpType(String corpType) {
        this.corpType = corpType;
    }

    public int getExpectedAmount() {
        return expectedAmount;
    }

    public void setExpectedAmount(int expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    @Override
    public String toString() {
        return "Planted{" +
                "id=" + id +
                ", plantingArea=" + plantingArea +
                ", corpType='" + corpType + '\'' +
                ", expectedAmount=" + expectedAmount +
                '}';
    }
}
