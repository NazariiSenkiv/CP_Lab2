package com.lab2.parser;

import com.lab2.EnumConverter;
import com.lab2.House;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class HousingFileJsonParser {
    protected static final String TAG_TYPE = "type";
    String filePath;

    public HousingFileJsonParser(String jsonFilePath) {
        filePath = jsonFilePath;
    }

    public List<House> parseHouses() {
        List<House> parsedHouses = new ArrayList<>();

        JSONParser parser = new JSONParser();

        try(FileReader reader = new FileReader(filePath)) {

            JSONArray housesJson = (JSONArray) parser.parse(reader);

            for (Object house : housesJson) {
                JSONObject houseJsonObject = (JSONObject) house;

                parsedHouses.add(parseHouseFromJsonObject(houseJsonObject));
            }

        } catch (Exception e) {
            System.out.println("Parse error: " + e);
        }

        return parsedHouses;
    }

    private House parseHouseFromJsonObject(JSONObject houseJsonObject) {

        String type = (String) houseJsonObject.get(TAG_TYPE);

        HouseJsonObjectParser jsonObjectParser = null;

        switch (EnumConverter.toHouseType(type)) {

            case Flat -> {
                jsonObjectParser = new FlatJsonObjectParser(houseJsonObject);
            }
            case Mansion -> {
                jsonObjectParser = new MansionJsonObjectParser(houseJsonObject);
            }
            case Penthouse -> {
                jsonObjectParser = new PenthouseJsonParser(houseJsonObject);
            }
            default -> throw new RuntimeException("Object parsing failed. Unknown house type");
        }

        return jsonObjectParser.parse();
    }
}
