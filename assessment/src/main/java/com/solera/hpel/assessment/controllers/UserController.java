package com.solera.hpel.assessment.controllers;

import com.solera.hpel.assessment.models.User;
import com.solera.hpel.assessment.repositories.UserRepository;
import com.solera.hpel.assessment.services.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import main.java.com.solera.hpel.exceptions.DuplicateUserException;



@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private UserRepository repository;



    @PostMapping(path="/users")
    public ResponseEntity<User> register(@RequestBody @Valid  User user) {
        User uSaved;

        try {
            uSaved = service.register(user);
        } catch (DuplicateUserException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(uSaved);
    }

    @GetMapping(path="/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
  
}
