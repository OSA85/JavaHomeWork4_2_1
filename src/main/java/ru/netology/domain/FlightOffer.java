package ru.netology.domain;

import java.util.Objects;

public class FlightOffer implements Comparable<FlightOffer> {
    private int id;
    private int price;
    private String airportDeparture;
    private String airportArrival;
    private int timeFlight;


    public FlightOffer() {
    }

    public FlightOffer(String airportDeparture, String airportArrival) {
        this.airportDeparture = airportDeparture;
        this.airportArrival = airportArrival;
    }

    public FlightOffer(int id, int price, String airportDeparture, String airportArrival, int timeFlight) {
        this.id = id;
        this.price = price;
        this.airportDeparture = airportDeparture;
        this.airportArrival = airportArrival;
        this.timeFlight = timeFlight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAirportDeparture() {
        return airportDeparture;
    }

    public void setAirportDeparture(String airportDeparture) {
        this.airportDeparture = airportDeparture;
    }

    public String getAirportArrival() {
        return airportArrival;
    }

    public void setAirportArrival(String airportArrival) {
        this.airportArrival = airportArrival;
    }

    public int getTimeFlight() {
        return timeFlight;
    }

    public void setTimeFlight(int timeFlight) {
        this.timeFlight = timeFlight;
    }

    @Override
    public int compareTo(FlightOffer o) {
        return this.price - o.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightOffer that = (FlightOffer) o;
        return id == that.id && price == that.price &&
                timeFlight == that.timeFlight &&
                Objects.equals(airportDeparture, that.airportDeparture) &&
                Objects.equals(airportArrival, that.airportArrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, airportDeparture, airportArrival, timeFlight);
    }

    @Override
    public String toString() {
        return "FlightOffer{" +
                "id=" + id +
                ", price=" + price +
                ", airportDeparture='" + airportDeparture + '\'' +
                ", airportArrival='" + airportArrival + '\'' +
                ", timeFlight=" + timeFlight +
                '}';
    }
}
