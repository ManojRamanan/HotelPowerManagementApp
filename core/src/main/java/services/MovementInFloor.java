package services;

import Enums.State;
import domain.Hotel;
import domain.SensorInput;

import java.time.LocalTime;

public class MovementInFloor implements Command {

    Hotel hotel;
    SensorInput sensorInput;

    public MovementInFloor(Hotel hotel, SensorInput sensorInput) {
        this.hotel = hotel;
        this.sensorInput = sensorInput;
    }

    @Override
    public void process() {
        SwitchOnLightInSubCorridor();
        adjustPowerUsage();
        hotel.printHotel();
    }

    private void adjustPowerUsage() {
        if (!PowerConsumption.getInstance().checkPowerLimitIsInRange(hotel,sensorInput)) {
            for (int i = 0; i < hotel.getFloors().get(sensorInput.getFloor() - 1).getSubCorridors().size(); i++) {
                hotel.getFloors().get(sensorInput.getFloor() - 1).getSubCorridors().get(i).getAc().setState(State.OFF);
                if(PowerConsumption.getInstance().checkPowerLimitIsInRange(hotel,sensorInput)){
                    break;
                }else {
                    continue;
                }
            }
        }
    }

    private void SwitchOnLightInSubCorridor() {
        this.hotel.getFloors().get(sensorInput.getFloor() - 1).getSubCorridors().
                get(sensorInput.getSubCorridor() - 1).getLight().setState(State.ON);
    }
}
