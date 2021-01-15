package services;
import Enums.State;
import domain.Floor;
import domain.Light;
import domain.MainCorridor;
import domain.SubCorridor;

public class PowerConsumption {

    public Integer fetchMaxPowerLimit(Floor floor){
        return floor.getMainCorridors().size() * 15 + floor.getSubCorridors().size() *10;
    }


    public Integer calculateTotalPowerConsumption(Floor floor){

        Integer powerConsumptionOfLights = 5;

        Integer powerConsumptionOfAcs = 10;

        int NoOfLights = 1;
        int NoOfAcs = 1;
        int sum = 0 ;
        for (MainCorridor mainCorridor:floor.getMainCorridors()) {
            if(mainCorridor.getLight().getState().equals(State.ON)){
                sum =  (NoOfLights * powerConsumptionOfLights);
            }
            if(mainCorridor.getAc().getState().equals(State.ON)){
                sum = (powerConsumptionOfAcs * NoOfAcs) +  sum;
            }
        }


        for (SubCorridor subCorridor:floor.getSubCorridors()) {
            if(subCorridor.getLight().getState().equals(State.ON)){
                sum =  (NoOfLights * powerConsumptionOfLights) +  sum;
            }
            if(subCorridor.getAc().getState().equals(State.ON)){
                sum = (powerConsumptionOfAcs * NoOfAcs) +  sum;;
            }
        }



        return sum;

    }

}
