import Enums.Action;
import Enums.State;
import domain.Hotel;
import domain.SensorInput;
import org.junit.Assert;
import org.junit.Test;
import services.*;


public class HotelPowerManagementTests {

    @Test
    public void whenThereisMovementInFloorsSwitchOnLightAndPowerShouldBeBelowMaximum() {
        DeviceContoller deviceContoller = new DefaultDeviceController();
        Hotel hotel = Hotel.builder().noOfFloors(2).noOfMainCorridors(1).noOfSubCorridors(2).build();
        SensorInput sensorInput = SensorInput.builder().floor(1).subCorridor(2).build();
        Command movementInFloor = new MovementInFloor(hotel, sensorInput);
        deviceContoller.setCommand(movementInFloor);
        deviceContoller.execute();

        System.out.println("---------------------------------------------------");
        Assert.assertTrue(hotel.getFloors().get(sensorInput.getFloor() - 1).getSubCorridors()
                .get(sensorInput.getSubCorridor() - 1).getLight().getState().equals(State.ON));

        boolean isPowerUsageUnderControl = PowerConsumption.getInstance().checkPowerLimitIsInRange(hotel, sensorInput);

        Assert.assertTrue(isPowerUsageUnderControl);



    }





    @Test
    public void whenThereisNoMovementInFloors() {
        DeviceContoller deviceContoller = new DefaultDeviceController();
        Hotel hotel = Hotel.builder().noOfFloors(2).noOfMainCorridors(1).noOfSubCorridors(2).build();
        SensorInput sensorInput = SensorInput.builder().floor(1).subCorridor(2).build();
        Command noMoventInFloor = new NoMoventInFloor(hotel, sensorInput);
        deviceContoller.setCommand(noMoventInFloor);
        deviceContoller.execute();
        System.out.println("---------------------------------------------------");
        Assert.assertTrue(hotel.getFloors().get(sensorInput.getFloor() - 1).getSubCorridors()
                .get(sensorInput.getSubCorridor() - 1).getLight().getState().equals(State.OFF));
    }


}
