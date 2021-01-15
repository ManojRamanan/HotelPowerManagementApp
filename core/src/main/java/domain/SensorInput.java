package domain;

import Enums.Action;

public class SensorInput {

    private int floor;

    private int subCorridor ;

    private Action action;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSubCorridor() {
        return subCorridor;
    }

    public void setSubCorridor(int subCorridor) {
        this.subCorridor = subCorridor;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
