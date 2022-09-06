package com.lab2;

import java.util.List;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        var hm = new HousingManager();

        List<House> foundHouses = hm.formAvailableHousingOffers("Frankivskii", 3, 6,
                30_000.0f, 100_000.0f);
        System.out.println("Found houses condition = (distr='Frankivskii', minRooms=3, maxRooms=6,"
                + " minPrice=30000, maxPrice=100000) :");
        foundHouses.forEach(System.out::println);

        List<House> foundHouses2 = hm.formAvailableHousingOffers("Frankivskii",
                60.0f, 100.0f,
                30_000.0f, 100_000.0f);
        System.out.println("\nFound houses condition = (distr='Frankivskii', minArea=60.0, maxRooms=100.0,"
                + " minPrice=30000, maxPrice=100000)");
        foundHouses2.forEach(System.out::println);

        List<House> sortedByPrice = hm.getHousesSortedByPrice(true);
        System.out.println("\nHouses sorted by price descending :");
        sortedByPrice.forEach(System.out::println);

        List<House> sortedByDistanceToKindergarten = hm.getHousesSortedByDistanceToKindergarten(false);
        System.out.println("\nHouses sorted by distance to kindergarten ascending :");
        sortedByDistanceToKindergarten.forEach(System.out::println);

        List<House> sortedByDistanceToSchool = hm.getHousesSortedByDistanceToSchool(true);
        System.out.println("\nHouses sorted by distance to school descending :");
        sortedByDistanceToSchool.forEach(System.out::println);

        List<House> sortedByRating = hm.getHousesSortedByRating(false);
        System.out.println("\nHouses sorted by rating ascending :");
        sortedByRating.forEach(System.out::println);
    }
}
