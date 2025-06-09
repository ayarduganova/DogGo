package nen.co.doggo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "schedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private WalkerEntity walker;

    private LocalTime mondayFrom;
    private LocalTime mondayTo;
    private LocalTime tuesdayFrom;
    private LocalTime tuesdayTo;
    private LocalTime wednesdayFrom;
    private LocalTime wednesdayTo;
    private LocalTime thursdayFrom;
    private LocalTime thursdayTo;
    private LocalTime fridayFrom;
    private LocalTime fridayTo;
    private LocalTime saturdayFrom;
    private LocalTime saturdayTo;
    private LocalTime sundayFrom;
    private LocalTime sundayTo;

}
