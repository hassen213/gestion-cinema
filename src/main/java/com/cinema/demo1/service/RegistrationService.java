package com.cinema.demo1.service;

import com.cinema.demo1.dao.ResgistrationRepository;
import com.cinema.demo1.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    public ResgistrationRepository repo;

    public User saveUser(User user){
        return repo.save(user);
    }

    public User fetchUserByEmailId(String email) {
        return repo.findAllByEmailId(email);

    }
    public User fetchUserByEmailIdAndPassword(String email, String password) {
        return repo.findByEmailIdAndPassword(email, password);

    }
}
