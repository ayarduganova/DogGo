package nen.co.doggo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static nen.co.doggo.alert.AlertMessage.*;

public record UserRequest(

        @NotBlank(message = EMPTY_LOGIN)
        @Size(min = 3, max = 20, message = LENGTH_LOGIN)
        String username,

        @NotBlank(message = EMPTY_PASSWORD)
        @Size(min = 6, message = LENGTH_PASSWORD)
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).+$",
                message = CHARS_PASSWORD)
        String password,

        String firstName,
        String lastName,
        String gender,
        @Past(message = PAST_DATE)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        Date birthday,
        String email,
        @Pattern(regexp = "^\\+?[0-9]{11,12}$", message = PHONE_FORMAT)
        String phone){}
