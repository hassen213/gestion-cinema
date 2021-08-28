package com.cinema.demo1.web;

import com.cinema.demo1.dao.FilmRepository;
import com.cinema.demo1.dao.ProjectionRepository;
import com.cinema.demo1.dao.TicketRepository;
import com.cinema.demo1.entities.Film;
import com.cinema.demo1.entities.Projection;
import com.cinema.demo1.entities.Ticket;
import com.cinema.demo1.entities.User;
import com.cinema.demo1.service.CinemaInitServiceImpl;
import com.cinema.demo1.service.RegistrationService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("*")
public class CinemaRestController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private RegistrationService service;
    @Autowired
    private ProjectionRepository projectionRepository;

    @PostMapping("/registeruser")
    @CrossOrigin("*")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmailId();
        if(tempEmailId != null && !"".equals(tempEmailId)) {
            User userObj = service.fetchUserByEmailId(tempEmailId);
            if(userObj != null){
                throw new Exception("user with "+tempEmailId+" is already exist");
            }
        }
        User userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }


    @PostMapping("/login")
    @CrossOrigin("*")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmailId();
        String tempPass = user.getPassword();
        User userObj = null;
        if(tempEmailId != null && tempPass != null){
            userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
        }
        if (userObj == null) {
            throw new Exception("bad credentials");
        }
        return userObj;
    }

    @GetMapping("/filmss")
    public List<Film> getallfilms(){
        return filmRepository.findAll();
    }

    @GetMapping("/projectionss")
    public List<Projection> getallprojections(){
        return projectionRepository.findAll();
    }


    @PostMapping("/ajouterfilm")
    @CrossOrigin("*")
    public Film ajouterFilm(@RequestBody Film film) throws Exception {
        return filmRepository.save(film);
    }



    @GetMapping(path = "/imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable(name = "id")Long id) throws Exception{
        Film f=filmRepository.findById(id).get();
        String photoName=f.getPhoto();
        File file=new File(System.getProperty("user.home")+"/cinema/image/"+photoName);
        Path path=Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    @PostMapping("/payerTickets")
    @Transactional
    public List<Ticket> payerTickets(@RequestBody TicketFrom ticketFrom){
        List<Ticket> listTickets=new ArrayList<>();
        ticketFrom.getTickets().forEach(idTicket->{
            //System.out.println(idTicket);
            Ticket ticket=ticketRepository.findById(idTicket).get();
            ticket.setNomClient(ticketFrom.getNomClient());
            ticket.setReserve(true);
            ticketRepository.save(ticket);
        });
        return listTickets;
    }
}

@Data
class TicketFrom{
    private String nomClient;
    private int codePayement;
    private List<Long> tickets=new ArrayList<>();

}
