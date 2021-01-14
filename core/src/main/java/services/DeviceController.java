package services;

import domain.*;

import java.util.ArrayList;
import java.util.List;

public class DeviceController {

    public void printDefaultState(Hotel hotel) {
        List<Floor> floors = hotel.getFloor();
        Floor floor1 = new Floor();
        floor1.setFloorNo(1);
        List<MainCorridor> mainCorridors = new ArrayList<>();
        List<SubCorridor> subCorridors = new ArrayList<>();
        floor1.setMainCorridors(mainCorridors);
        floor1.setSubCorridors(subCorridors);
        floor1.initialize(1, 2);
        floors.add(floor1);

        for (int i = 0; i < mainCorridors.size(); i++) {
            System.out.println("Main corridor " +
                    "Light " + mainCorridors.get(i).getAc() +
                    " AC : " + mainCorridors.get(i).getLight());

        }

        for (int i = 0; i < subCorridors.size(); i++) {
            System.out.println("Sub corridor " +
                    "Light " + subCorridors.get(i).getAc() +
                    " AC : " + subCorridors.get(i).getLight());

        }

    }

    public void printModifiedState(Motion motion){
        Floor floor1 = new Floor();
        floor1.setFloorNo(1);
        List<MainCorridor> mainCorridors = new ArrayList<>();
        List<SubCorridor> subCorridors = new ArrayList<>();
        floor1.setMainCorridors(mainCorridors);
        floor1.setSubCorridors(subCorridors);
        floor1.initialize(1,2);
        int floor = motion.getFloor();
        int subCorridor = motion.getSubCorridor();
    }

}
