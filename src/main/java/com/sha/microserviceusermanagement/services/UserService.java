package com.sha.microserviceusermanagement.services;

import com.sha.microserviceusermanagement.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User findByUserName(String userName);

    List<String> findUsers(List<Long> idList);
}
