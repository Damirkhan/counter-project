package com.example.counterproject.controller;

import com.example.counterproject.service.CounterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CounterController {
    private final CounterService counterService;

    @GetMapping("/code/next")
    public String getNextCode(@RequestParam(required = false) String currentCode) {
        return counterService.getNextCode(currentCode);
    }
}
