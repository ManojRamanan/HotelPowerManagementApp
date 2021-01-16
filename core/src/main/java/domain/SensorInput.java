package domain;

import Enums.Action;

import java.util.ArrayList;
import java.util.List;

public class SensorInput {

    private int floor;

    private int subCorridor ;

    public SensorInput(Builder builder) {
        this.floor = builder.floor;
        this.subCorridor = builder.subCorridor;
    }


    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSubCorridor() {
        return subCorridor;
    }

    public void setSubCorridor(int subCorridor) {
        this.subCorridor = subCorridor;
    }

    public static Builder builder(){
        return new Builder();
    }


    public static class Builder {

        private int floor;

        private int subCorridor;

        public Builder floor(int floor) {
            this.floor = floor;
            return this;
        }

        public Builder subCorridor(int subCorridor) {
            this.subCorridor = subCorridor;
            return this;
        }


        public SensorInput build() {
            return new SensorInput(this);
        }


    }


}
