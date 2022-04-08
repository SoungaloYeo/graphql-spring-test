package com.adservio.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Skill {

    @Id
    @Column(name="skill_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String designation;
}
