package ru.netology.manager;

import ru.netology.domain.FlightOffer;
import ru.netology.repository.RepositoryFlightOffer;

public class ManagerFlightOffer {

    private RepositoryFlightOffer repo;

    public ManagerFlightOffer(RepositoryFlightOffer repo) {
        this.repo = repo;
    }
    public void addFlightOffer(FlightOffer item) {
        repo.save(item);
    }


    public RepositoryFlightOffer getRepo() {
        return repo;
    }

    public void setRepo(RepositoryFlightOffer repo) {
        this.repo = repo;
    }




//    public FlightOffer[] searchFlightOffer(String airportDeparture, String airportArrival) {
//        FlightOffer[] result = new FlightOffer[0];
//        for (FlightOffer flightOffer : repo.findAll()) {
//            if (flightOffer.getAirportDeparture().contains(airportDeparture)) {
//                if (flightOffer.getAirportArrival().contains(airportArrival)) {
//                    FlightOffer[] tmp = new FlightOffer[result.length + 1];
//                    System.arraycopy(result, 0, tmp, 0, result.length);
//                    tmp[tmp.length - 1] = flightOffer;
//                    result = tmp;
//                }
//            }
//        }
//        return result;
//    }

    public FlightOffer[] findFlightOffer(String airportDeparture, String airportArrival) {
        FlightOffer[] offers = repo.findAll();
        FlightOffer[] result = new FlightOffer[0];
        for (FlightOffer offer : offers) {
            if (matches(offer, airportDeparture, airportArrival)) {
                int length = result.length + 1;
                FlightOffer[] tmp = new FlightOffer[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = offer;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(FlightOffer flightOffer, String airportDeparture, String airportArrival) {
        if (flightOffer.getAirportDeparture().contains(airportDeparture) && flightOffer.getAirportArrival().contains(airportArrival)) {
            return true;
        }
        return false;
    }

}
