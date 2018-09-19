package com.assignment1.services;

import com.assignment1.pojo.Event;
import com.assignment1.pojo.Login;
import com.assignment1.repository.EventRepository;
import com.assignment1.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List getTimeSpentInAppStats(Long userId) {
        List<Login> loginList = loginRepository.findAllByUserIdAndLoginType(userId, "LOG_IN");
        List<Long> result = new ArrayList<>();
        for (Login login : loginList) {
            List<Login> logouts = loginRepository.findAllByUserIdAndLoginTypeAndTimestampGreaterThanOrderByTimestampAsc(userId, "LOG_OUT", login.getTimestamp());
            if (logouts.size() > 0) {
                result.add((logouts.get(0).getTimestamp() - login.getTimestamp()) / (1000));
            }
        }

        return result;
    }

    public Map getMouseTrajectoryStats(Long userId) {
        List<Event> eventList = eventRepository.findByUserIdAndEventType(userId, "MOUSE_MOVE");
        HashMap<String, List<Integer>> result = new HashMap<>();
        result.put("x", new ArrayList<>());
        result.put("y", new ArrayList<>());

        result.get("x").add(0);
        result.get("y").add(0);

        result.get("x").add(0);
        result.get("y").add(836);

        result.get("x").add(1680);
        result.get("y").add(0);

        result.get("x").add(1680);
        result.get("y").add(836);

        for (Event event : eventList) {
            String position = event.getEventInfo();
            result.get("x").add(Integer.parseInt(position.split(",")[0]));
            result.get("y").add(836 - Integer.parseInt(position.split(",")[1]));
        }

        return result;
    }

    public Map getActionCounts(Long userId) {
        Map<String, Integer> result = new HashMap<>();
        result.put("MOUSE CLICK", eventRepository.countByUserIdAndEventType(userId, "MOUSE_CLICK"));
        result.put("MOUSE DOUBLE CLICK", eventRepository.countByUserIdAndEventType(userId, "MOUSE_DOUBLE_CLICK"));
        result.put("TEXT COPY", eventRepository.countByUserIdAndEventType(userId, "COPY"));
        result.put("TEXT PASTE", eventRepository.countByUserIdAndEventType(userId, "PASTE"));
        result.put("KEY PRESS", eventRepository.countByUserIdAndEventType(userId, "KEY_PRESS"));

        return result;
    }

}
