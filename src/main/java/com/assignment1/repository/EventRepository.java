package com.assignment1.repository;

import com.assignment1.pojo.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    public Event findByUserIdAndTimestampAndEventType(Long userId, Long timestamp, String eventType);

    public List<Event> findByUserId(Long userId);

    public List<Event> findByUserIdAndEventType(Long userId, String eventType);

}