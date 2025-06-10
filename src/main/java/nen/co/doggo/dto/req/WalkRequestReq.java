package nen.co.doggo.dto.req;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record WalkRequestReq(

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime walkDateTime,
        Integer duration
) {
}
