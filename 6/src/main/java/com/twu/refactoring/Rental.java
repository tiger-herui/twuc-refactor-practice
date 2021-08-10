package com.twu.refactoring;

public class Rental {
    private static final int REGULAR_RENTAL_AMOUNT = 2;
    private static final int REGULAR_RENTAL_TIME = 2;
    private static final double RENTAL_EXPIRE_CHARGE_RATE = 1.5;
    private static final int NEW_RELEASE_RENTAL_AMOUNT = 3;
    private static final double CHILDREN_RENTAL_AMOUNT = 1.5;
    private static final int CHILDREN_RENTAL_TIME = 3;
    private static final int NEW_RELEASE_FREQUENT_RENTAL_TIME = 1;
    private static final int NEW_RELEASE_FREQUENT_POINTS_MORE_THAN_2_DAYS = 2;
    private static final int NEW_RELEASE_FREQUENT_POINTS = 1;

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getAmount() {
        double thisAmount = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += REGULAR_RENTAL_AMOUNT;
                if (daysRented > REGULAR_RENTAL_TIME)
                    thisAmount += (daysRented - REGULAR_RENTAL_TIME) * RENTAL_EXPIRE_CHARGE_RATE;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += daysRented * NEW_RELEASE_RENTAL_AMOUNT;
                break;
            case Movie.CHILDRENS:
                thisAmount += CHILDREN_RENTAL_AMOUNT;
                if (daysRented > CHILDREN_RENTAL_TIME)
                    thisAmount += (daysRented - CHILDREN_RENTAL_TIME) * RENTAL_EXPIRE_CHARGE_RATE;
                break;
        }
        return thisAmount;
    }

    @Override
    public String toString() {
        return "\t" + movie.getTitle() + "\t"
                + getAmount() + "\n";
    }

    public int getRentalPoint() {
        return movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > NEW_RELEASE_FREQUENT_RENTAL_TIME ? NEW_RELEASE_FREQUENT_POINTS_MORE_THAN_2_DAYS : NEW_RELEASE_FREQUENT_POINTS;
    }
}