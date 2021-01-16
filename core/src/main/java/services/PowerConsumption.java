package services;

import Enums.State;
import domain.*;

public class PowerConsumption {


    private static PowerConsumption instance;

    private PowerConsumption() {
    }

    public static PowerConsumption getInstance() {
        if (instance == null)
            instance = new PowerConsumption();
        return instance;
    }

    public Integer fetchMaxPowerLimit(Floor floor) {
        return floor.getMainCorridors().size() * 15 + floor.getSubCorridors().size() * 10;
    }


    public Integer calculateTotalPowerConsumption(Floor floor) {

        Integer powerConsumptionOfLights = 5;

        Integer powerConsumptionOfAcs = 10;

        int NoOfLights = 1;
        int NoOfAcs = 1;
        int sum = 0;
        for (MainCorridor mainCorridor : floor.getMainCorridors()) {
            if (mainCorridor.getLight().getState().equals(State.ON)) {
                sum = (NoOfLights * powerConsumptionOfLights);
            }
            if (mainCorridor.getAc().getState().equals(State.ON)) {
                sum = (powerConsumptionOfAcs * NoOfAcs) + sum;
            }
        }


        for (SubCorridor subCorridor : floor.getSubCorridors()) {
            if (subCorridor.getLight().getState().equals(State.ON)) {
                sum = (NoOfLights * powerConsumptionOfLights) + sum;
            }
            if (subCorridor.getAc().getState().equals(State.ON)) {
                sum = (powerConsumptionOfAcs * NoOfAcs) + sum;
                ;
            }
        }


        return sum;

    }

    public boolean checkPowerLimitIsInRange(Hotel hotel, SensorInput sensorInput) {

        Integer totalPowerConsumption = PowerConsumption.getInstance().
                calculateTotalPowerConsumption(hotel.getFloors().get(sensorInput.getFloor() - 1));

        Integer maxPowerLimit = PowerConsumption.getInstance().
                fetchMaxPowerLimit(hotel.getFloors().get(sensorInput.getFloor() - 1));

        return totalPowerConsumption > maxPowerLimit ? false:true;
    }


}
