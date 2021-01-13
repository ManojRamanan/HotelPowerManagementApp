package domain;

import java.util.List;

public class Floor {

    private int floorNo;

    private List<MainCorridor> mainCorridors;
    private List<SubCorridor> subCorridors;

    public List<MainCorridor> getMainCorridors() {
        return mainCorridors;
    }

    public void setMainCorridors(List<MainCorridor> mainCorridors) {
        this.mainCorridors = mainCorridors;
    }

    public List<SubCorridor> getSubCorridors() {
        return subCorridors;
    }

    public void setSubCorridors(List<SubCorridor> subCorridors) {
        this.subCorridors = subCorridors;
    }

    public void initialize(int mainCorridors, int subCorridors) {
        for (int i = 0; i < mainCorridors; i++) {
            MainCorridor mainCorridor = new MainCorridor();
            this.getMainCorridors().add(mainCorridor);
        }
        for (int i = 0; i < subCorridors; i++) {
            this.getSubCorridors().add(new SubCorridor());
        }
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }
}


