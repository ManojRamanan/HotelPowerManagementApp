package services;

import domain.Hotel;
import domain.SensorInput;

public interface DeviceContoller {

    public void execute();
    public void setCommand(Command command);


}
