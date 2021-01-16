package services;

import Enums.State;
import domain.Hotel;
import domain.SensorInput;

public class NightTime  implements Command{

    Hotel hotel;

    public NightTime(Hotel hotel) {
        this.hotel = hotel;
    }


    @Override
    public void process() {
        this.hotel.getFloors().forEach(floor -> {
                floor.getMainCorridors().forEach(mainCorridor -> {
                    mainCorridor.getLight().setState(State.ON);
                });
        });

        hotel.printHotel();
    }
}
