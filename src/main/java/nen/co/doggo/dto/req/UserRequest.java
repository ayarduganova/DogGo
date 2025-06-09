package nen.co.doggo.dto.req;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static nen.co.doggo.alert.AlertMessage.*;

public record UserRequest(

        @Size(min = 3, max = 20, message = LENGTH_LOGIN)
        String username,

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
