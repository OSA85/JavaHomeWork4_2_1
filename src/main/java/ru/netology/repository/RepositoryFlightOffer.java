package ru.netology.repository;

import ru.netology.domain.FlightOffer;

public class RepositoryFlightOffer extends FlightOffer {
    private RepositoryFlightOffer[] items = new RepositoryFlightOffer[0];

    public void save(RepositoryFlightOffer item) {
        int length = items.length + 1;
        RepositoryFlightOffer[] tmp = new RepositoryFlightOffer[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public RepositoryFlightOffer[] findAll() {
        return items;
    }



}
