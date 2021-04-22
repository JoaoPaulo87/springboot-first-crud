package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.models.*;
import com.example.demo.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapService {

    @Autowired
    private UsuarioRepository userRepository;

    public List<UserLocationDTO> getAllUsersLocation() {
        return ((List<UsuarioModel>) userRepository.findAll()).stream().map(this::convertToUserLocationDTO)
                .collect(Collectors.toList());
    }

    private UserLocationDTO convertToUserLocationDTO(UsuarioModel user) {
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO.setid(user.getId());
        userLocationDTO.setnombre(user.getNombre());
        Location location = user.getLocation();
        userLocationDTO.setLat(location.getLat());
        userLocationDTO.setLng(location.getLng());
        userLocationDTO.setPlace(location.getPlace());
        return userLocationDTO;
    }
}