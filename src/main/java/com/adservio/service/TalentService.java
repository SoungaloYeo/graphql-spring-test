package com.adservio.service;

import com.adservio.domain.Talent;
import com.adservio.repository.TalentRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@GraphQLApi
@Slf4j
@Service
public class TalentService {

    private final TalentRepository talentRepository;

    public TalentService(TalentRepository talentRepository) {
        this.talentRepository = talentRepository;
    }

    @GraphQLQuery(name = "talent")
    Optional<Talent> getTalent(@GraphQLArgument(name = "id") Long id) {
        log.info("retrieve talent with given Id");
        return talentRepository.findById(id);
    }

    @GraphQLQuery(name = "talents")
    public List<Talent> getTalents() {
        log.info("retrieve all talent");
        return talentRepository.findAll();
    }

    @GraphQLMutation(name = "saveTalent")
    public Talent saveTalent(@GraphQLArgument(name = "talent") Talent talent) {
        log.info("save a talent");
        Objects.requireNonNull(talent, "talent should be not Null");
        talent.setStartDate(LocalDate.now());
        return talentRepository.save(talent);
    }

    @GraphQLMutation(name = "deleteTalent")
    public void deleteTalent(@GraphQLArgument(name = "id") Long id) {
        log.info("delete a talent");
        talentRepository.deleteById(id);
    }

}
