package services;

import Enums.State;
import domain.Hotel;
import domain.SensorInput;

public class NoMoventInFloor implements Command{

    Hotel hotel;
    SensorInput sensorInput;

    public NoMoventInFloor(Hotel hotel, SensorInput sensorInput){
        this.hotel = hotel;
        this.sensorInput = sensorInput;
    }

    public void process(){
        hotel.getFloors().get(sensorInput.getFloor() - 1).getSubCorridors().get(sensorInput.getSubCorridor() - 1).getLight().setState(State.OFF);
        hotel.getFloors().get(sensorInput.getFloor()).getSubCorridors().forEach(subCorridor -> {
            subCorridor.getAc().setState(State.ON);
        });
    }
}
