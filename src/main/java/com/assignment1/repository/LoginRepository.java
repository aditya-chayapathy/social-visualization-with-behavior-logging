package com.assignment1.repository;

import com.assignment1.pojo.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    public Login findByUserIdAndTimestampAndLoginType(Long userId, Long timestamp, String loginType);

    public List<Login> findTop8ByUserIdOrderByTimestampDesc(Long userId);

    public List<Login> findTop8ByUserIdAndLoginTypeOrderByTimestampDesc(Long userId, String loginType);

    public List<Login> findAllByUserIdAndLoginType(Long userId, String loginType);

    public List<Login> findAllByUserIdAndLoginTypeAndTimestampGreaterThanOrderByTimestampAsc(Long userId, String loginType, Long timestamp);

}