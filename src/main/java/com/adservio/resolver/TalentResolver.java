package com.adservio.resolver;

import com.adservio.domain.Skill;
import com.adservio.domain.Talent;
import com.adservio.repository.SkillRepository;
import graphql.kickstart.tools.GraphQLResolver;

import javax.persistence.EntityNotFoundException;

public class TalentResolver implements GraphQLResolver<Talent> {

    private SkillRepository skillRepository;

    public TalentResolver(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill getSkill(Talent talent){
        return skillRepository.findById(talent.getSkill().getId()).orElseThrow(EntityNotFoundException::new);
    }
}
