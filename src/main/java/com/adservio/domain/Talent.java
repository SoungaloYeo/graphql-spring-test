package com.adservio.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Talent {

    @Id
    @Column(name="talent_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String startDate = LocalDate.now().toString();
    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false, updatable = false)
    private Skill skill;
}
