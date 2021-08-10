package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Customer {

    public static final String RENTAL_RECORD_FOR = "Rental Record for ";
    private static final String AMOUNT_OWED_IS = "Amount owed is ";
    private static final String YOU_EARNED = "\nYou earned ";
    private static final String FREQUENT_RENTER_POINTS = " frequent renter points";

    private String name;
    private ArrayList<Rental> rentalList = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentalList.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = rentalList.stream().mapToDouble(Rental::getAmount).sum();
        int frequentRenterPoints = rentalList.stream().mapToInt(Rental::getRentalPoint).sum();
        String result = RENTAL_RECORD_FOR + getName() + "\n";
        result += rentalList.stream().map(Rental::toString).collect(Collectors.joining());
        result += AMOUNT_OWED_IS + totalAmount;
        result += YOU_EARNED + frequentRenterPoints + FREQUENT_RENTER_POINTS;
        return result;
    }

}
