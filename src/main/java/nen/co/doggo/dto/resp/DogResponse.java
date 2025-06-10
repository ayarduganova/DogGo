package nen.co.doggo.dto.resp;

public record DogResponse(
        String name,
        Integer birthMonth, // Месяц рождения (1-12)
        Integer birthYear,
        String breed
) {}
