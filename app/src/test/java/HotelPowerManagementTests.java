import Enums.State;
import domain.Hotel;
import domain.SensorInput;
import org.junit.Assert;
import org.junit.Test;
import services.*;


public class HotelPowerManagementTests {


    @Test
    public void switchOnMainCorridorLightDuringNight() {
        DeviceContoller deviceContoller = new DefaultDeviceController();
        Hotel hotel = Hotel.builder().noOfFloors(2).noOfMainCorridors(1).noOfSubCorridors(2).build();
        Command movementInFloor = new NightTime(hotel);
        deviceContoller.setCommand(movementInFloor);
        deviceContoller.execute();

        System.out.println("---------------------------------------------------");
        hotel.getFloors().forEach(floor -> {
            boolean anyMatch = floor.getMainCorridors().stream().anyMatch(mainCorridor -> mainCorridor.getLight().getState().equals(State.OFF));
            Assert.assertFalse(anyMatch);
        });

    }


    @Test
    public void whenThereIsMovementInFloors() {
        DeviceContoller deviceContoller = new DefaultDeviceController();
        Hotel hotel = Hotel.nightTimeBuilder().noOfFloors(2).noOfMainCorridors(1).noOfSubCorridors(2).build();
        SensorInput sensorInput = SensorInput.builder().floor(1).subCorridor(2).build();
        Command movementInFloor = new MovementInFloor(hotel, sensorInput);
        deviceContoller.setCommand(movementInFloor);
        deviceContoller.execute();

        System.out.println("---------------------------------------------------");
        Assert.assertTrue(hotel.getFloors().get(sensorInput.getFloor() - 1).getSubCorridors()
                .get(sensorInput.getSubCorridor() - 1).getLight().getState().equals(State.ON));;

    }

    @Test
    public void whenThereIsMovementInFloorsPowerShouldBeBelowMaximum() {
        DeviceContoller deviceContoller = new DefaultDeviceController();
        Hotel hotel = Hotel.nightTimeBuilder().noOfFloors(2).noOfMainCorridors(1).noOfSubCorridors(2).build();
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
    public void whenThereIsNoMovementInFloors() {
        DeviceContoller deviceContoller = new DefaultDeviceController();
        Hotel hotel = Hotel.nightTimeBuilder().noOfFloors(2).noOfMainCorridors(1).noOfSubCorridors(2).build();
        SensorInput sensorInput = SensorInput.builder().floor(1).subCorridor(2).build();
        Command noMovementInFloor = new NoMovementInFloor(hotel, sensorInput);
        deviceContoller.setCommand(noMovementInFloor);
        deviceContoller.execute();
        System.out.println("---------------------------------------------------");
        Assert.assertTrue(hotel.getFloors().get(sensorInput.getFloor() - 1).getSubCorridors()
                .get(sensorInput.getSubCorridor() - 1).getLight().getState().equals(State.OFF));
    }


}
