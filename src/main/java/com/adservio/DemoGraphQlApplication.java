package com.adservio;

import com.adservio.domain.Skill;
import com.adservio.domain.Talent;
import com.adservio.repository.SkillRepository;
import com.adservio.repository.TalentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DemoGraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGraphQlApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(TalentRepository talentRepository, SkillRepository skillRepository) {
        return (args) -> {
            var skill1 = skillRepository.saveAndFlush(Skill.builder().designation("JAVA/JEE").build());
            var skill2 = skillRepository.saveAndFlush(Skill.builder().designation("ANGULAR").build());

            talentRepository.save(Talent.builder()
                    .firstname("Soungalo")
                    .lastname("YEO")
                    .startDate(LocalDate.now().toString())
                    .skill(skill1)
                    .build());

            talentRepository.save(Talent.builder()
                    .firstname("Maxime")
                    .lastname("BROU")
                    .startDate(LocalDate.now().toString())
                    .skill(skill2)
                    .build());
        };
    }

}
