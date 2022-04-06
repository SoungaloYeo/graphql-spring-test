package com.adservio.domain;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    @GeneratedValue
    @GraphQLQuery(name = "id", description = "Talent's id")
    private Long id;
    @GraphQLQuery(name = "firstname", description = "Talent's firstname")
    private String firstname;
    @GraphQLQuery(name = "lastname", description = "Talent's lastname")
    private String lastname;
    private LocalDate startDate;

}
