package ru.t1.api.service;

import org.springframework.stereotype.Service;
import ru.t1.api.dto.CharacterFrequency;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FrequencyService {

    public List<CharacterFrequency> calculateCharacterFrequency(String line) {
        return line.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .map(entry -> CharacterFrequency.builder()
                        .character(entry.getKey())
                        .frequency(entry.getValue())
                        .build())
                .sorted(Comparator.comparing(CharacterFrequency::getFrequency).reversed())
                .collect(Collectors.toList());
    }
}
