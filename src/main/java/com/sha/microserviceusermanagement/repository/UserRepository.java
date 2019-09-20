package com.sha.microserviceusermanagement.repository;

import com.sha.microserviceusermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    @Query("SELECT u.name from User u WHERE u.id in (:pIdList)")
    List<String> findUserNames(@Param("pIdList") List<Long> idList);

}
