package com.adservio.config;

import com.adservio.repository.SkillRepository;
import com.adservio.repository.TalentRepository;
import com.adservio.resolver.Mutation;
import com.adservio.resolver.Query;
import com.adservio.resolver.TalentResolver;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GraphqlConfique extends SpringBootServletInitializer {

    @Bean
    public TalentResolver TalentResolver(SkillRepository skillRepository) {
        return new TalentResolver(skillRepository);
    }

    @Bean
    public Query query(TalentRepository talentRepository, SkillRepository skillRepository) {
        return new Query(talentRepository, skillRepository);
    }

    @Bean
    public Mutation mutation(TalentRepository talentRepository, SkillRepository skillRepository) {
        return new Mutation(talentRepository, skillRepository);
    }
}
