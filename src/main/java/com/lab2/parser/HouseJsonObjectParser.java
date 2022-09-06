package com.lab2.parser;

import com.lab2.House;
import org.json.simple.JSONObject;

public abstract class HouseJsonObjectParser {
    private static final String TAG_ADDRESS = "address";
    private static final String TAG_DISTRICT = "district";
    private static final String TAG_ROOMS_COUNT = "roomsCount";
    private static final String TAG_SQUARE_METERS_AREA = "squareMetersArea";
    private static final String TAG_PRICE = "price";
    private static final String TAG_METERS_TO_KINDERGARTEN = "metersToKindergarten";
    private static final String TAG_METERS_TO_SCHOOL = "metersToSchool";
    private static final String TAG_METERS_TO_PLAYGROUND = "metersToPlayground";
    private static final String TAG_GENERAL_HOUSE_INFO = "generalHouseInfo";

    protected JSONObject jsonObject;

    public HouseJsonObjectParser(JSONObject houseJsonObject) {
        this.jsonObject = houseJsonObject;
    }

    protected void parse(House house) {

        JSONObject houseJsonObject = (JSONObject) jsonObject.get(TAG_GENERAL_HOUSE_INFO);

        house.setAddress((String) houseJsonObject.get(TAG_ADDRESS));
        house.setDistrict((String) houseJsonObject.get(TAG_DISTRICT));

        house.setRoomsCount((int) (long) houseJsonObject.get(TAG_ROOMS_COUNT));
        house.setSquareMetersArea((float) ((double) houseJsonObject.get(TAG_SQUARE_METERS_AREA)));

        house.setPrice((float) ((double) houseJsonObject.get(TAG_PRICE)));

        house.setMetersToKindergarten((float) ((double) houseJsonObject.get(TAG_METERS_TO_KINDERGARTEN)));
        house.setMetersToSchool((float) ((double) houseJsonObject.get(TAG_METERS_TO_SCHOOL)));
        house.setMetersToPlayground((float) ((double) houseJsonObject.get(TAG_METERS_TO_PLAYGROUND)));
    }

    public abstract House parse();
}
