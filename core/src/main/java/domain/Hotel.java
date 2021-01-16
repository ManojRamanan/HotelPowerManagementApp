package domain;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private List<Floor> floors;

    public Hotel(Builder builder) {
        this.floors = builder.floors;
    }

    public Hotel(NightTimeBuilder nightTimeBuilder) {
        this.floors = nightTimeBuilder.floors;
    }


    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public static Builder builder(){
        return new Builder();
    }


    public static NightTimeBuilder nightTimeBuilder(){
        return new NightTimeBuilder();
    }



    public static class Builder {

        private int noOfFloors;

        private int noOfMainCorridors;

        private int noOfSubCorridors;

        private List<Floor> floors;

        public Builder noOfFloors(int noOfFloors) {
            this.noOfFloors = noOfFloors;
            return this;
        }

        public Builder noOfMainCorridors(int noOfMainCorridors) {
            this.noOfMainCorridors = noOfMainCorridors;
            return this;
        }

        public Builder noOfSubCorridors(int noOfSubCorridors) {
            this.noOfSubCorridors = noOfSubCorridors;
            return this;
        }

        public Builder floors(int noOfSubCorridors) {
            this.noOfSubCorridors = noOfSubCorridors;
            return this;
        }

        public Hotel build() {
            if ((this.floors == null || this.floors.isEmpty()) && this.noOfFloors > 0) {
                this.floors = new ArrayList<>();
                for (int i = 0; i < noOfFloors; i++) {
                    Floor floor = intializeFloors(i);
                    floor.initializeCorridors(1, 2);
                    this.floors.add(floor);
                }
            }
            return new Hotel(this);
        }


    }

    public static class NightTimeBuilder {

        private int noOfFloors;

        private int noOfMainCorridors;

        private int noOfSubCorridors;

        private List<Floor> floors;

        public NightTimeBuilder noOfFloors(int noOfFloors) {
            this.noOfFloors = noOfFloors;
            return this;
        }

        public NightTimeBuilder noOfMainCorridors(int noOfMainCorridors) {
            this.noOfMainCorridors = noOfMainCorridors;
            return this;
        }

        public NightTimeBuilder noOfSubCorridors(int noOfSubCorridors) {
            this.noOfSubCorridors = noOfSubCorridors;
            return this;
        }

        public NightTimeBuilder floors(int noOfSubCorridors) {
            this.noOfSubCorridors = noOfSubCorridors;
            return this;
        }

        public Hotel build() {
            if ((this.floors == null || this.floors.isEmpty()) && this.noOfFloors > 0) {
                this.floors = new ArrayList<>();
                for (int i = 0; i < noOfFloors; i++) {
                    Floor floor = intializeFloors(i);
                    floor.initializeDefaultCorridorNightTime(1, 2);
                    this.floors.add(floor);
                }
            }
            return new Hotel(this);
        }


    }

    private static Floor intializeFloors(int i) {
        Floor floor = new Floor();
        floor.setFloorNo(i + 1);
        List<MainCorridor> mainCorridors = new ArrayList<>();
        List<SubCorridor> subCorridors = new ArrayList<>();
        floor.setMainCorridors(mainCorridors);
        floor.setSubCorridors(subCorridors);
        return floor;
    }


    public void printHotel() {
        this.getFloors().forEach(floor -> {

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
