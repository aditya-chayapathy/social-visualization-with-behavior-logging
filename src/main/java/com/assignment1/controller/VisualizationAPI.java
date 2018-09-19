package com.assignment1.controller;

import com.assignment1.services.VisualizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/visualization")
public class VisualizationAPI {

    @Autowired
    VisualizationService visualizationService;

    @RequestMapping(value = "/getKeyPressStats", method = RequestMethod.GET)
    public Map getKeyPressStats(@RequestParam(value = "userId") Long userId) {
        return visualizationService.getKeyPressStats(userId);
    }

}
