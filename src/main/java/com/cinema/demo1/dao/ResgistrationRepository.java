package com.cinema.demo1.dao;

import com.cinema.demo1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface ResgistrationRepository extends JpaRepository<User, Integer> {
    public User findAllByEmailId(String emailId);
    public User findByEmailIdAndPassword(String emailId, String password);
}
