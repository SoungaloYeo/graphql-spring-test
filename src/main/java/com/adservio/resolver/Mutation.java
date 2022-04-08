package com.adservio.resolver;

import com.adservio.domain.Skill;
import com.adservio.domain.Talent;
import com.adservio.repository.SkillRepository;
import com.adservio.repository.TalentRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {

    private TalentRepository talentRepository;
    private SkillRepository skillRepository;

    public Mutation(TalentRepository talentRepository, SkillRepository skillRepository) {
        this.talentRepository = talentRepository;
        this.skillRepository = skillRepository;
    }

    public Talent newTalent(String firstname, String lastname, String skillId) {

        var talent = Talent.builder()
                .firstname(firstname)
                .lastname(lastname)
                .startDate(LocalDate.now().toString())
                .skill(Skill.builder().id(1L)
                .build())
                .build();

        talentRepository.save(talent);

        return talent;
    }

    public Skill newSkill(String designation) {
        Skill skill = new Skill();
        skill.setDesignation(designation);

        skillRepository.save(skill);

        return skill;
    }

    public boolean deleteTalent(Long id) {
        talentRepository.deleteById(id);
        return true;
    }

    public Talent updateTalent(String firstname, String lastname, Long id) {

        var talent = talentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        Optional.ofNullable(firstname).ifPresent(talent::setFirstname);
        Optional.ofNullable(lastname).ifPresent(talent::setLastname);

        return talentRepository.save(talent);

    }

}
