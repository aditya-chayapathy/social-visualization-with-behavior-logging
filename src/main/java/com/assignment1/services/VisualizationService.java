package com.assignment1.services;

import com.assignment1.pojo.Event;
import com.assignment1.repository.EventRepository;
import com.assignment1.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VisualizationService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    LoginRepository loginRepository;

    public Map getKeyPressStats(Long userId) {
        List<Event> eventList = eventRepository.findByUserIdAndEventType(userId, "KEY_PRESS");
        HashMap<String, Integer> result = new HashMap<>();
        for (Event event : eventList) {
            String key = event.getEventInfo();
            if (result.containsKey(key)) {
                result.put(key, result.get(key) + 1);
            } else {
                result.put(key, 1);
            }
        }

        return result;
    }

}
