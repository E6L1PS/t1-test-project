package ru.t1.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.api.dto.CharacterFrequency;
import ru.t1.api.service.FrequencyService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FrequencyController {
    private final FrequencyService frequencyService;

    @GetMapping("/calc")
    public List<CharacterFrequency> calculate(@RequestParam String line) {
        return frequencyService.calculateCharacterFrequency(line);
    }
}
