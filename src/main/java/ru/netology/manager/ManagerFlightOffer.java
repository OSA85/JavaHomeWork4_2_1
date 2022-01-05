package ru.netology.manager;

import ru.netology.domain.FlightOffer;
import ru.netology.repository.RepositoryFlightOffer;

import java.util.Arrays;

public class ManagerFlightOffer {

    private RepositoryFlightOffer repo;

    public ManagerFlightOffer(RepositoryFlightOffer repo) {
        this.repo = repo;
    }

    public void addFlightOffer(RepositoryFlightOffer item) {
        repo.save(item);
    }


    public FlightOffer[] searchFlightOffer(String airportDeparture, String airportArrival) {
        FlightOffer[] result = new FlightOffer[0];
        for (FlightOffer flightOffer : repo.findAll()) {
            if (flightOffer.getAirportDeparture().contains(airportDeparture)) {
                if (flightOffer.getAirportArrival().contains(airportArrival)) {
                    FlightOffer[] tmp = new FlightOffer[result.length + 1];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    tmp[tmp.length - 1] = flightOffer;
                    result = tmp;
                }
                Arrays.sort(result);
            }
        }
        return result;
    }

}
