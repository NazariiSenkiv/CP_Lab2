package com.lab2;

import org.json.simple.JSONObject;

public class Mansion extends House {
    // members

    private Boolean gardenAvailability;
    private Float yardSquareMetersArea;
    private Integer floorsCount;
    private Boolean garageAvailability;

    // methods

    public Boolean getGardenAvailability() {
        return gardenAvailability;
    }
    public void setGardenAvailability(Boolean gardenAvailability) {
        this.gardenAvailability = gardenAvailability;
    }

    public Float getYardSquareMetersArea() {
        return yardSquareMetersArea;
    }
    public void setYardSquareMetersArea(Float yardSquareMetersArea) {
        this.yardSquareMetersArea = yardSquareMetersArea;
    }

    public Integer getFloorsCount() {
        return floorsCount;
    }
    public void setFloorsCount(Integer floorsCount) {
        this.floorsCount = floorsCount;
    }


    public Boolean getGarageAvailability() {
        return garageAvailability;
    }
    public void setGarageAvailability(Boolean garageAvailability) {
        this.garageAvailability = garageAvailability;
    }

    @Override
    public HouseType getType() {
        return HouseType.Mansion;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("{garden: %b, yard area: %f, floors count: %d, garage availability: %b}",
                garageAvailability, yardSquareMetersArea, floorsCount, garageAvailability);
    }

    public Object clone() {
        return (Mansion)super.clone();
    }
}
