//package com.cinema.demo1.web;
//
//import com.cinema.demo1.entities.User;
//import com.cinema.demo1.service.RegistrationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@Service
//public class RegistrationController {
//    @Autowired
//    private RegistrationService service;
//
//
//    @PostMapping("/registeruser")
//    @CrossOrigin("*")
//    public User registerUser(@RequestBody User user) throws Exception {
//        String tempEmailId = user.getEmailId();
//        if(tempEmailId != null && !"".equals(tempEmailId)) {
//            User userObj = service.fetchUserByEmailId(tempEmailId);
//            if(userObj != null){
//                throw new Exception("user with "+tempEmailId+" is already exist");
//            }
//        }
//        User userObj = null;
//        userObj = service.saveUser(user);
//        return userObj;
//    }
//
//
//    @PostMapping("/login")
//    @CrossOrigin("*")
//    public User loginUser(@RequestBody User user) throws Exception {
//        String tempEmailId = user.getEmailId();
//        String tempPass = user.getPassword();
//        User userObj = null;
//        if(tempEmailId != null && tempPass != null){
//            userObj =  service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
//        }
//        if (userObj == null) {
//            throw new Exception("bad credentials");
//        }
//        return userObj;
//    }
//
//
//}
