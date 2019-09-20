package com.sha.microserviceusermanagement.services.impl;

import com.sha.microserviceusermanagement.model.User;
import com.sha.microserviceusermanagement.repository.UserRepository;
import com.sha.microserviceusermanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<String> findUsers(List<Long> idList) {
        return userRepository.findUserNames(idList);
    }
}
