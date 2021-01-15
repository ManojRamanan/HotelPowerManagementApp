package domain;

import Enums.State;

public class Ac {

    private State state;


    private Integer consumptionRate;


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Integer getConsumptionRate() {
        return consumptionRate;
    }

    public void setConsumptionRate(Integer consumptionRate) {
        this.consumptionRate = consumptionRate;
    }
}
