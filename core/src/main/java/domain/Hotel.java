package domain;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private List<Floor> floor;

    private int noOfFloors;

    private int noOfMainCorridors;

    private int noOfSubCorridors;

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public int getNoOfMainCorridors() {
        return noOfMainCorridors;
    }

    public void setNoOfMainCorridors(int noOfMainCorridors) {
        this.noOfMainCorridors = noOfMainCorridors;
    }

    public int getNoOfSubCorridors() {
        return noOfSubCorridors;
    }

    public void setNoOfSubCorridors(int noOfSubCorridors) {
        this.noOfSubCorridors = noOfSubCorridors;
    }

    public List<Floor> getFloor() {
        if ((this.floor == null ||this.floor.isEmpty()) && this.noOfFloors > 0) {
            this.floor = new ArrayList<>();
            for (int i = 0; i < noOfFloors; i++) {
                Floor floor = new Floor();
                floor.setFloorNo(i+1);
                List<MainCorridor> mainCorridors = new ArrayList<>();
                List<SubCorridor> subCorridors = new ArrayList<>();
                floor.setMainCorridors(mainCorridors);
                floor.setSubCorridors(subCorridors);
                floor.initialize(1, 2);
                this.floor.add(floor);
            }
            return floor;
        }
        return floor;
    }

    public void setFloor(List<Floor> floor) {
        this.floor = floor;
    }
}
