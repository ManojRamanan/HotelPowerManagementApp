import Enums.Action;
import Enums.State;
import domain.Hotel;
import domain.SensorInput;
import org.junit.Assert;
import org.junit.Test;
import services.DefaultDeviceController;


public class HotelPowerManagementTests {

    @Test
    public void whenThereisMovementInFloors(){
        DefaultDeviceController defaultDeviceController = new DefaultDeviceController();
        Hotel hotel = new Hotel();
        hotel.setNoOfFloors(2);
        hotel.setNoOfMainCorridors(1);
        hotel.setNoOfSubCorridors(2);
        SensorInput sensorInput1 = new SensorInput();
        sensorInput1.setFloor(1);
        sensorInput1.setSubCorridor(2);
        sensorInput1.setAction(Action.MOVEMENT);
        defaultDeviceController.movementInFloor(hotel,sensorInput1);
        System.out.println("---------------------------------------------------");
        Assert.assertTrue(hotel.getFloor().get(sensorInput1.getFloor()-1).getSubCorridors()
                .get(sensorInput1.getSubCorridor()-1).getLight().getState().equals(State.ON));
    }

    @Test
    public void whenThereisNoMovementInFloors(){
        DefaultDeviceController defaultDeviceController = new DefaultDeviceController();
        Hotel hotel = new Hotel();
        hotel.setNoOfFloors(2);
        hotel.setNoOfMainCorridors(1);
        hotel.setNoOfSubCorridors(2);
        SensorInput sensorInput1 = new SensorInput();
        sensorInput1.setFloor(1);
        sensorInput1.setSubCorridor(2);
        sensorInput1.setAction(Action.NOMOVEMENT);
        defaultDeviceController.noMoment(hotel,sensorInput1);
        System.out.println("---------------------------------------------------");
        Assert.assertTrue(hotel.getFloor().get(sensorInput1.getFloor()-1).getSubCorridors()
                .get(sensorInput1.getSubCorridor()-1).getLight().getState().equals(State.OFF));
    }
}
