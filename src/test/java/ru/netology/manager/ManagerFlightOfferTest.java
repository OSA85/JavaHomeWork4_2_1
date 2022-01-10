package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightOffer;
import ru.netology.repository.RepositoryFlightOffer;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ManagerFlightOfferTest {
    RepositoryFlightOffer repo = new RepositoryFlightOffer();

    ManagerFlightOffer manager = new ManagerFlightOffer(repo);

    FlightOffer item1 = new FlightOffer(1, 200, "GSV", "DME", 120);
    FlightOffer item2 = new FlightOffer(2, 250, "GSV", "DME", 130);
    FlightOffer item3 = new FlightOffer(3, 300, "GSV", "DME", 100);
    FlightOffer item4 = new FlightOffer(4, 200, "GSV", "DME", 110);
    FlightOffer item5 = new FlightOffer(5, 260, "DME", "GSV", 130);
    FlightOffer item6 = new FlightOffer(6, 270, "DME", "EGO", 110);
    FlightOffer item7 = new FlightOffer(7, 290, "DME", "FRU", 400);
    FlightOffer item8 = new FlightOffer(8, 600, "DME", "VVO", 600);

    @BeforeEach
    public void addAll() {
        manager.addFlightOffer(item1);
        manager.addFlightOffer(item2);
        manager.addFlightOffer(item3);
        manager.addFlightOffer(item4);
        manager.addFlightOffer(item5);
        manager.addFlightOffer(item6);
        manager.addFlightOffer(item7);
        manager.addFlightOffer(item8);
    }
    @Test
    public void findAllFlightOffer() { //поиск всех предложений по перелету без сортировки
        FlightOffer[] expected = {item1, item2, item3, item4, item5, item6, item7, item8};
        FlightOffer[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findOnTwoAirportOnPriceUp() {//поиск по двум аэропортам, с сортировкой по цене
        FlightOffer[] expected = new FlightOffer[] {item1, item4, item2, item3};
        FlightOffer[] actual = manager.findFlightOffer("GSV","DME");

//        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }
    @Test
    public void findOnTwoAirportEmptyListOffer() {//нет таких предложений
        FlightOffer[] expected = new FlightOffer[] {};
        FlightOffer[] actual = manager.findFlightOffer("GSV","GSV");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findOnTwoAirportOneInListOffer() {//одно предложение по перелёту
        FlightOffer[] expected = new FlightOffer[] {item8};
        FlightOffer[] actual = manager.findFlightOffer("DME","VVO");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

}