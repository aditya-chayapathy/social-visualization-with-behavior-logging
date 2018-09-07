package com.assignment1.repository;

import com.assignment1.pojo.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    public Login findByUserIdAndTimestampAndLoginType(Long userId, Long timestamp, String loginType);

    public List<Login> findByUserId(Long userId);

    public List<Login> findByUserIdAndLoginType(Long userId, String loginType);

}