package com.lab2.parser;

import com.lab2.Flat;
import com.lab2.House;
import org.json.simple.JSONObject;

public class FlatJsonObjectParser extends HouseJsonObjectParser {

    public static final String TAG_FLOOR = "floor";
    public static final String TAG_FLAT_NUMBER = "flatNumber";
    public static final String TAG_BALCONY_AVAILABILITY = "balconyAvailability";
    public static final String TAG_FLAT_INFO = "flatInfo";

    public FlatJsonObjectParser(JSONObject houseJsonObject) {
        super(houseJsonObject);
    }

    protected void parse(Flat flat) {
        super.parse(flat);

        JSONObject flatJsonObject = (JSONObject) jsonObject.get(TAG_FLAT_INFO);

        flat.setFloor(((Long) flatJsonObject.get(TAG_FLOOR)).intValue());
        flat.setFlatNumber((int) ((long) flatJsonObject.get(TAG_FLAT_NUMBER)));
        flat.setBalconyAvailability((boolean) flatJsonObject.get(TAG_BALCONY_AVAILABILITY));
    }

    @Override
    public House parse() {
        Flat parsedFlat = new Flat();

        parse(parsedFlat);

        return parsedFlat;
    }
}
