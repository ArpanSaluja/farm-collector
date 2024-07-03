package FarmCollector;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Harvested {

    private @Id
    @GeneratedValue Long id;
    private int farmId;
    private String farmName;
    private String corpType;
    private int actualAmount;

    public Harvested() {
    }

    public Harvested(int farmId, String farmName, String corpType, int actualAmount) {
        this.farmId = farmId;
        this.farmName = farmName;
        this.corpType = corpType;
        this.actualAmount = actualAmount;
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

    public String getCorpType() {
        return corpType;
    }

    public void setCorpType(String corpType) {
        this.corpType = corpType;
    }

    public int getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(int actualAmount) {
        this.actualAmount = actualAmount;
    }

    @Override
    public String toString() {
        return "Harvested{" +
                "id=" + id +
                ", farmId=" + farmId +
                ", farmName='" + farmName + '\'' +
                ", corpType='" + corpType + '\'' +
                ", actualAmount=" + actualAmount +
                '}';
    }
}
