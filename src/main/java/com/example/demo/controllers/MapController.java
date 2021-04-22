package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.UserLocationDTO;
import com.example.demo.services.MapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MapController {
  
    @Autowired
    private MapService mapService;

    @GetMapping("/map")
    @ResponseBody
    public List<UserLocationDTO> getAllUsersLocation() {
        List <UserLocationDTO> usersLocation = mapService.getAllUsersLocation();
        return usersLocation;
    }
}