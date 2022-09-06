package com.lab2.parser;

import com.lab2.Flat;
import com.lab2.House;
import com.lab2.Mansion;
import org.json.simple.JSONObject;

public class MansionJsonObjectParser extends HouseJsonObjectParser {

    public static final String TAG_GARDEN_AVAILABILITY = "gardenAvailability";
    public static final String TAG_YARD_SQUARE_METERS_AREA = "yardSquareMetersArea";
    public static final String TAG_FLOORS_COUNT = "floorsCount";
    public static final String TAG_GARAGE_AVAILABILITY = "garageAvailability";
    public static final String TAG_MANSION_INFO = "mansionInfo";

    public MansionJsonObjectParser(JSONObject houseJsonObject) {
        super(houseJsonObject);
    }

    protected void parse(Mansion mansion) {
        super.parse(mansion);

        JSONObject mansionJsonObject = (JSONObject) jsonObject.get(TAG_MANSION_INFO);

        mansion.setGardenAvailability((boolean) mansionJsonObject.get(TAG_GARDEN_AVAILABILITY));
        mansion.setYardSquareMetersArea((float) (double) mansionJsonObject.get(TAG_YARD_SQUARE_METERS_AREA));
        mansion.setFloorsCount((int) (long) mansionJsonObject.get(TAG_FLOORS_COUNT));
        mansion.setGarageAvailability((boolean) mansionJsonObject.get(TAG_GARAGE_AVAILABILITY));
    }
    @Override
    public House parse() {
        Mansion parsedMansion = new Mansion();

        parse(parsedMansion);

        return parsedMansion;
    }


}
