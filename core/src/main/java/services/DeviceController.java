package services;

import domain.Floor;
import domain.MainCorridor;
import domain.Motion;
import domain.SubCorridor;

import java.util.ArrayList;
import java.util.List;

public class DeviceController {

    public void printDefaultState(int floor,int mainCorridor,int SubCorridor){
        Floor floor1 = new Floor();
        floor1.setFloorNo(1);
        List<MainCorridor> mainCorridors = new ArrayList<>();
        List<SubCorridor> subCorridors = new ArrayList<>();
        floor1.setMainCorridors(mainCorridors);
        floor1.setSubCorridors(subCorridors);
        floor1.initialize(1,2);
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
