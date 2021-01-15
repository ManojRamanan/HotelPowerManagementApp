package domain;

import Enums.State;

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
            Ac ac = new Ac();
            ac.setState(State.ON);
            Light light = new Light();
            light.setState(State.ON);
            mainCorridor.setAc(ac);
            mainCorridor.setLight(light);
            this.getMainCorridors().add(mainCorridor);
        }
        for (int i = 0; i < subCorridors; i++) {
            SubCorridor subCorridor = new SubCorridor();
            Ac ac = new Ac();
            ac.setState(State.ON);
            subCorridor.setAc(ac);
            Light light = new Light();
            light.setState(State.OFF);
            subCorridor.setAc(ac);
            subCorridor.setLight(light);
            this.getSubCorridors().add(subCorridor);
        }

    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }
}


