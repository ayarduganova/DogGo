package nen.co.doggo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record DogRequest(
        String name,

        @Min(value = 1, message = "Месяц рождения не может быть меньше 1")
        @Max(value = 12, message = "Месяц рождения не может быть больше 12")
        Integer birthMonth,

        @Min(value = 1990, message = "Год рождения не может быть раньше 1990")
        @Max(value = 2025, message = "Год рождения не может быть в будущем")
        Integer birthYear,

        String breed){
}
