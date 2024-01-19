package ru.t1.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CharacterFrequency {
    private Character character;
    private Long frequency;
}
