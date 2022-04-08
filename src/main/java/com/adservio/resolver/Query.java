package com.adservio.resolver;

import com.adservio.domain.Skill;
import com.adservio.domain.Talent;
import com.adservio.repository.SkillRepository;
import com.adservio.repository.TalentRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver {

    private TalentRepository talentRepository;
    private SkillRepository skillRepository;

    public Query(TalentRepository talentRepository, SkillRepository skillRepository) {
        this.talentRepository = talentRepository;
        this.skillRepository = skillRepository;
    }

    public Iterable<Talent> findAllTalents() {
        return talentRepository.findAll();
    }

    public Iterable<Skill> findAllSkills() {
        return skillRepository.findAll();
    }

    public long countTalents(){
        return talentRepository.count();
    }

    public long countSkills(){
        return skillRepository.count();
    }
}
