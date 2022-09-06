package com.lab2;

import com.lab2.parser.HousingFileJsonParser;
import org.json.simple.JSONObject;

public class Flat extends House implements Cloneable {
    // members

    private Integer floor;
    private Integer flatNumber;
    private Boolean balconyAvailability;

    // methods

    public Integer getFloor() {
        return floor;
    }
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }
    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    public Boolean getBalconyAvailability() {
        return balconyAvailability;
    }
    public void setBalconyAvailability(Boolean balconyAvailability) {
        this.balconyAvailability = balconyAvailability;
    }

    @Override
    public HouseType getType() {
        return HouseType.Flat;
    }

    public Object clone() {
        return (Flat) super.clone();
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("{floor: %d, flat number: %d, balcony: %b}",
                floor, flatNumber, balconyAvailability);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Flat otherFlat) {
            return super.equals(otherFlat) && this.flatNumber.equals(otherFlat.flatNumber);
        } else {
            return false;
        }
    }
}
