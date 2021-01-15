package services;

import domain.Hotel;
import domain.SensorInput;

public interface DeviceContoller {

    public void movementInFloor(Hotel hotel, SensorInput sensorInput);
    public void noMoment(Hotel hotel, SensorInput sensorInput);
}
