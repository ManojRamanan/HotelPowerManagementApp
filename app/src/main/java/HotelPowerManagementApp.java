import Enums.Action;
import domain.Hotel;
import domain.SensorInput;
import services.DefaultDeviceController;

public class HotelPowerManagementApp {


    public static void main(String[] args) {

        Hotel hotel = new Hotel();
        hotel.setNoOfFloors(2);
        hotel.setNoOfMainCorridors(1);
        hotel.setNoOfSubCorridors(2);

        DefaultDeviceController defaultDeviceController = new DefaultDeviceController();
        defaultDeviceController.Print(hotel);
        System.out.println("---------------------------------------------------");

        SensorInput sensorInput1 = new SensorInput();
        sensorInput1.setFloor(1);
        sensorInput1.setSubCorridor(2);
        sensorInput1.setAction(Action.MOVEMENT);
        defaultDeviceController.movementInFloor(hotel,sensorInput1);
        System.out.println("---------------------------------------------------");

        SensorInput sensorInput2 = new SensorInput();
        sensorInput2.setFloor(1);
        sensorInput2.setSubCorridor(2);
        sensorInput2.setAction(Action.NOMOVEMENT);
        defaultDeviceController.noMoment(hotel,sensorInput2);
    }


}

