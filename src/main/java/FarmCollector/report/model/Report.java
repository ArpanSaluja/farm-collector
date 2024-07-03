package FarmCollector.report.model;

public class Report {

    private int farmId;
    private String farmName;
    private String corpType;
    private int expectedAmount;
    private int actualAmount;

    public Report() {
    }

    public Report(int farmId, String farmName, String corpType, int expectedAmount, int actualAmount) {
        this.farmId = farmId;
        this.farmName = farmName;
        this.corpType = corpType;
        this.expectedAmount = expectedAmount;
        this.actualAmount = actualAmount;
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

    public int getExpectedAmount() {
        return expectedAmount;
    }

    public void setExpectedAmount(int expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    public int getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(int actualAmount) {
        this.actualAmount = actualAmount;
    }

    @Override
    public String toString() {
        return "Report{" +
                "farmId=" + farmId +
                ", farmName='" + farmName + '\'' +
                ", corpType='" + corpType + '\'' +
                ", expectedAmount=" + expectedAmount +
                ", actualAmount=" + actualAmount +
                '}';
    }
}
