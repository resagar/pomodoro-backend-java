package com.resagar.pomodorobackend.controllers;

import com.resagar.pomodorobackend.dao.ConfigTimerDao;
import com.resagar.pomodorobackend.dto.CreateConfigTimerRequest;
import com.resagar.pomodorobackend.dto.UpdateConfigTimerRequest;
import com.resagar.pomodorobackend.entities.ConfigTimer;
import com.resagar.pomodorobackend.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/config/timer")
public class ConfigTimerController {

    private final ConfigTimerDao configTimerDao;

    @PostMapping
    public ResponseEntity<ConfigTimer> saveConfig(@RequestBody CreateConfigTimerRequest request) {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ConfigTimer config = ConfigTimer
                .builder()
                .id(request.getId())
                .workTimer(request.getWorkTimer())
                .shortTimer(request.getShortTimer())
                .largeTimer(request.getLargeTimer())
                .userId(userAuth.getId())
                .build();
        configTimerDao.save(config);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ConfigTimer> getConfigUser() {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ConfigTimer config = configTimerDao.findByUserId(userAuth.getId()).orElseThrow();
        return ResponseEntity.ok().body(config);
    }

    @PutMapping
    public ResponseEntity<ConfigTimer> updateConfigUser(@RequestBody UpdateConfigTimerRequest request) {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ConfigTimer config = configTimerDao.findByUserId(userAuth.getId()).orElseThrow();
        config.setWorkTimer(request.getWorkTimer());
        config.setShortTimer(request.getShortTimer());
        config.setLargeTimer(request.getLargeTimer());
        configTimerDao.save(config);
        return ResponseEntity.ok().build();
    }

}
