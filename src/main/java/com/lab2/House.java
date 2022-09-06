package com.lab2;



public abstract class House implements Cloneable {

    // members

    private String address;
    private String district;

    private Integer roomsCount;
    private Float squareMetersArea;

    private Float price;

    private Float metersToKindergarten;
    private Float metersToSchool;
    private Float metersToPlayground;

    // methods

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getRoomsCount() {
        return roomsCount;
    }
    public void setRoomsCount(Integer roomsCount) {
        this.roomsCount = roomsCount;
    }

    public Float getSquareMetersArea() {
        return squareMetersArea;
    }
    public void setSquareMetersArea(Float area) {
        this.squareMetersArea = area;
    }

    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        // round price to two decimal places
        this.price = Math.round(price * 100.0f) / 100.0f;
    }

    public Float getMetersToKindergarten() {
        return metersToKindergarten;
    }
    public void setMetersToKindergarten(Float meters) {
        metersToKindergarten = meters;
    }

    public Float getMetersToSchool() {
        return metersToSchool;
    }
    public void setMetersToSchool(Float meters) {
        metersToSchool = meters;
    }

    public Float getMetersToPlayground() {
        return metersToPlayground;
    }
    public void setMetersToPlayground(Float meters) {
        metersToPlayground = meters;
    }

    public abstract HouseType getType();

    private Float calculateAverageMetersToInfrastructureObjects() {
        return (metersToKindergarten + metersToSchool + metersToPlayground) / 3.0f;
    }

    public Float calculateRating() {
        final float RATING_SCALE_COEFFICIENT = 100_000.0f;

        return (squareMetersArea / price) * RATING_SCALE_COEFFICIENT / calculateAverageMetersToInfrastructureObjects();
    }

    public Object clone() {
        House clone = null;

        try {
            clone =  (House) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone exception, " + e);
        }
        return clone;
    }
    @Override
    public String toString() {
        return "Type[" + getType() + "] "
                + String.format(
                  "{Rating: %f, Addr: '%s', distr: '%s', rooms: %d, area: %f, price: %f, kindergartenM: %f, "
                          + "schoolM: %f, playgroundM: %f}",
                calculateRating(), address, district, roomsCount, squareMetersArea, price, metersToKindergarten,
                metersToSchool, metersToPlayground);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof House otherHouse) {
            return this.address.equalsIgnoreCase(otherHouse.address);
        } else {
            return false;
        }
    }
}
