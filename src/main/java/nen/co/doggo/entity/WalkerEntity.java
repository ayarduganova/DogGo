package nen.co.doggo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "walker")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    private String workExperience;
    private String workArea;
    private Integer price;

    @OneToOne
    @JoinColumn(name = "schedule_id")
    private ScheduleEntity schedule;
}
