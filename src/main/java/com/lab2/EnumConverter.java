package com.lab2;

public class EnumConverter {

    public static HouseType toHouseType(String enumString) {
        return switch (enumString.toLowerCase()) {
            case "flat" -> HouseType.Flat;
            case "mansion" -> HouseType.Mansion;
            case "penthouse" -> HouseType.Penthouse;
            case "apartment" -> HouseType.Apartment;
            case "townhouse" -> HouseType.Townhouse;
            case "bungalow" -> HouseType.Bungalow;
            default -> HouseType.Unknown;
        };
    }

    public static String toString(HouseType type) {
        return switch (type) {
            case Flat -> "flat";
            case Mansion -> "mansion";
            case Penthouse -> "penthouse";
            case Apartment -> "apartment";
            case Townhouse -> "townhouse";
            case Bungalow -> "bungalow";
            default -> "unknown";
        };
    }
}
