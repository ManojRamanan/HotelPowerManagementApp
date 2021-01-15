package services;

import Enums.State;
import domain.*;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

public class DefaultDeviceController implements DeviceContoller {


    public void movementInFloor(Hotel hotel, SensorInput sensorInput) {
        LocalTime start = LocalTime.of(18, 0);
        LocalTime stop = LocalTime.of(6, 0);
        LocalTime now = LocalTime.now();
        Boolean isNowInRange = (!now.isBefore(start)) && now.isBefore(stop);
        hotel.getFloor().get(sensorInput.getFloor() - 1).getSubCorridors().get(sensorInput.getSubCorridor() - 1).getLight().setState(State.ON);
        PowerConsumption powerConsumption = new PowerConsumption();
        Integer totalPowerConsumption = powerConsumption.calculateTotalPowerConsumption(hotel.getFloor().get(sensorInput.getFloor() - 1));
        Integer maxPowerLimit = powerConsumption.fetchMaxPowerLimit(hotel.getFloor().get(sensorInput.getFloor() - 1));

        if (totalPowerConsumption > maxPowerLimit) {
            for (int i = 0; i < hotel.getFloor().get(sensorInput.getFloor() - 1).getSubCorridors().size(); i++) {
                hotel.getFloor().get(sensorInput.getFloor() - 1).getSubCorridors().get(i).getAc().setState(State.OFF);
                 totalPowerConsumption = powerConsumption.calculateTotalPowerConsumption(hotel.getFloor().get(sensorInput.getFloor() - 1));
                 maxPowerLimit = powerConsumption.fetchMaxPowerLimit(hotel.getFloor().get(sensorInput.getFloor() - 1));
                 if(totalPowerConsumption < maxPowerLimit){
                     break;
                 }else {
                     continue;
                 }
            }
            ;
        }

        Print(hotel);
    }


    public void noMoment(Hotel hotel, SensorInput sensorInput) {
        hotel.getFloor().get(sensorInput.getFloor() - 1).getSubCorridors().get(sensorInput.getSubCorridor() - 1).getLight().setState(State.OFF);
        hotel.getFloor().get(sensorInput.getFloor()).getSubCorridors().forEach(subCorridor -> {
            subCorridor.getAc().setState(State.ON);
        });
        Print(hotel);
    }


    public void Print(Hotel hotel) {
        hotel.getFloor().forEach(floor -> {

            System.out.println("Floor " + floor.getFloorNo());

            for (int i = 0; i < floor.getMainCorridors().size(); i++) {
                System.out.println("Main corridor " + (i + 1) +
                        " Light " + (i + 1) + " : " + floor.getMainCorridors().get(i).getLight().getState() +
                        " AC  :" + floor.getMainCorridors().get(i).getAc().getState());

            }

            for (int i = 0; i < floor.getSubCorridors().size(); i++) {
                System.out.println("Sub corridor " + (i + 1) +
                        " Light " + (i + 1) + " : " + floor.getSubCorridors().get(i).getLight().getState() +
                        " AC  :" + floor.getSubCorridors().get(i).getAc().getState());

            }
        });
    }

}
