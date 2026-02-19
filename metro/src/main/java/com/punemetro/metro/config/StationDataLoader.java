package com.punemetro.metro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.punemetro.metro.Entity.Station;
import com.punemetro.metro.Repository.Station_repo;

@Component
public class StationDataLoader implements CommandLineRunner {

    @Autowired
    private Station_repo stationRepository;

    @Override
    public void run(String... args) {

        if (stationRepository.count() == 0) {

            stationRepository.save(new Station("pcmc"));
            stationRepository.save(new Station("stn"));
            stationRepository.save(new Station("bhosri"));
            stationRepository.save(new Station("bopodi"));
            stationRepository.save(new Station("dapodi"));
            stationRepository.save(new Station("khadki"));
            stationRepository.save(new Station("shivaji_nagar"));
            stationRepository.save(new Station("civil_court"));
        }
    }
}

