package com.solera.hpel.assessment.services;

import com.solera.hpel.assessment.models.User;
import com.solera.hpel.assessment.repositories.UserRepository;
import java.util.Optional;
import lombok.extern.log4j.Log4j2;
import main.java.com.solera.hpel.exceptions.DuplicateUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService {

    @Autowired
    private UserRepository repository;

    public User register(User user) throws DuplicateUserException {
        Optional<User> bdUser = repository.findByEmail(user.getEmail());

        if(bdUser.isPresent()) {
            throw new DuplicateUserException("User Already Exists!");
        }

        repository.save(user);

        return user;
    }




}
