package com.adservio.resolver;

import com.adservio.domain.Skill;
import com.adservio.domain.Talent;
import com.adservio.repository.SkillRepository;
import com.adservio.repository.TalentRepository;
import com.adservio.resolver.exceptions.SkillNotFoundException;
import com.adservio.resolver.exceptions.TalentNotFoundException;
import graphql.kickstart.tools.GraphQLMutationResolver;

import java.time.LocalDate;
import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {

    private TalentRepository talentRepository;
    private SkillRepository skillRepository;

    public Mutation(TalentRepository talentRepository, SkillRepository skillRepository) {
        this.talentRepository = talentRepository;
        this.skillRepository = skillRepository;
    }

    public Talent newTalent(String firstname, String lastname, Long skillId) {

        if(!this.skillRepository.existsById(skillId)) {
            throw new SkillNotFoundException("make sure you enter right skillId", skillId);
        } else {
            var talent = Talent.builder()
                    .firstname(firstname)
                    .lastname(lastname)
                    .startDate(LocalDate.now().toString())
                    .skill(Skill.builder().id(skillId)
                            .build())
                    .build();

            talentRepository.save(talent);

            return talent;
        }
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
                .orElseThrow(() -> new TalentNotFoundException("talent id not exist", id));

        Optional.ofNullable(firstname).ifPresent(talent::setFirstname);
        Optional.ofNullable(lastname).ifPresent(talent::setLastname);

        return talentRepository.save(talent);

    }

}
