package com.lab2;

import com.lab2.parser.HousingFileJsonParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HousingManager {
    // members

    private List<House> houses = new ArrayList<House>();

    private final String jsonFilePath = "Houses.json";

    // methods

    public HousingManager() {
        HousingFileJsonParser jsonFileParser = new HousingFileJsonParser(jsonFilePath);

        houses = jsonFileParser.parseHouses();
    }

    public List<House> formAvailableHousingOffers(String district,
                                                  Integer minRoomsCount,
                                                  Integer maxRoomsCount,
                                                  Float minPrice,
                                                  Float maxPrice) {
        List<House> availableHouses = new ArrayList<>();
        houses.forEach(x -> availableHouses.add((House) x.clone()));

        return availableHouses.stream().filter(x -> x.getDistrict().equals(district))
                              .filter(x -> x.getRoomsCount() >= minRoomsCount && x.getRoomsCount() <= maxRoomsCount)
                              .filter(x -> (x.getPrice() >= minPrice && x.getPrice() <= maxPrice))
                              .toList();
    }

    public List<House> formAvailableHousingOffers(String district,
                                                  Float minSquareMetersArea,
                                                  Float maxSquareMetersArea,
                                                  Float minPrice,
                                                  Float maxPrice) {
        List<House> availableHouses = new ArrayList<>();
        houses.forEach(x -> availableHouses.add((House) x.clone()));

        return availableHouses.stream().filter(x -> x.getDistrict().equals(district))
                              .filter(x -> x.getSquareMetersArea() >= minSquareMetersArea
                                      && x.getSquareMetersArea() <= maxSquareMetersArea)
                              .filter(x -> (x.getPrice() >= minPrice && x.getPrice() <= maxPrice))
                              .toList();
    }

    public List<House> getHousesSortedByPrice(Boolean descendingSort) {
        List<House> sortedHouses = new ArrayList<>();
        houses.forEach(x -> sortedHouses.add((House) x.clone()));

        sortedHouses.sort(new HousePriceComparator(descendingSort));

        return sortedHouses;
    }

    public List<House> getHousesSortedByDistanceToKindergarten(Boolean descendingSort) {
        List<House> sortedHouses = new ArrayList<>();
        houses.forEach(x -> sortedHouses.add((House) x.clone()));

        sortedHouses.sort(new HouseDistanceToKindergartenComparator(descendingSort));

        return sortedHouses;
    }

    public List<House> getHousesSortedByDistanceToSchool(Boolean descendingSort) {
        List<House> sortedHouses = new ArrayList<>();
        houses.forEach(x -> sortedHouses.add((House) x.clone()));

        Comparator<House> comparator;

        if (descendingSort) {
            comparator = new Comparator<House>() {
                @Override
                public int compare(House h1, House h2) {
                    return h2.getMetersToSchool().compareTo(h1.getMetersToSchool());
                }
            };
        } else {
            comparator = new Comparator<House>() {
                @Override
                public int compare(House h1, House h2) {
                    return h1.getMetersToSchool().compareTo(h2.getMetersToSchool());
                }
            };
        }

        sortedHouses.sort(comparator);

        return sortedHouses;
    }

    public List<House> getHousesSortedByRating(Boolean descendingSort) {
        List<House> sortedHouses = new ArrayList<>();
        houses.forEach(x -> sortedHouses.add((House) x.clone()));

        Comparator<House> lambdaFunction;

        if (descendingSort) {
            lambdaFunction = (h1, h2) -> h2.calculateRating().compareTo(h1.calculateRating());
        } else {
            lambdaFunction = (h1, h2) -> h1.calculateRating().compareTo(h2.calculateRating());
        }

        sortedHouses.sort(lambdaFunction);

        return sortedHouses;
    }

    public void addHouse(House house) throws CloneNotSupportedException {
        houses.add((House)house.clone());
    }

    public void removeHouse(House house) {
        houses.remove(house);
    }

    static class HousePriceComparator implements Comparator<House> {

        private Boolean descendingSort;
        HousePriceComparator(boolean descendingSort) {
            this.descendingSort = descendingSort;
        }

        @Override
        public int compare(House house1, House house2) {
            return descendingSort
                    ? house2.getPrice().compareTo(house1.getPrice())
                    : house1.getPrice().compareTo(house2.getPrice());
        }
    }

    class HouseDistanceToKindergartenComparator implements Comparator<House> {

        private Boolean descendingSort;
        HouseDistanceToKindergartenComparator(boolean descendingSort) {
            this.descendingSort = descendingSort;
        }

        @Override
        public int compare(House house1, House house2) {
            return descendingSort
                    ? house2.getMetersToKindergarten().compareTo(house1.getMetersToKindergarten())
                    : house1.getMetersToKindergarten().compareTo(house2.getMetersToKindergarten());
        }
    }
}
