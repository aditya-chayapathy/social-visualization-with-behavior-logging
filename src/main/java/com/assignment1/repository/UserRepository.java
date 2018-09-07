package com.assignment1.repository;

import com.assignment1.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByNameAndPasswordAndAddress(String name, String password, String address);

}