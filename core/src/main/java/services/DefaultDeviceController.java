package services;

import Enums.State;
import domain.*;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

public class DefaultDeviceController implements DeviceContoller {


    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute(){
        command.process();
    }

}
