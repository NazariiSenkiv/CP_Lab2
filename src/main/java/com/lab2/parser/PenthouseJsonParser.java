package com.lab2.parser;

import com.lab2.House;
import com.lab2.Penthouse;
import org.json.simple.JSONObject;

public class PenthouseJsonParser extends FlatJsonObjectParser {

    public static final String TAG_POOL_AVAILABILITY = "poolAvailability";
    public static final String TAG_STUNNING_VIEWS = "stunningViews";
    public static final String TAG_PENTHOUSE_INFO = "penthouseInfo";

    public PenthouseJsonParser(JSONObject houseJsonObject) {
        super(houseJsonObject);
    }

    @Override
    public House parse() {
        Penthouse parsedPenthouse = new Penthouse();

        super.parse(parsedPenthouse);

        JSONObject penthouseJsonObject = (JSONObject) jsonObject.get(TAG_PENTHOUSE_INFO);

        parsedPenthouse.setPoolAvailability((boolean) penthouseJsonObject.get(TAG_POOL_AVAILABILITY));
        parsedPenthouse.setStunningViews((boolean) penthouseJsonObject.get(TAG_STUNNING_VIEWS));

        return parsedPenthouse;
    }
}
