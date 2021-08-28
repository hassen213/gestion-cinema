package com.cinema.demo1;

import com.cinema.demo1.entities.Film;
import com.cinema.demo1.entities.Projection;
import com.cinema.demo1.entities.Salle;
import com.cinema.demo1.entities.Ticket;
import com.cinema.demo1.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.io.Serializable;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {
    @Autowired
    private ICinemaInitService cinemaInitService;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;


    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Film.class, Salle.class, Ticket.class , Projection.class);
        cinemaInitService.initVilles();
        cinemaInitService.initCinemas();
        cinemaInitService.initSalles();
        cinemaInitService.initPlaces();
        cinemaInitService.initSeances();
        cinemaInitService.initCategories();
        cinemaInitService.initFilms();
        cinemaInitService.initProjections();
        cinemaInitService.initTicheks();

    }
}
