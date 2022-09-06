package com.lab2;

public class Penthouse extends Flat {
    // members
    private Boolean poolAvailability;
    private Boolean stunningViews;

    // methods

    public Boolean getPoolAvailability() {
        return poolAvailability;
    }
    public void setPoolAvailability(Boolean poolAvailability) {
        this.poolAvailability = poolAvailability;
    }

    public Boolean getStunningViews() {
        return stunningViews;
    }
    public void setStunningViews(Boolean stunningViews) {
        this.stunningViews = stunningViews;
    }

    @Override
    public HouseType getType() {
        return HouseType.Penthouse;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("{pool: %b, stunning views: %b}", poolAvailability, stunningViews);
    }

    public Object clone() {
        return (Penthouse) super.clone();
    }
}
