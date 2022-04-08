package com.adservio.resolver;

import com.adservio.domain.Skill;
import com.adservio.domain.Talent;
import com.adservio.repository.SkillRepository;
import com.adservio.resolver.exceptions.SkillNotFoundException;
import graphql.kickstart.tools.GraphQLResolver;

public class TalentResolver implements GraphQLResolver<Talent> {

    private SkillRepository skillRepository;

    public TalentResolver(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill getSkill(Talent talent){
        return skillRepository.findById(talent.getSkill().getId()).orElseThrow(()-> new SkillNotFoundException("skill is not exist", talent.getSkill().getId()));
    }
}
